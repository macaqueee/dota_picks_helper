package dota_buff_parser.service;

import dota_advisor.model.Hero;
import dota_advisor.repository.HeroRepository;
import dota_buff_parser.config.AppConfigHolder;
import dota_buff_parser.exception.ApplicationException;
import dota_buff_parser.parser.HeroPageParser;
import dota_buff_parser.utils.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DotaBuffHeroUpdaterService implements HeroUpdaterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DotaBuffHeroUpdaterService.class);

    private final AppConfigHolder appConfigHolder;
    private final HeroPageParser heroPageParser;
    private final HeroRepository heroRepository;
    private final CollectionUtils collectionUtils;

    @Autowired
    public DotaBuffHeroUpdaterService(AppConfigHolder appConfigHolder, HeroPageParser heroPageParser,
                                      HeroRepository heroRepository, CollectionUtils collectionUtils) {
        this.appConfigHolder = appConfigHolder;
        this.heroPageParser = heroPageParser;
        this.heroRepository = heroRepository;
        this.collectionUtils = collectionUtils;
    }

    @Override
    public List<Hero> updateHeroes() throws ApplicationException {

        // getAll heroes from dotaBuff
        List<Hero> allHeroes = getAllHeroes();

        // update each hero
        allHeroes.forEach(hero -> updateHero(hero,allHeroes));

        // removing all in batch
        heroRepository.deleteAllInBatch();

        return heroRepository.save(allHeroes);
    }

    public List<Hero> getAllHeroes() throws ApplicationException {

        try {
            Document document = Jsoup.connect(appConfigHolder.getUrl()).get();
            return heroPageParser.getAllHeroes(document);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
            throw new ApplicationException("Parsing error");
        }
    }

    public Hero updateHero(Hero hero, List<Hero> allHeroes) {

        // TODO: algorithm refactoring
        try {

            String heroName = hero.getHeroName();
            Document document = Jsoup.connect(appConfigHolder.getUrl() + '/' + heroName)
                    .get();

            List<Hero> updatedStrongEnemies = heroPageParser.getTop10StrongEnemies(document);
            List<Hero> updatedWeakEnemies = heroPageParser.getTop10WeakEnemies(document);

            hero.setHeroStrongEnemies(collectionUtils.retainAll(allHeroes, updatedStrongEnemies));
            hero.setHeroWeakEnemies(collectionUtils.retainAll(allHeroes, updatedWeakEnemies));

            return hero;

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
            throw new RuntimeException("Parsing error");
        }
    }


}

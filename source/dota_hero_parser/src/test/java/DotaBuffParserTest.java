import dota_advisor.model.Hero;
import dota_advisor.repository.HeroRepository;
import dota_buff_parser.Run;
import dota_buff_parser.config.AppConfigHolder;
import dota_buff_parser.exception.ApplicationException;
import dota_buff_parser.service.DotaBuffHeroUpdaterService;
import dota_buff_parser.utils.CollectionUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Run.class)
//@Ignore
public class DotaBuffParserTest {

    @Autowired
    private AppConfigHolder appConfigHolder;

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private DotaBuffHeroUpdaterService heroUpdaterService;

    @Autowired
    private CollectionUtils collectionUtils;

    @Test
    public void testInjection() {
        System.out.println(appConfigHolder.getUrl());
    }

    @Test
    public void testAddHero() {
        Hero hero = new Hero("abaddon");
        heroRepository.save(hero);
    }
    @Test
    public void testHeroRepository() {
        Iterable<Hero> all = heroRepository.findAll();
        System.out.println("hello");
    }

    @Test
    public void testUpdateHeroes() throws ApplicationException {
        heroUpdaterService.updateHeroes();
        List<Hero> heroes = heroRepository.findAll();
        System.out.println("hello");
    }

}

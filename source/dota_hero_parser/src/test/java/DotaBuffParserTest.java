import dota_advisor.model.Hero;
import dota_advisor.repository.HeroRepository;
import dota_buff_parser.Run;
import dota_buff_parser.config.AppConfigHolder;
import dota_buff_parser.exception.ApplicationException;
import dota_buff_parser.service.DotaBuffHeroUpdaterService;
import dota_buff_parser.utils.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
    @Transactional
    public void testUpdateHeroes() throws ApplicationException {
        //heroUpdaterService.updateHeroes();
        List<Hero> heroes = heroRepository.findAll();
        heroes.forEach(hero -> assertThat("Hero has 10 strong heroes",
                hero.getHeroStrongEnemies().size(), equalTo(10)));

        heroes.forEach(hero -> assertThat("Hero has 10 strong heroes",
                hero.getHeroWeakEnemies().size(), equalTo(10)));
        System.out.println("hello");
    }

}

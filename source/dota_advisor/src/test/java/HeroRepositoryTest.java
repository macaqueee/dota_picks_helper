import dota_advisor.Run;
import dota_advisor.model.Hero;
import dota_advisor.repository.HeroRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Run.class)
@Ignore
public class HeroRepositoryTest {


    @Autowired
    private HeroRepository heroRepository;

    @Test
    @Transactional
    public void findAll() {
        Iterable<Hero> all = heroRepository.findAll();
        System.out.println("hello");
    }

}

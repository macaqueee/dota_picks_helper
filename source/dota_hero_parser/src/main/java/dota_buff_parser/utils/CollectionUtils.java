package dota_buff_parser.utils;

import dota_advisor.model.Hero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CollectionUtils {

    public List<Hero> retainAll(List<Hero> col1, List<Hero> col2) {
        List<Hero> resultList = new ArrayList<>();
        col2.forEach(hero -> {
            String heroName = hero.getHeroName();

            col1.stream().filter(innerHero -> innerHero.getHeroName().equals(heroName))
                    .findFirst()
                    .ifPresent(resultList::add);

        });
        return resultList;
    }
}

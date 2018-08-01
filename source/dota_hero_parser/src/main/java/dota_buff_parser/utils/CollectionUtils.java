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
            col1.forEach(innerHero -> {
                if (isHeroPresent(innerHero, heroName)){
                    resultList.add(innerHero);
                }
            });
        });
        return resultList;
    }

    private boolean isHeroPresent(Hero innerHero, String heroName) {
        return innerHero.getHeroName().equals(heroName);
    }
}

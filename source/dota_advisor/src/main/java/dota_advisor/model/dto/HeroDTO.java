package dota_advisor.model.dto;

import dota_advisor.model.Hero;

import java.util.List;
import java.util.stream.Collectors;

public class HeroDTO {

    private String heroName;
    private List<String> heroStrongEnemyNames;
    private List<String> heroWeakEnemyNames;

    public HeroDTO(String heroName) {
        this.heroName = heroName;
    }

    public HeroDTO(Hero hero) {
        this.heroName = hero.getHeroName();
        this.heroStrongEnemyNames = hero.getHeroStrongEnemies().stream()
                .map(Hero::getHeroName)
                .collect(Collectors.toList());
        this.heroWeakEnemyNames = hero.getHeroWeakEnemies().stream()
                .map(Hero::getHeroName)
                .collect(Collectors.toList());

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public List<String> getHeroStrongEnemyNames() {
        return heroStrongEnemyNames;
    }

    public void setHeroStrongEnemyNames(List<String> heroStrongEnemyNames) {
        this.heroStrongEnemyNames = heroStrongEnemyNames;
    }

    public List<String> getHeroWeakEnemyNames() {
        return heroWeakEnemyNames;
    }

    public void setHeroWeakEnemyNames(List<String> heroWeakEnemyNames) {
        this.heroWeakEnemyNames = heroWeakEnemyNames;
    }
}

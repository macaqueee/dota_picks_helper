package dota_advisor.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HEROES")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HERO_ID")
    private Long heroId;

    @Column
    private String heroName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="HERO_STRONG_ENEMIES",
            joinColumns={@JoinColumn(name="HERO_ID")},
            inverseJoinColumns={@JoinColumn(name="STRONG_ID")})
    private List<Hero> heroStrongEnemies;

    @ManyToMany(mappedBy = "heroStrongEnemies")
    private List<Hero> heroWeakEnemies;

    public Hero() {
    }

    public Hero(String heroName) {
        this.heroName = heroName;
    }

    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(Long heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public List<Hero> getHeroStrongEnemies() {
        return heroStrongEnemies;
    }

    public void setHeroStrongEnemies(List<Hero> heroStrongEnemies) {
        this.heroStrongEnemies = heroStrongEnemies;
    }

    public List<Hero> getHeroWeakEnemies() {
        return heroWeakEnemies;
    }

    public void setHeroWeakEnemies(List<Hero> heroWeakEnemies) {
        this.heroWeakEnemies = heroWeakEnemies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        if (heroId != null ? !heroId.equals(hero.heroId) : hero.heroId != null) return false;
        if (heroName != null ? !heroName.equals(hero.heroName) : hero.heroName != null) return false;
        if (heroStrongEnemies != null ? !heroStrongEnemies.equals(hero.heroStrongEnemies) : hero.heroStrongEnemies != null)
            return false;
        return heroWeakEnemies != null ? heroWeakEnemies.equals(hero.heroWeakEnemies) : hero.heroWeakEnemies == null;
    }

    @Override
    public int hashCode() {
        int result = heroId != null ? heroId.hashCode() : 0;
        result = 31 * result + (heroName != null ? heroName.hashCode() : 0);
        result = 31 * result + (heroStrongEnemies != null ? heroStrongEnemies.hashCode() : 0);
        result = 31 * result + (heroWeakEnemies != null ? heroWeakEnemies.hashCode() : 0);
        return result;
    }
}

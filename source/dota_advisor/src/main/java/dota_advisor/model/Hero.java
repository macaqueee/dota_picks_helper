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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="HERO_WEAK_ENEMIES",
            joinColumns={@JoinColumn(name="HERO_ID")},
            inverseJoinColumns={@JoinColumn(name="STRONG_ID")})
    private List<Hero> heroWeakEnemies;

    @ManyToMany(mappedBy = "heroStrongEnemies")
    private List<Hero> reverseStrongEnemies;

    @ManyToMany(mappedBy = "heroWeakEnemies")
    private List<Hero> reverseWeakEnemies;

    public Hero() {
    }

    public Hero(String heroName) {
        this.heroName = heroName;
    }

    public Hero(String heroName, List<Hero> heroStrongEnemies, List<Hero> heroWeakEnemies) {
        this.heroName = heroName;
        this.heroStrongEnemies = heroStrongEnemies;
        this.heroWeakEnemies = heroWeakEnemies;
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

    public List<Hero> getReverseStrongEnemies() {
        return reverseStrongEnemies;
    }

    public void setReverseStrongEnemies(List<Hero> reverseStrongEnemies) {
        this.reverseStrongEnemies = reverseStrongEnemies;
    }

    public List<Hero> getReverseWeakEnemies() {
        return reverseWeakEnemies;
    }

    public void setReverseWeakEnemies(List<Hero> reverseWeakEnemies) {
        this.reverseWeakEnemies = reverseWeakEnemies;
    }
}

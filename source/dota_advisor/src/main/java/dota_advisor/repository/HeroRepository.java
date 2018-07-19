package dota_advisor.repository;

import dota_advisor.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
    Hero findByHeroId(Long heroId);
}

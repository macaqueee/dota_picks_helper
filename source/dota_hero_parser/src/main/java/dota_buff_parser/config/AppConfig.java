package dota_buff_parser.config;

import dota_advisor.model.Hero;
import dota_advisor.repository.HeroRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = Hero.class)
@EnableJpaRepositories(basePackageClasses = {HeroRepository.class})
public class AppConfig {

}

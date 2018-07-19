package dota_buff_parser.parser;

import dota_advisor.model.Hero;
import org.jsoup.nodes.Document;

import java.util.List;

public interface HeroPageParser {
    List<Hero> getAllHeroes(Document document);
    List<Hero> getTop10StrongEnemies(Document document);
    List<Hero> getTop10WeakEnemies(Document document);
}

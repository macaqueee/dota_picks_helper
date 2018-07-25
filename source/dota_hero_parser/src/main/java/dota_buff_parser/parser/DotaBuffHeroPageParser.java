package dota_buff_parser.parser;

import dota_advisor.model.Hero;
import dota_buff_parser.utils.ParserUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DotaBuffHeroPageParser implements HeroPageParser {

    private final ParserUtils parserUtils;

    private static final String HEROES_CONTAINER_CLASS_NAME = "hero-grid";

    private static final String ALL_HEROES_HTML_ATTRIBUTE = "href";
    private static final String HERO_HTML_ATTRIBUTE = "data-link-to";
    private static final String WEAK_ENEMIES_SEARCH_TEXT = "BEST VERSUS";
    private static final String STRONG_ENEMIES_SEARCH_TEXT = "WORST VERSUS";

    @Autowired
    public DotaBuffHeroPageParser(ParserUtils parserUtils) {
        this.parserUtils = parserUtils;
    }

    @Override
    public List<Hero> getAllHeroes(Document document) {
        Element body = document.body();
        Elements heroLinks = body.getElementsByClass(HEROES_CONTAINER_CLASS_NAME).get(0).children();
        return parserUtils.extractHeroes(heroLinks, ALL_HEROES_HTML_ATTRIBUTE);
    }

    @Override
    public List<Hero> getTop10StrongEnemies(Document document) {

        Element body = document.body();

        Elements bestVersus = body.getElementsContainingOwnText(STRONG_ENEMIES_SEARCH_TEXT)
                .first()
                .parent()
                .getElementsByAttribute(HERO_HTML_ATTRIBUTE);

        return parserUtils.extractHeroes(bestVersus, HERO_HTML_ATTRIBUTE);
    }

    @Override
    public List<Hero> getTop10WeakEnemies(Document document) {
        Element body = document.body();

        Elements bestVersus = body.getElementsContainingOwnText(WEAK_ENEMIES_SEARCH_TEXT)
                .first()
                .parent()
                .getElementsByAttribute(HERO_HTML_ATTRIBUTE);

        return parserUtils.extractHeroes(bestVersus, HERO_HTML_ATTRIBUTE);
    }
}

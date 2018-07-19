package dota_buff_parser.utils;


import dota_advisor.model.Hero;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ParserUtils {

    public List<Hero> extractHeroes(Elements elements, String attributeKey) {
        return elements
                .stream()
                .map(el -> extractHeroFromElement(el,attributeKey))
                .filter(el -> !el.getHeroName().equals(""))
                .collect(Collectors.toList());
    }

    private Hero extractHeroFromElement(Element element, String attributeKey) {

        // extracting heroName from links
        String heroLink = element.attr(attributeKey);
        String heroName = heroLink.substring(heroLink.lastIndexOf("/")+1);

        return new Hero(heroName);
    }
}

package dota_advisor.controller;

import dota_advisor.model.dto.HeroDTO;
import dota_advisor.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @RequestMapping(value = "/heroes", method = RequestMethod.GET)
    public List<HeroDTO> getAllHeroes() {
        return heroService.getAllHeroes().stream()
                .map(HeroDTO::new)
                .collect(Collectors.toList());
    }
}

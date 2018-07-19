package dota_buff_parser.controller;

import dota_buff_parser.parser.HeroPageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private HeroPageParser heroPageParser;

    @RequestMapping(value = "/update/heroes",method = RequestMethod.GET)
    public void updateDatabaseWithHeroes() {
    }
}

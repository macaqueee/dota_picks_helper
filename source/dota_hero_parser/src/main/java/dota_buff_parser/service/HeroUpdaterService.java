package dota_buff_parser.service;

import dota_advisor.model.Hero;
import dota_buff_parser.exception.ApplicationException;

import java.io.IOException;
import java.util.List;

public interface HeroUpdaterService {

    List<Hero> updateHeroes() throws ApplicationException;

}

package elo7.desafio.Elo7Desafio.components;

import elo7.desafio.Elo7Desafio.entities.Planet;
import elo7.desafio.Elo7Desafio.usecases.PlanetGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanetComponent implements IPlanetComponent {

    @Autowired
    PlanetGenerator planetGenerator;

    @Override
    public Planet generateNew(int areaX, int areaY) {
        return planetGenerator.generateNew(areaX, areaY);
    }

    @Override
    public List<Planet> listAllPlanets() {
        return planetGenerator.listAllPlanets();
    }
}

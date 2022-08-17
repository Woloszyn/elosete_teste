package elo7.desafio.Elo7Desafio.usecases;

import elo7.desafio.Elo7Desafio.entities.Planet;
import elo7.desafio.Elo7Desafio.exceptions.PlanetNotFoundException;
import elo7.desafio.Elo7Desafio.repositories.IPlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlanetGenerator {
    @Autowired
    private IPlanetRepository repository;

    public Planet loadPlanet(long id) throws PlanetNotFoundException {
        Optional<Planet> optionalPlanet = repository.findById(id);
        if (optionalPlanet.isPresent()) {
            return optionalPlanet.get();
        }
        throw new PlanetNotFoundException();
    }

    public List<Planet> listAllPlanets() {
        return repository.findAll();
    }

    public Planet generateNew(int areaX, int areaY) {
        Planet planet = new Planet();
        planet.setAreaX(areaX);
        planet.setAreaY(areaY);
        repository.save(planet);
        return planet;
    }

}

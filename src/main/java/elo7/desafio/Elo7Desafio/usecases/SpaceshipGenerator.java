package elo7.desafio.Elo7Desafio.usecases;

import elo7.desafio.Elo7Desafio.entities.Planet;
import elo7.desafio.Elo7Desafio.entities.Spaceship;
import elo7.desafio.Elo7Desafio.enums.GeographicPosition;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotFoundException;
import elo7.desafio.Elo7Desafio.repositories.ISpaceShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SpaceshipGenerator {
    @Autowired
    ISpaceShipRepository repository;

    public Spaceship generateNewSpaceShip(int x, int y, GeographicPosition position, Planet planet) {
        Spaceship spaceship = new Spaceship();
        spaceship.setPositionGeographic(position);
        spaceship.setPositionX(x);
        spaceship.setPositionY(y);
        spaceship.setPlanet(planet);
        repository.save(spaceship);
        return spaceship;
    }

    public List<Spaceship> retrieveSpaceships(){
        return repository.findAll();
    }

    public Spaceship loadSpaceshipById(Long id) throws SpaceshipNotFoundException {
        Optional<Spaceship> optionalSpaceship = repository.findById(id);
        if (optionalSpaceship.isPresent()) {
            return optionalSpaceship.get();
        }
        throw new SpaceshipNotFoundException();
    }

}
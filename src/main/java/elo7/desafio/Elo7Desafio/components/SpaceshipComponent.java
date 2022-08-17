package elo7.desafio.Elo7Desafio.components;

import elo7.desafio.Elo7Desafio.usecases.PlanetGenerator;
import elo7.desafio.Elo7Desafio.usecases.SpaceshipGenerator;
import elo7.desafio.Elo7Desafio.entities.Planet;
import elo7.desafio.Elo7Desafio.entities.Spaceship;
import elo7.desafio.Elo7Desafio.enums.GeographicPosition;
import elo7.desafio.Elo7Desafio.exceptions.CommandNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.PlanetNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotInitializedException;
import elo7.desafio.Elo7Desafio.repositories.IPlanetRepository;
import elo7.desafio.Elo7Desafio.repositories.ISpaceShipRepository;
import elo7.desafio.Elo7Desafio.usecases.SpaceshipCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpaceshipComponent implements ISpaceshipComponent {

    @Autowired
    PlanetGenerator planetGenerator;
    @Autowired
    SpaceshipGenerator spaceshipGenerator;

    @Autowired
    ISpaceShipRepository spaceShipRepository;

    public SpaceshipComponent() {
    }

    public SpaceshipComponent(SpaceshipGenerator spaceshipGenerator, ISpaceShipRepository spaceShipRepository) {
        this.spaceshipGenerator = spaceshipGenerator;
        this.spaceShipRepository = spaceShipRepository;
    }

    @Override
    public List<String> readCommands(String commands, long spaceshipId) throws CommandNotFoundException, SpaceshipNotInitializedException {
        List<String> log = new ArrayList<>();
        Planet planet = null;
        Spaceship spaceship = null;
        try {
            spaceship = spaceshipGenerator.loadSpaceshipById(spaceshipId);
            SpaceshipCommands spaceshipCommands = new SpaceshipCommands(spaceShipRepository, spaceship);
            for (int i = 0 ; i < commands.length(); i++) {
                log.add(spaceshipCommands.readCommand(commands.charAt(i)));
            }
        } catch (Exception e) {
            log.add(e.getMessage());
        }
        return log;
    }

    @Override
    public List<Spaceship> getAll() {
        return spaceshipGenerator.retrieveSpaceships();
    }

    @Override
    public Spaceship generateNew(int positionX, int positionY, GeographicPosition geographicPosition, long planetId) {
        Planet planet = null;
        try {
            planet = planetGenerator.loadPlanet(planetId);
        } catch (PlanetNotFoundException planetNotFoundException) {
            System.out.println(planetNotFoundException.getMessage());
        }
        return spaceshipGenerator.generateNewSpaceShip(positionX, positionY, geographicPosition, planet);
    }
}

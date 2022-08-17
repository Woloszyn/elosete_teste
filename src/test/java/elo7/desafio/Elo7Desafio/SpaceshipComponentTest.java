package elo7.desafio.Elo7Desafio;

import elo7.desafio.Elo7Desafio.components.SpaceshipComponent;
import elo7.desafio.Elo7Desafio.entities.Planet;
import elo7.desafio.Elo7Desafio.entities.Spaceship;
import elo7.desafio.Elo7Desafio.enums.GeographicPosition;
import elo7.desafio.Elo7Desafio.exceptions.CommandNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotInitializedException;
import elo7.desafio.Elo7Desafio.repositories.ISpaceShipRepository;
import elo7.desafio.Elo7Desafio.usecases.SpaceshipGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpaceshipComponentTest {

    @Test
    public void sendingCommandMShouldMove() throws SpaceshipNotInitializedException, CommandNotFoundException, SpaceshipNotFoundException {
        SpaceshipGenerator spaceshipGenerator = mock(SpaceshipGenerator.class);
        ISpaceShipRepository iSpaceShipRepository = mock(ISpaceShipRepository.class);
        Planet planet = new Planet();
        planet.setAreaX(5);
        planet.setAreaY(5);
        Spaceship spaceship = new Spaceship();
        spaceship.setPositionY(0);
        spaceship.setPositionX(0);
        spaceship.setPositionGeographic(GeographicPosition.RIGHT);
        spaceship.setPlanet(planet);

        long fakeId = 1;

        SpaceshipComponent spaceshipComponent = new SpaceshipComponent(spaceshipGenerator, iSpaceShipRepository);
        doReturn(spaceship).when(spaceshipGenerator).loadSpaceshipById(fakeId);
        when(iSpaceShipRepository.save(spaceship)).thenReturn(spaceship);
        spaceshipComponent.readCommands("M", fakeId);
        assertEquals(1, spaceship.getPositionX());
    }

    @Test
    public void sendingCommandLMShouldTurnLeftAndMove() throws SpaceshipNotInitializedException, CommandNotFoundException, SpaceshipNotFoundException {
        SpaceshipGenerator spaceshipGenerator = mock(SpaceshipGenerator.class);
        ISpaceShipRepository iSpaceShipRepository = mock(ISpaceShipRepository.class);
        Planet planet = new Planet();
        planet.setAreaX(5);
        planet.setAreaY(5);
        Spaceship spaceship = new Spaceship();
        spaceship.setPositionY(0);
        spaceship.setPositionX(1);
        spaceship.setPositionGeographic(GeographicPosition.UP);
        spaceship.setPlanet(planet);

        long fakeId = 1;

        SpaceshipComponent spaceshipComponent = new SpaceshipComponent(spaceshipGenerator, iSpaceShipRepository);
        doReturn(spaceship).when(spaceshipGenerator).loadSpaceshipById(fakeId);
        when(iSpaceShipRepository.save(spaceship)).thenReturn(spaceship);
        spaceshipComponent.readCommands("LM", fakeId);
        assertEquals(0, spaceship.getPositionX());
    }

    @Test
    public void sendingCommandRMShouldTurnRightAndMove() throws SpaceshipNotInitializedException, CommandNotFoundException, SpaceshipNotFoundException {
        SpaceshipGenerator spaceshipGenerator = mock(SpaceshipGenerator.class);
        ISpaceShipRepository iSpaceShipRepository = mock(ISpaceShipRepository.class);
        Planet planet = new Planet();
        planet.setAreaX(5);
        planet.setAreaY(5);
        Spaceship spaceship = new Spaceship();
        spaceship.setPositionY(0);
        spaceship.setPositionX(1);
        spaceship.setPositionGeographic(GeographicPosition.UP);
        spaceship.setPlanet(planet);

        long fakeId = 1;

        SpaceshipComponent spaceshipComponent = new SpaceshipComponent(spaceshipGenerator, iSpaceShipRepository);
        doReturn(spaceship).when(spaceshipGenerator).loadSpaceshipById(fakeId);
        when(iSpaceShipRepository.save(spaceship)).thenReturn(spaceship);
        spaceshipComponent.readCommands("RM", fakeId);
        assertEquals(2, spaceship.getPositionX());
    }

    @Test
    public void scenarioOneTest() throws SpaceshipNotInitializedException, CommandNotFoundException, SpaceshipNotFoundException {
        SpaceshipGenerator spaceshipGenerator = mock(SpaceshipGenerator.class);
        ISpaceShipRepository iSpaceShipRepository = mock(ISpaceShipRepository.class);
        Planet planet = new Planet();
        planet.setAreaX(5);
        planet.setAreaY(5);
        Spaceship spaceship = new Spaceship();
        spaceship.setPositionY(1);
        spaceship.setPositionX(0);
        spaceship.setPositionGeographic(GeographicPosition.UP);
        spaceship.setPlanet(planet);

        long fakeId = 1;

        SpaceshipComponent spaceshipComponent = new SpaceshipComponent(spaceshipGenerator, iSpaceShipRepository);
        doReturn(spaceship).when(spaceshipGenerator).loadSpaceshipById(fakeId);
        when(iSpaceShipRepository.save(spaceship)).thenReturn(spaceship);
        spaceshipComponent.readCommands("LMLMLMLMM", fakeId);
        assertEquals(0, spaceship.getPositionX());
        assertEquals(2, spaceship.getPositionY());
        assertEquals(GeographicPosition.UP, spaceship.getPositionGeographic());
    }

    @Test
    public void scenarioTwoTest() throws SpaceshipNotInitializedException, CommandNotFoundException, SpaceshipNotFoundException {
        SpaceshipGenerator spaceshipGenerator = mock(SpaceshipGenerator.class);
        ISpaceShipRepository iSpaceShipRepository = mock(ISpaceShipRepository.class);
        Planet planet = new Planet();
        planet.setAreaX(5);
        planet.setAreaY(5);
        Spaceship spaceship = new Spaceship();
        spaceship.setPositionY(2);
        spaceship.setPositionX(2);
        spaceship.setPositionGeographic(GeographicPosition.RIGHT);
        spaceship.setPlanet(planet);

        long fakeId = 1;

        SpaceshipComponent spaceshipComponent = new SpaceshipComponent(spaceshipGenerator, iSpaceShipRepository);
        doReturn(spaceship).when(spaceshipGenerator).loadSpaceshipById(fakeId);
        when(iSpaceShipRepository.save(spaceship)).thenReturn(spaceship);
        spaceshipComponent.readCommands("MMRMMRMRRML", fakeId);
        assertEquals(4, spaceship.getPositionX());
        assertEquals(0, spaceship.getPositionY());
        assertEquals(GeographicPosition.UP, spaceship.getPositionGeographic());
    }

}

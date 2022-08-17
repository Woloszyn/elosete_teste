package elo7.desafio.Elo7Desafio.components;

import elo7.desafio.Elo7Desafio.entities.Spaceship;
import elo7.desafio.Elo7Desafio.enums.GeographicPosition;
import elo7.desafio.Elo7Desafio.exceptions.CommandNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotInitializedException;

import java.util.List;

public interface ISpaceshipComponent {
    public List<String> readCommands(String commands, long spaceshipId) throws CommandNotFoundException, SpaceshipNotInitializedException;

    public List<Spaceship> getAll();

    public Spaceship generateNew(int positionX, int positionY, GeographicPosition geographicPosition, long planetId);
}

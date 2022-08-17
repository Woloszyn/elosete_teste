package elo7.desafio.Elo7Desafio.usecases;

import elo7.desafio.Elo7Desafio.entities.Spaceship;
import elo7.desafio.Elo7Desafio.enums.MoveDirections;
import elo7.desafio.Elo7Desafio.exceptions.CommandNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotInitializedException;
import elo7.desafio.Elo7Desafio.repositories.ISpaceShipRepository;

public class SpaceshipCommands {
    ISpaceShipRepository repository;

    Spaceship spaceship;

    public SpaceshipCommands(ISpaceShipRepository repository, Spaceship spaceship) {
        this.repository = repository;
        this.spaceship = spaceship;
    }

    public String readCommand(char command) throws CommandNotFoundException, SpaceshipNotInitializedException {
        if (spaceship == null) {
            throw new SpaceshipNotInitializedException();
        }
        switch (command) {
            case 'M':
                move();
                break;
            case 'L':
                rotateLeft();
                break;
            case 'R':
                rotateRight();
                break;
            default:
                throw new CommandNotFoundException();
        }
        return String.format("| Command: %s | --- |Actual spaceship position X: %s Y: %s actual direction %s| "
                , command
                , spaceship.getPositionX() + 1
                , spaceship.getPositionY() + 1
                , spaceship.getPositionGeographic().toString()
        );
    }
    private void move() {
        MoveDirections.fromGeographicPosition(spaceship.getPositionGeographic()).move().accept(spaceship);
        apply();
    }

    private void apply() {
        repository.save(spaceship);
    }

    private void rotateRight() {
        MoveDirections.fromGeographicPosition(spaceship.getPositionGeographic()).rotate().accept(spaceship, true);
        apply();
    }

    private void rotateLeft() {
        MoveDirections.fromGeographicPosition(spaceship.getPositionGeographic()).rotate().accept(spaceship, false);
        apply();
    }

}

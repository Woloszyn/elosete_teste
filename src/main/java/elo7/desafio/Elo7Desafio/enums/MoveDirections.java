package elo7.desafio.Elo7Desafio.enums;

import elo7.desafio.Elo7Desafio.entities.Spaceship;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public enum MoveDirections {

    RIGHT(MoveDirections::moveRight, MoveDirections::rotateRight),
    LEFT(MoveDirections::moveLeft, MoveDirections::rotateLeft),
    UP(MoveDirections::moveUp, MoveDirections::rotateUp),
    DOWN(MoveDirections::moveDown, MoveDirections::rotateDown);

    private final Consumer<Spaceship> move;
    private final BiConsumer<Spaceship, Boolean> rotate;

    MoveDirections(Consumer<Spaceship> move, BiConsumer<Spaceship, Boolean> rotate) {
        this.move = move;
        this.rotate = rotate;
    }

    public Consumer<Spaceship> move() {
        return move;
    }

    public BiConsumer<Spaceship, Boolean> rotate() {
        return rotate;
    }

    public static MoveDirections fromGeographicPosition(GeographicPosition geographicPosition) {
        switch(geographicPosition) {
            case UP:
                return MoveDirections.UP;
            case DOWN:
                return MoveDirections.DOWN;
            case LEFT:
                return MoveDirections.LEFT;
            case RIGHT:
                return MoveDirections.RIGHT;
            default:
                throw new RuntimeException("NotFound ");
        }
    }

    public static void moveLeft(Spaceship spaceship) {
        if (spaceship.getPositionX() > 0) {
            spaceship.decreaseX();
        } else {
            spaceship.setPositionX(4);
        }
    }

    public static void moveRight(Spaceship spaceship) {
        if (spaceship.getPositionX() < 4) {
            spaceship.increaseX();
        } else {
            spaceship.setPositionX(0);
        }
    }

    public static void moveUp(Spaceship spaceship) {
        if (spaceship.getPositionY() < 4) {
            spaceship.increaseY();
        } else {
            spaceship.setPositionY(0);
        }
    }

    public static void moveDown(Spaceship spaceship) {
        if (spaceship.getPositionY() > 0) {
            spaceship.decreaseY();
        } else {
            spaceship.setPositionY(4);
        }
    }
    public static void rotateLeft(Spaceship spaceship, Boolean isRight) {
        spaceship.setPositionGeographic((isRight) ?GeographicPosition.UP :GeographicPosition.DOWN);
    }

    public static void rotateRight(Spaceship spaceship, Boolean isRight) {
        spaceship.setPositionGeographic((isRight) ?GeographicPosition.DOWN :GeographicPosition.UP);
    }

    public static void rotateUp(Spaceship spaceship, Boolean isRight) {
        spaceship.setPositionGeographic((isRight) ?GeographicPosition.RIGHT :GeographicPosition.LEFT);
    }

    public static void rotateDown(Spaceship spaceship, Boolean isRight) {
        spaceship.setPositionGeographic((isRight) ?GeographicPosition.LEFT :GeographicPosition.RIGHT);
    }
}

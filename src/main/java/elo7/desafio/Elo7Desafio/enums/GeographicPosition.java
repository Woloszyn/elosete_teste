package elo7.desafio.Elo7Desafio.enums;

import org.webjars.NotFoundException;

public enum GeographicPosition {

    UP,
    DOWN,
    LEFT,
    RIGHT;
    GeographicPosition() {
    }

    public static GeographicPosition fromString(String position) {
        switch (position.toUpperCase()) {
            case "UP":
                return UP;
            case "DOWN":
                return DOWN;
            case "LEFT":
                return LEFT;
            case "RIGHT":
                return RIGHT;
            default:
                throw new NotFoundException("Comando inválido");
        }
    }

}

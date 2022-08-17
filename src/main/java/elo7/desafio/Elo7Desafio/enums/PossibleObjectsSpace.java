package elo7.desafio.Elo7Desafio.enums;

public enum PossibleObjectsSpace {

    SPACESHIP("S"),
    GOAL("G"),
    BLANK("B");

    private final String text;

    PossibleObjectsSpace(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public char toChar() {
        return text.charAt(0);
    }

}

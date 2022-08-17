package elo7.desafio.Elo7Desafio.exceptions;

public class CommandNotFoundException extends Exception{

    public CommandNotFoundException() {
        super("The command that has send it's not valid!!");
    }
}

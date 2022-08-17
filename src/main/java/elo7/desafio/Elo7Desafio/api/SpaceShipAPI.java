package elo7.desafio.Elo7Desafio.api;

import elo7.desafio.Elo7Desafio.components.ISpaceshipComponent;
import elo7.desafio.Elo7Desafio.entities.Spaceship;
import elo7.desafio.Elo7Desafio.enums.GeographicPosition;
import elo7.desafio.Elo7Desafio.exceptions.CommandNotFoundException;
import elo7.desafio.Elo7Desafio.exceptions.SpaceshipNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Map;

@ApplicationScope
@RestController("SpaceShip")
public class SpaceShipAPI {

    @Autowired
    ISpaceshipComponent spaceshipComponent;

    @PostMapping("/spaceship")
    public Spaceship generateNew(@RequestBody Map<String,String> json) {
        int positionX = Integer.parseInt(json.get("positionX"));
        int positionY = Integer.parseInt(json.get("positionY"));
        GeographicPosition geographicPosition = GeographicPosition.fromString(json.get("geographicPosition"));
        long planetId = Long.parseLong(json.get("planetId"));
        return spaceshipComponent.generateNew(positionX, positionY, geographicPosition, planetId);
    }

    @GetMapping("/spaceship")
    public List<Spaceship> getAll() {
        return spaceshipComponent.getAll();
    }

    @GetMapping(path = "/instructions/{instructions}/{spaceshipId}")
    public List<String> readInstructions(@PathVariable("instructions") String instructions, @PathVariable("spaceshipId") Long spaceshipId ) throws SpaceshipNotInitializedException, CommandNotFoundException {
        return spaceshipComponent.readCommands(instructions, spaceshipId);
    }

}

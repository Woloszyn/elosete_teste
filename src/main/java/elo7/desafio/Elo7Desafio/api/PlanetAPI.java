package elo7.desafio.Elo7Desafio.api;

import elo7.desafio.Elo7Desafio.components.IPlanetComponent;
import elo7.desafio.Elo7Desafio.entities.Planet;
import elo7.desafio.Elo7Desafio.repositories.IPlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("Planet")
public class PlanetAPI {

    @Autowired
    private IPlanetRepository repository;
    @Autowired
    IPlanetComponent planetComponent;

    @PostMapping(path = "/planet", consumes = "application/json", produces = "application/json")
    public Planet generate(@RequestBody Map<String, String> json) {
        int areaX = Integer.parseInt(json.get("areaX"));
        int areaY = Integer.parseInt(json.get("areaY"));
        return planetComponent.generateNew(areaX, areaY);
    }
    @GetMapping(path = "/planet")
    public List<Planet> listAll() {
        return planetComponent.listAllPlanets();
    }

}
package elo7.desafio.Elo7Desafio.components;

import elo7.desafio.Elo7Desafio.entities.Planet;

import java.util.List;

public interface IPlanetComponent {

    public Planet generateNew(int areaX, int areaY);

    public List<Planet> listAllPlanets();

}

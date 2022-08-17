package elo7.desafio.Elo7Desafio.entities;

import elo7.desafio.Elo7Desafio.enums.GeographicPosition;

import javax.persistence.*;

@Entity
@Table(name = "spaceship")
public class Spaceship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    int positionX;
    int positionY;
    GeographicPosition positionGeographic;

    @ManyToOne(targetEntity = Planet.class)
    @JoinColumn(name = "space_id")
    Planet planet;

    public GeographicPosition getPositionGeographic() {
        return positionGeographic;
    }

    public void setPositionGeographic(GeographicPosition positionGeographic) {
        this.positionGeographic = positionGeographic;
    }

    public void increaseX() {
        this.positionX++;
    }

    public void decreaseX() {
        this.positionX--;
    }

    public void increaseY() {
        this.positionY++;
    }

    public void decreaseY() {
        this.positionY--;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public long getId() {
        return id;
    }
}

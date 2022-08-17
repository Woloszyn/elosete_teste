package elo7.desafio.Elo7Desafio.entities;

import javax.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int areaX;
    int areaY;

    public void setAreaX(int areaX) {
        this.areaX = areaX;
    }

    public void setAreaY(int areaY) {
        this.areaY = areaY;
    }
    public int getAreaX() {
        return areaX;
    }

    public int getAreaY() {
        return areaY;
    }

    public Long getId() {
        return id;
    }
}

package elo7.desafio.Elo7Desafio.repositories;


import elo7.desafio.Elo7Desafio.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanetRepository extends JpaRepository<Planet, Long> {
}

package elo7.desafio.Elo7Desafio.repositories;

import elo7.desafio.Elo7Desafio.entities.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpaceShipRepository extends JpaRepository<Spaceship, Long> {
}

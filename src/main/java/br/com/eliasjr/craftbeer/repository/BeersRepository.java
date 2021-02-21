package br.com.eliasjr.craftbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eliasjr.craftbeer.domain.Beers;

@Repository
public interface BeersRepository extends JpaRepository<Beers, Long> {

}

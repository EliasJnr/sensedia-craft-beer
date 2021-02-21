package br.com.eliasjr.craftbeer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eliasjr.craftbeer.domain.Beers;
import br.com.eliasjr.craftbeer.exception.NotFoundException;
import br.com.eliasjr.craftbeer.repository.BeersRepository;

@Service
public class BeersService {

	@Autowired
	private BeersRepository beersRepository;

	public Beers save(Beers beer) {
		return beersRepository.save(beer);
	}

	public Beers update(Beers beer) {
		return beersRepository.save(beer);
	}

	public Beers getById(Long id) {
		Optional<Beers> result = beersRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("There are not beer with id = " + id));
	}

	public List<Beers> listAll() {
		return beersRepository.findAll();
	}
}

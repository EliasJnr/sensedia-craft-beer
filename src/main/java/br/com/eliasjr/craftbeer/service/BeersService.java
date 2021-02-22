package br.com.eliasjr.craftbeer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eliasjr.craftbeer.domain.Beers;
import br.com.eliasjr.craftbeer.exception.NotFoundException;
import br.com.eliasjr.craftbeer.model.PageModel;
import br.com.eliasjr.craftbeer.model.PageRequestModel;
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

	public Beers updatePrice(Long id, double price) {
		Beers beer = getById(id);
		beer.setPrice(price);
		return beersRepository.save(beer);
	}

	public Beers getById(Long id) {
		Optional<Beers> result = beersRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("There are not beer with id = " + id));
	}

	public PageModel<Beers> listAllOnLazyMode(PageRequestModel pr) {
		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<Beers> page = beersRepository.findAll(pageable);
		PageModel<Beers> pm = new PageModel<>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(),
				page.getContent());
		return pm;
	}

	public void removeById(Long id) {
		Beers beer = getById(id);
		beersRepository.delete(beer);
	}

}

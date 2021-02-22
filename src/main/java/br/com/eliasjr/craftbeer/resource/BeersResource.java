package br.com.eliasjr.craftbeer.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eliasjr.craftbeer.domain.Beers;
import br.com.eliasjr.craftbeer.dto.BeerCreateDTO;
import br.com.eliasjr.craftbeer.dto.BeerUpdateDTO;
import br.com.eliasjr.craftbeer.model.PageModel;
import br.com.eliasjr.craftbeer.model.PageRequestModel;
import br.com.eliasjr.craftbeer.service.BeersService;

@RestController
@RequestMapping(value = "beers")
public class BeersResource {

	@Autowired
	private BeersService beersService;

	@GetMapping
	public ResponseEntity<PageModel<Beers>> listAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<Beers> pm = beersService.listAllOnLazyMode(pr);
		return ResponseEntity.ok(pm);
	}

	@PostMapping
	public ResponseEntity<Beers> save(@RequestBody @Valid BeerCreateDTO beerDto) {
		Beers createdBeer = beersService.save(beerDto.transformToBeer());
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBeer);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Beers> getById(@PathVariable("id") Long id) {
		Beers beer = beersService.getById(id);
		return ResponseEntity.ok(beer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Beers> update(@PathVariable(name = "id") Long id, @RequestBody @Valid BeerUpdateDTO beerDto) {
		Beers beer = beerDto.transformToBeer();
		beer.setId(id);
		Beers updatedBeer = beersService.update(beer);
		return ResponseEntity.status(HttpStatus.OK).body(updatedBeer);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Beers> updatePrice(@PathVariable(name = "id") Long id, @RequestParam("price") double price) {
		Beers updatedBeer = beersService.updatePrice(id, price);
		return ResponseEntity.status(HttpStatus.OK).body(updatedBeer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Beers> delete(@PathVariable("id") Long id) {
		beersService.removeById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}

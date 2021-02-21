package br.com.eliasjr.craftbeer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.eliasjr.craftbeer.domain.Beers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeersRepositoryTests {

	@Autowired
	private BeersRepository beersRepository;

	@Test
	public void AsaveTest() {
		Beers beer = new Beers(1L, "Cerveja Artesanal", "ingrediente 1, ingrediente 2", "10%", 5.0, "cevada");
		Beers beerCreated = beersRepository.save(beer);

		assertThat(beerCreated.getId()).isEqualTo(1L);
	}

	@Test
	public void updateTest() {
		Beers beer = new Beers(1L, "Cerveja em gel", "ingrediente 1, ingrediente 2, ingrediente secreto", "15%", 10.0,
				"cevada");

		Beers beerUpdated = beersRepository.save(beer);

		assertThat(beerUpdated.getIngredients()).isEqualTo("ingrediente 1, ingrediente 2, ingrediente secreto");
	}

	@Test
	public void getByIdTest() {
		Optional<Beers> result = beersRepository.findById(1L);

		Beers beer = result.get();

		assertThat(beer.getName()).isEqualTo("Cerveja Artesanal");

	}

	@Test
	public void listTest() {
		List<Beers> beers = beersRepository.findAll();

		assertThat(beers.size()).isEqualTo(1);
	}

}

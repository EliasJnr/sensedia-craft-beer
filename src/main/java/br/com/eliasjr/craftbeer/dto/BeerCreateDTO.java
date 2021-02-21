package br.com.eliasjr.craftbeer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.eliasjr.craftbeer.domain.Beers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerCreateDTO {

	@NotBlank(message = "Name required")
	private String name;

	@NotBlank(message = "Ingredients required")
	private String ingredients;

	@NotBlank(message = "Alcohol content required")
	private String alcoholContent;

	@NotNull
	private double price;

	@NotBlank(message = "Category required")
	private String category;

	public Beers transformToBeer() {
		return new Beers(null, this.name, this.ingredients, this.alcoholContent, this.price, this.category);

	}
}

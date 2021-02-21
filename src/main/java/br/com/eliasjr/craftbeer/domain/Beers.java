package br.com.eliasjr.craftbeer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "beers")
public class Beers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 75, nullable = false)
	private String name;
	@Column(length = 120, nullable = false)
	private String ingredients;
	@Column(length = 75, nullable = false)
	private String alcoholContent;
	@Column(nullable = false)
	private double price;
	@Column(length = 50, nullable = false)
	private String category;
}

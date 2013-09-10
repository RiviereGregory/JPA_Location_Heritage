package fr.treeptik.jpalocationheritage.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Moto")
public class Moto extends Vehicule {
	private static final long serialVersionUID = 1L;

	public Moto() {
	}

	public Moto(Integer noImmatriculation, String marque, String modele, String couleur,
			Integer cumulReparation, Boolean disponible) {
		super(noImmatriculation, marque, modele, couleur, cumulReparation, disponible);

	}

}

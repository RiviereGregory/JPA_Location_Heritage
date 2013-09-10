package fr.treeptik.jpalocationheritage.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Voiture")
public class Voiture extends Vehicule {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "code_type")
	private TypeVoiture typeVoiture;

	// Permet de créer une table a partir des collections sans avoir besoin de créer une class avec
	// id
	@ElementCollection
	@CollectionTable(name = "Option_Voiture")
	@Column(name = "opt")
	private List<String> option;

	public Voiture() {
	}

	public Voiture(Integer noImmatriculation, String marque, String modele, String couleur,
			Integer cumulReparation, Boolean disponible, TypeVoiture typeVoiture,
			List<String> option) {
		super(noImmatriculation, marque, modele, couleur, cumulReparation, disponible);
		this.typeVoiture = typeVoiture;
		this.option = option;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public TypeVoiture getTypeVoiture() {
		return typeVoiture;
	}

	public void setTypeVoiture(TypeVoiture typeVoiture) {
		this.typeVoiture = typeVoiture;
	}

}

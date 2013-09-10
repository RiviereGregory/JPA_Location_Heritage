package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicule")
// On peut avoir SINGLE_TABLE, JOINED ou TABLE_PER_CLASS
// SINGLE_TABLE une seule table avec toutes les info des enfants dans la table Vehicule
// JOINED la table Vehicule contient les info que de la class Vehicule et les tables filles contient
// leur données membre plus la cle primaire de véhicule
// TABLE_PER_TABLE les tables filles ont les info de la class mère (Vehicule) et ses données membres
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Abstract pour ne pas avoir la table Vehicule avec TABLE_PER_CLASS
public abstract class Vehicule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// En mode TABLE_PER_CLASS il n'y a pas d'auto-génération
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "noimmatriculation")
	private Integer noImmatriculation;

	@Column(name = "marque")
	private String marque;

	@Column(name = "modele")
	private String modele;

	@Column(name = "couleur")
	private String couleur;

	@Column(name = "cumul_reparation")
	private Integer cumulReparation;

	@Column(name = "disponible")
	private Boolean disponible;

	public Vehicule() {
	}

	public Vehicule(Integer noImmatriculation, String marque, String modele, String couleur,
			Integer cumulReparation, Boolean disponible) {
		super();
		this.noImmatriculation = noImmatriculation;
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.cumulReparation = cumulReparation;
		this.disponible = disponible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noImmatriculation == null) ? 0 : noImmatriculation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicule other = (Vehicule) obj;
		if (noImmatriculation == null) {
			if (other.noImmatriculation != null)
				return false;
		} else if (!noImmatriculation.equals(other.noImmatriculation))
			return false;
		return true;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getCumulReparation() {
		return cumulReparation;
	}

	public void setCumulReparation(Integer cumulReparation) {
		this.cumulReparation = cumulReparation;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getNoImmatriculation() {
		return noImmatriculation;
	}

	public void setNoImmatriculation(Integer noImmatriculation) {
		this.noImmatriculation = noImmatriculation;
	}

}

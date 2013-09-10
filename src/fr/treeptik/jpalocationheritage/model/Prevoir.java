package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Prevoir")
public class Prevoir implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	// Permet d'attribuer la proprièté de l'objet a la colonne de la base
	@AttributeOverrides({
			@AttributeOverride(name = "noContrat", column = @Column(name = "nocontrat")),
			@AttributeOverride(name = "codeSuplement", column = @Column(name = "codesuplement")) })
	private PrevoirPK clePrimaire;

	private Integer nbSuplement;

	public Prevoir() {
	}

	public Prevoir(PrevoirPK clePrimaire, Integer nbSuplement) {
		super();
		this.clePrimaire = clePrimaire;
		this.nbSuplement = nbSuplement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clePrimaire == null) ? 0 : clePrimaire.hashCode());
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
		Prevoir other = (Prevoir) obj;
		if (clePrimaire == null) {
			if (other.clePrimaire != null)
				return false;
		} else if (!clePrimaire.equals(other.clePrimaire))
			return false;
		return true;
	}

	public PrevoirPK getClePrimaire() {
		return clePrimaire;
	}

	public void setClePrimaire(PrevoirPK clePrimaire) {
		this.clePrimaire = clePrimaire;
	}

	public Integer getNbSuplement() {
		return nbSuplement;
	}

	public void setNbSuplement(Integer nbSuplement) {
		this.nbSuplement = nbSuplement;
	}

}

package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Type_voiture")
public class TypeVoiture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code_type")
	private Integer codeType;

	@Column(name = "description_type")
	private String descriptionType;

	@Column(name = "places")
	private Integer places;

	@Column(name = "prix_jour")
	private Integer prixJour;

	public TypeVoiture() {
	}

	public TypeVoiture(Integer codeType, String descriptionType, Integer places, Integer prixJour) {
		super();
		this.codeType = codeType;
		this.descriptionType = descriptionType;
		this.places = places;
		this.prixJour = prixJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeType == null) ? 0 : codeType.hashCode());
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
		TypeVoiture other = (TypeVoiture) obj;
		if (codeType == null) {
			if (other.codeType != null)
				return false;
		} else if (!codeType.equals(other.codeType))
			return false;
		return true;
	}

	public Integer getCodeType() {
		return codeType;
	}

	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public Integer getPrixJour() {
		return prixJour;
	}

	public void setPrixJour(Integer prixJour) {
		this.prixJour = prixJour;
	}

}

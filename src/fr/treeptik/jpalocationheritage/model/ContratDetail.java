package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;
import java.util.Date;

public class ContratDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomClient;
	private Date dateContrat;
	private String marqueVoiture;
	private String descriptionType;

	public ContratDetail() {
	}

	public ContratDetail(String nomClient, Date dateContrat, String marqueVoiture,
			String descriptionType) {
		super();
		this.nomClient = nomClient;
		this.dateContrat = dateContrat;
		this.marqueVoiture = marqueVoiture;
		this.descriptionType = descriptionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateContrat == null) ? 0 : dateContrat.hashCode());
		result = prime * result + ((descriptionType == null) ? 0 : descriptionType.hashCode());
		result = prime * result + ((marqueVoiture == null) ? 0 : marqueVoiture.hashCode());
		result = prime * result + ((nomClient == null) ? 0 : nomClient.hashCode());
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
		ContratDetail other = (ContratDetail) obj;
		if (dateContrat == null) {
			if (other.dateContrat != null)
				return false;
		} else if (!dateContrat.equals(other.dateContrat))
			return false;
		if (descriptionType == null) {
			if (other.descriptionType != null)
				return false;
		} else if (!descriptionType.equals(other.descriptionType))
			return false;
		if (marqueVoiture == null) {
			if (other.marqueVoiture != null)
				return false;
		} else if (!marqueVoiture.equals(other.marqueVoiture))
			return false;
		if (nomClient == null) {
			if (other.nomClient != null)
				return false;
		} else if (!nomClient.equals(other.nomClient))
			return false;
		return true;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Date getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}

	public String getMarqueVoiture() {
		return marqueVoiture;
	}

	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}

}

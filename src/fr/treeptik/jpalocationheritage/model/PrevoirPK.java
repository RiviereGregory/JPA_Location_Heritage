package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PrevoirPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Contrat contrat;
	@ManyToOne
	private Suplements suplements;

	public PrevoirPK() {
	}

	public PrevoirPK(Contrat contrat, Suplements suplements) {
		super();
		this.contrat = contrat;
		this.suplements = suplements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
		result = prime * result + ((suplements == null) ? 0 : suplements.hashCode());
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
		PrevoirPK other = (PrevoirPK) obj;
		if (contrat == null) {
			if (other.contrat != null)
				return false;
		} else if (!contrat.equals(other.contrat))
			return false;
		if (suplements == null) {
			if (other.suplements != null)
				return false;
		} else if (!suplements.equals(other.suplements))
			return false;
		return true;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Suplements getSuplements() {
		return suplements;
	}

	public void setSuplements(Suplements suplements) {
		this.suplements = suplements;
	}

}

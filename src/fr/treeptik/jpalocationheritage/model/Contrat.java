package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Contrat")
public class Contrat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nocontrat")
	private Integer noContrat;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_contrat")
	private Date dateContrat;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_enlevement")
	private Date dateEnlevement;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_retour")
	private Date dateRetour;

	@ManyToOne
	@JoinColumn(name = "codecl")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "noimmatriculation")
	private Vehicule vehicule;

	// @ManyToMany
	// @JoinTable(name = "Prevoir", joinColumns = @JoinColumn(name = "nocontrat"),
	// inverseJoinColumns = @JoinColumn(name = "codesuplement"))

	// Il faut mappedby sur le ManyToOne qui se situe dans le PrevoiPK donc il faut passer par
	// clePrimaire.suplements
	@OneToMany(mappedBy = "clePrimaire.suplements")
	private List<Prevoir> prevoirs;

	@Transient
	private Integer nbJourContrat;

	public Contrat() {
	}

	public Contrat(Integer noContrat, Date dateContrat, Date dateEnlevement, Date dateRetour,
			Client client, Vehicule vehicule) {
		super();
		this.noContrat = noContrat;
		this.dateContrat = dateContrat;
		this.dateEnlevement = dateEnlevement;
		this.dateRetour = dateRetour;
		this.client = client;
		this.vehicule = vehicule;
	}

	// Permet l'execution automatique de la méthode après un persist
	// On peut avoir PostLoad après un find, PostUpdate après un Update
	// PostRemove après un Remove
	@PostPersist
	private void nombreJourContrat() {
		System.out.println("");
		System.out.println("Dans le post Persist");
		long diffMilli = this.dateRetour.getTime() - this.dateContrat.getTime();
		long transMilli = 1000 * 60 * 60 * 24;
		long diff = diffMilli / transMilli;
		nbJourContrat = (int) (diff + 1);
		System.out.println("durée du contrat : " + nbJourContrat);
		System.out.println("");
	}

	// Permet l'execution automatique de la méthode avant un persist
	// On peut avoir PreUpdate avant un Update, PreRemove avant un Remove
	@PrePersist
	private void nombreJourPrecontrat() {
		System.out.println("");
		System.out.println("Dans le pre Persist");
		long diffMilli = this.dateRetour.getTime() - this.dateContrat.getTime();
		long transMilli = 1000 * 60 * 60 * 24;
		long diff = diffMilli / transMilli;
		nbJourContrat = (int) (diff + 1);
		System.out.println("durée du contrat : " + nbJourContrat);
		System.out.println("");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noContrat == null) ? 0 : noContrat.hashCode());
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
		Contrat other = (Contrat) obj;
		if (noContrat == null) {
			if (other.noContrat != null)
				return false;
		} else if (!noContrat.equals(other.noContrat))
			return false;
		return true;
	}

	public Date getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}

	public Date getDateEnlevement() {
		return dateEnlevement;
	}

	public void setDateEnlevement(Date dateEnlevement) {
		this.dateEnlevement = dateEnlevement;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Integer getNoContrat() {
		return noContrat;
	}

	public void setNoContrat(Integer noContrat) {
		this.noContrat = noContrat;
	}

	public List<Prevoir> getPrevoirs() {
		return prevoirs;
	}

	public void setSuplements(List<Prevoir> prevoirs) {
		this.prevoirs = prevoirs;
	}

}

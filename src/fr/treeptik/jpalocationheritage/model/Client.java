package fr.treeptik.jpalocationheritage.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codecl")
	private Integer codeClient;

	@Column(name = "nomcl")
	private String nomClient;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "ville")
	private String ville;

	@ElementCollection
	@CollectionTable(name = "ClientPhone")
	@MapKeyColumn(name = "typePhone")
	@Column(name = "numberPhone")
	private Map<String, String> phoneNumbers;

	public Client() {
	}

	public Client(Integer codeClient, String nomClient, String adresse, String ville,
			Map<String, String> phoneNumbers) {
		super();
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.ville = ville;
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeClient == null) ? 0 : codeClient.hashCode());
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
		Client other = (Client) obj;
		if (codeClient == null) {
			if (other.codeClient != null)
				return false;
		} else if (!codeClient.equals(other.codeClient))
			return false;
		return true;
	}

	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Integer getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Integer codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}

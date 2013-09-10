package fr.treeptik.jpalocationheritage.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fr.treeptik.jpalocationheritage.model.Client;
import fr.treeptik.jpalocationheritage.model.Contrat;
import fr.treeptik.jpalocationheritage.model.ContratDetail;
import fr.treeptik.jpalocationheritage.model.Moto;
import fr.treeptik.jpalocationheritage.model.Prevoir;
import fr.treeptik.jpalocationheritage.model.PrevoirPK;
import fr.treeptik.jpalocationheritage.model.Suplements;
import fr.treeptik.jpalocationheritage.model.TypeVoiture;
import fr.treeptik.jpalocationheritage.model.Vehicule;
import fr.treeptik.jpalocationheritage.model.Voiture;

@RunWith(JUnit4.class)
public class TestContratDetail {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory(
			"locationheritage").createEntityManager();

	@Test
	public void testContratDetail() throws ParseException {
		List<TypeVoiture> typeVoitures = new ArrayList<>();
		typeVoitures.add(new TypeVoiture(null, "Citadine Essence", 5, 65));
		typeVoitures.add(new TypeVoiture(null, "Citadine Diesel", 5, 70));
		typeVoitures.add(new TypeVoiture(null, "Monospace Essence", 5, 90));
		typeVoitures.add(new TypeVoiture(null, "Monospace Diesel", 5, 110));

		List<List<String>> listOptions = new ArrayList<>();
		List<String> options = new ArrayList<>();
		options.add("Climatisation");
		options.add("6 Vitesses");
		options.add("Vitres électrique");
		listOptions.add(options);
		options = new ArrayList<>();
		options.add("5 Vitesses");
		options.add("Vitres électrique");
		listOptions.add(options);
		options = new ArrayList<>();
		options.add("Climatisation");
		options.add("Vitres électrique");
		listOptions.add(options);

		List<Vehicule> vehicules = new ArrayList<>();
		vehicules.add(new Voiture(null, "Renault", "Clio", "Blanche", 0, true, typeVoitures.get(0),
				listOptions.get(0)));
		vehicules.add(new Voiture(null, "Renault", "Scenic", "Bleu", 0, true, typeVoitures.get(2),
				listOptions.get(2)));
		vehicules.add(new Voiture(null, "Peugeot", "207", "Bleu gris", 0, true,
				typeVoitures.get(1), listOptions.get(1)));
		vehicules.add(new Voiture(null, "Citroen", "C4", "Blanche", 0, false, typeVoitures.get(3),
				listOptions.get(2)));
		vehicules.add(new Moto(null, "Yamaha", "xz50", "Bleu", 0, true));
		vehicules.add(new Moto(null, "Ducati", "500S", "Bleu", 0, true));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		List<Client> clients = new ArrayList<>();
		clients.add(new Client(null, "NomClient1", "Adresse Client 1", "Ville Client1", null));
		clients.add(new Client(null, "NomClient2", "Adresse Client 2", "Ville Client3", null));
		clients.add(new Client(null, "NomClient3", "Adresse Client 3", "Ville Client3", null));

		Suplements suplements = new Suplements(null, "Cousin", 6);

		List<Contrat> contrats = new ArrayList<>();
		contrats.add(new Contrat(null, dateFormat.parse("26/12/2012"), dateFormat
				.parse("26/12/2012"), dateFormat.parse("28/12/2012"), clients.get(0), vehicules
				.get(0)));
		contrats.add(new Contrat(null, dateFormat.parse("26/12/2012"), dateFormat
				.parse("26/12/2012"), dateFormat.parse("28/12/2012"), clients.get(1), vehicules
				.get(1)));
		contrats.add(new Contrat(null, dateFormat.parse("20/07/2013"), dateFormat
				.parse("20/07/2013"), dateFormat.parse("22/07/2013"), clients.get(0), vehicules
				.get(4)));
		contrats.add(new Contrat(null, dateFormat.parse("20/07/2013"), dateFormat
				.parse("20/07/2013"), dateFormat.parse("27/07/2013"), clients.get(2), vehicules
				.get(3)));

		List<PrevoirPK> clePrimaires = new ArrayList<>();
		clePrimaires.add(new PrevoirPK(contrats.get(0), suplements));
		clePrimaires.add(new PrevoirPK(contrats.get(1), suplements));
		clePrimaires.add(new PrevoirPK(contrats.get(2), suplements));

		List<Prevoir> prevoirs = new ArrayList<>();
		prevoirs.add(new Prevoir(clePrimaires.get(0), 3));
		prevoirs.add(new Prevoir(clePrimaires.get(1), 0));
		prevoirs.add(new Prevoir(clePrimaires.get(2), 1));

		entityManager.getTransaction().begin();

		for (TypeVoiture typeVoiture : typeVoitures) {
			entityManager.persist(typeVoiture);
		}

		for (Vehicule vehicule : vehicules) {
			entityManager.persist(vehicule);

		}

		for (Client client : clients) {
			entityManager.persist(client);
		}

		entityManager.persist(suplements);
		for (Contrat contrat : contrats) {
			entityManager.persist(contrat);
		}

		for (Prevoir prevoir : prevoirs) {
			entityManager.persist(prevoir);
		}

		entityManager.getTransaction().commit();

		System.out.println("********* Class ClientDetail ********");
		TypedQuery<ContratDetail> query = entityManager
				.createQuery(
						"SELECT new fr.treeptik.jpalocationheritage.model.ContratDetail(c.client.nomClient,c.dateContrat,c.vehicule.marque,tv.descriptionType) FROM Contrat c "
								+ " LEFT JOIN c.vehicule.typeVoiture tv", ContratDetail.class);
		// On utilise LEFT JOIN pour avoir les contrats même si on a pas de description de voiture
		// (pour les vehicule de type moto)
		List<ContratDetail> list = query.getResultList();
		for (ContratDetail contratDetail : list) {
			System.out.println("Contrat nom Client : " + contratDetail.getNomClient());
			System.out.println("Contrat marque voiture : " + contratDetail.getMarqueVoiture());
			System.out.println("Contrat description : " + contratDetail.getDescriptionType());
			System.out.println("Contrat date : " + contratDetail.getDateContrat());
			System.out.println("");

		}

	}
}

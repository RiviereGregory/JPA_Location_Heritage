package fr.treeptik.jpalocationheritage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fr.treeptik.jpalocationheritage.model.Moto;
import fr.treeptik.jpalocationheritage.model.TypeVoiture;
import fr.treeptik.jpalocationheritage.model.Vehicule;
import fr.treeptik.jpalocationheritage.model.Voiture;

@RunWith(JUnit4.class)
public class TestHeritage {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory(
			"locationheritage").createEntityManager();

	@Test
	public void testVehculeHeritage() {
		List<String> options = new ArrayList<>();
		options.add("Climatisation");
		options.add("6 Vitesses");
		options.add("Vitres électrique");
		List<TypeVoiture> typeVoitures = new ArrayList<>();
		typeVoitures.add(new TypeVoiture(null, "Citadine Essence", 5, 65));
		typeVoitures.add(new TypeVoiture(null, "Citadine Diesel", 5, 70));
		typeVoitures.add(new TypeVoiture(null, "Monospace Essence", 5, 90));
		typeVoitures.add(new TypeVoiture(null, "Monospace Diesel", 5, 110));

		List<List<String>> listOptions = new ArrayList<>();
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

		entityManager.getTransaction().begin();
		for (TypeVoiture typeVoiture : typeVoitures) {
			entityManager.persist(typeVoiture);
		}

		entityManager.persist(new Voiture(null, "Renault", "Clio", "Blanche", 0, true, typeVoitures
				.get(0), listOptions.get(0)));
		
		for (Vehicule vehicule : vehicules) {
			entityManager.persist(vehicule);

		}

		entityManager.getTransaction().commit();

	}

}

package fr.treeptik.jpalocationheritage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fr.treeptik.jpalocationheritage.model.TypeVoiture;
import fr.treeptik.jpalocationheritage.model.Voiture;

@RunWith(JUnit4.class)
public class TestVoitureElementCollection {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("locationheritage")
			.createEntityManager();

	@Test
	public void testListOption() {
		List<String> options = new ArrayList<>();
		options.add("Climatisation");
		options.add("6 Vitesse");
		options.add("Vitres électrique");

		TypeVoiture typeVoiture = new TypeVoiture(null, "Citadine Essence", 5, 65);

		Voiture voiture = new Voiture(null, "Renault", "Scenic", "Bleu acier", 0, true,
				typeVoiture, options);

		entityManager.getTransaction().begin();
		entityManager.persist(typeVoiture);
		entityManager.persist(voiture);
		entityManager.getTransaction().commit();

	}

}

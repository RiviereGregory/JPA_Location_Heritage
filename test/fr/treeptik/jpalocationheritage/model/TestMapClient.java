package fr.treeptik.jpalocationheritage.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fr.treeptik.jpalocationheritage.model.Client;

@RunWith(JUnit4.class)
public class TestMapClient {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory(
			"locationheritage").createEntityManager();

	@Test
	public void testMapClientPhone() {

		Map<String, String> map = new HashMap<>();
		map.put("Portable", "0615483214");
		map.put("Fixe", "0491483214");
		map.put("Travail", "0442159876");

		Client client = new Client(null, "client Test Phone", "Map", "HashMap", map);

		entityManager.getTransaction().begin();

		entityManager.persist(client);

		entityManager.getTransaction().commit();

	}
}

package com.spring5.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring5.models.Car;



//@Service
@Repository
//@Named
public class CarImpl implements CarDao{
	
	private static final String JPA_UNIT_NAME = "JPACriteriaBuilder";
	private EntityManager entityManager;
	
	public List<String> getCarDetails() {

		List<String> cars = new ArrayList<String>();

		cars.add(0, "Santro");
		cars.add(1, "Zen");
		cars.add(2, "Alto");
		cars.add(3, "Qualis");
		cars.add(4, "Innova");

		for (String c : cars) {
			System.out.println(c);
		}

		return cars;

	}
	
	/**
	 * L'opération Read
	 * @return toutes les Carnes dans la base de données.
	 */
	public List<Car> selectAll() {
		List<Car> Cars = getEntityManager().createQuery(
				"select p from Car p").getResultList();
		return Cars;
	}

	/**
	 * L'opération Create
	 * @param u La Carne à insérer dans la base de données.
	 * @return La Carne insérée
	 */
	public Car insert(Car u) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(u);
		getEntityManager().getTransaction().commit();
		return u;
	}

	/**
	 * L'opération Update
	 * @param u La Carne à mettre à jour dans la base de données.
	 * @return La Carne mise à jour
	 */
	public Car update(Car u) {
		getEntityManager().getTransaction().begin();
		u = getEntityManager().merge(u);
		getEntityManager().getTransaction().commit();
		return u;
	}

	/**
	 * L'opération Delete
	 * @param u La Carne à supprimer de la base de donnés.
	 */
	public void delete(Car u) {
		getEntityManager().getTransaction().begin();
		u = getEntityManager().merge(u);
		getEntityManager().remove(u);
		getEntityManager().getTransaction().commit();
	}

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}

}

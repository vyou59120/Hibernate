package com.spring5.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring5.dao.CarDao;
import com.spring5.dao.CarImpl;
import com.spring5.models.Car;


//@Component
//Component à ajouter si on veuty utiliser jpa etc...
@ManagedBean(name = "carBean")
//@Named( "CarBean")
@RequestScoped
public class CarBean {

//	@Autowired
//	CarDao carDao;
	
	public void setCarDao(CarDao carDao) {
//		this.carDao = carDao;
	}

	public List<String> fetchCarDetails() {

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
//		return carDao.getCarDetails();
	}

	
}

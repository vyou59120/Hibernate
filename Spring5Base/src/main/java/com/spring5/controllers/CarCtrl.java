package com.spring5.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring5.dao.CarDao;
import com.spring5.dao.CarImpl;
import com.spring5.models.Car;

@ManagedBean(name = "carCtrl", eager = true)
@SessionScoped
public class CarCtrl {


    private DataModel cars;
	
	private static final Car[] carss = new Car[] { 
			new Car(1L,"FORD", "2008"),
			new Car(2L,"RENAULT", "2019")
	};
	
	private Car newCar = new Car();
	private Car editCar;
	private CarImpl carDao = new CarImpl();
	
	private DataModel<Car> employeeDataModel 
    = new ArrayDataModel<Car>(carss);

	 public DataModel<Car> getEmployees() { 
	    return employeeDataModel; 
	 }	

	public String createCar() {
		System.out.println("createCar");
		carDao.insert(newCar);
		newCar = new Car();
		cars.setWrappedData(carDao.selectAll());
		return "cars";
	}

	public String deleteCar() {
		Car p = (Car) cars.getRowData();
		carDao.delete(p);
		cars.setWrappedData(carDao.selectAll());
		return null;
	}

	public String editCar() {
		editCar = (Car) cars.getRowData();
		return "edit";
	}

	public String updateCar() {
		carDao.update(editCar);
		cars.setWrappedData(carDao.selectAll());
		return "list";
	}

	public DataModel getCars() {
		if (cars == null) {
			cars = new ListDataModel();
			cars.setWrappedData(carDao.selectAll());
		}
		return cars;
	}

	public void setCars(DataModel cars) {
		this.cars = cars;
	}

	public Car getNewCar() {
		return newCar;
	}

	public void setNewCar(Car person) {
		this.newCar = person;
	}

	public Car getEditCar() {
		return editCar;
	}

	public void setEditPerson(Car editCar) {
		this.editCar = editCar;
	}
	
}

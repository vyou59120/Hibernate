package com.concretepage.entities;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import com.concretepage.StudentService;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="dtLazyViewStudent")
@ViewScoped
public class LazyViewStudent implements Serializable {
    
    private LazyDataModel<Student> lazyModelStudent;
     
    private Student selectedStudent;
     
    @ManagedProperty("#{studentService}")
    private StudentService studentService;
     
    @PostConstruct
    public void init() {
    	lazyModelStudent = new StudentLazyDataModel(studentService.getStudentsList());
    }
 
    public LazyDataModel<Student> getLazyModel() {
        return lazyModelStudent;
    }
 
    public Student getSelectedStudent() {
        return selectedStudent;
    }
 
    public void setselectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
    
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Student Selected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public LazyDataModel<Student> getLazyModelStudent() {
		return lazyModelStudent;
	}

	public void setLazyModelStudent(LazyDataModel<Student> lazyModelStudent) {
		this.lazyModelStudent = lazyModelStudent;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

    
}


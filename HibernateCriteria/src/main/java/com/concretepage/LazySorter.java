package com.concretepage;

import java.util.Collections;
import java.util.Comparator;
import org.primefaces.model.SortOrder;
import com.concretepage.entities.Student;
 
public class LazySorter implements Comparator<Student> {
 
    private String sortField;
     
    private SortOrder sortOrder;
    
    private int value;
     
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Student student1, Student student2) {
        try {
        	
        	switch(sortField) {
        	
	        	case "id":
	        		// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	                value = student1.getId() > student2.getId() ? -1 : (student1.getId() < student2.getId()) ? 1 : 0;   	           
	            break;
	        	case "name":
	                if (student1.getName().compareTo(student2.getName()) < 0) {
	                	value = -1 ;
	                }
					else {
							if (student1.getName().compareTo(student2.getName()) > 0)
								value = 1;
							else
								value = 0;
					}
	            break;
	        	case "age":
	                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	        		value = student1.getAge() > student2.getAge() ? -1 : (student1.getAge() < student2.getAge()) ? 1 : 0;
	            break;
	        	default:
	                System.out.println("Il faut davantage travailler.");
	        	}
        	return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}

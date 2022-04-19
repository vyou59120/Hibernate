package com.concretepage.entities;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.concretepage.LazySorter;

import javassist.bytecode.stackmap.TypeData.ClassName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class StudentLazyDataModel extends LazyDataModel<Student> {

	
	private List<Student> datasource;
	
	@Override
	public Student getRowData(String rowKey) {
        for(Student student : datasource) {
            if(String.valueOf(student.getId()).equals(rowKey))
                return student;
        }
 
        return null;
    }
	
	@Override
    public Object getRowKey(Student student) {
        return student.getId();
    }
	
	public StudentLazyDataModel(List<Student> datasource) {
        this.datasource = datasource;
    }
	
    @Override
    public List<Student> load(int first, int pageSize, String sortField,
                               SortOrder sortOrder, Map<String, Object> filters) {
    	
    	List<Student> data = new ArrayList<Student>();

 
    	//filter
        for(Student student : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(student.getClass().getField(filterProperty).get(student));
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(student);
            }
        }
 
        //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        	
        
        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}
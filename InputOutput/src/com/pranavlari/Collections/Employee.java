package com.pranavlari.Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String dept;
    private List<Integer> subEmp;
    //act a  version for class when writing to file
    private long serialVersionUID = 1L;

    public Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.subEmp = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public List<Integer> getSubEmp() {
        return subEmp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSubEmp(List<Integer> subEmp) {
        this.subEmp = subEmp;
    }
}

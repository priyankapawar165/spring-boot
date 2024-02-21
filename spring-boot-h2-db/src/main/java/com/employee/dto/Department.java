package com.employee.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "department")
@Entity

public class Department {

    @Id@GeneratedValue
    private int id;
    private String deptName;
    private String deptSize;
    private String deptHead;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptSize() {
        return deptSize;
    }

    public void setDeptSize(String deptSize) {
        this.deptSize = deptSize;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }
}

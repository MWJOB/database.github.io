package com.mycompany.sql103;

/**
 * @프로그램:Student bean getter and setter
 * @author:학번:2016214378 이름:박민우
 * @날짜: 2021.10.09
 */
public class StudentBean {
    String id;
    String name;
    String deptName;
    int totCred;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getTotCred() {
        return totCred;
    }

    public void setTotCred(int totCred) {
        this.totCred = totCred;
    }
}

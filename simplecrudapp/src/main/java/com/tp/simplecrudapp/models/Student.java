package com.tp.simplecrudapp.models;

public class Student {

    College associatedCollege;
    Integer studentId;
    String name;


    public College getAssociatedCollege() {
        return associatedCollege;
    }

    public void setAssociatedCollege(College associatedCollege) {
        this.associatedCollege = associatedCollege;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

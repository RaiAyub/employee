package com.example.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

//Serializable: helps transform Employee into different types of stream
//                :sent to front end as a json
//                :saved into the database
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String email;
    private String name;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String xml;
    private String department;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee (){}

    public Employee (String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode, String xml, String department)
    {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
        this.xml = xml;
        this.department=department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id = " + id +  " \n " +
                "name =" + name + " \n " +
                "email = " + email + " \n " +
                "jobTitle = " + jobTitle + " \n " +
                "imageUrl = " + imageUrl + " \n " +
                "xml = " + xml + "\n" +
                "department = "+ department + "\n" +
                "}";
    }
}

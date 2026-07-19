package com.example.visitorlog.model;

public class Visitor {

        private Long id;
        private String name;
        private String company;
        private String purpose;

        public Visitor() {
        }
        // constructor
    public Visitor(Long id, String name, String company, String purpose) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.purpose = purpose;
    }
       // getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

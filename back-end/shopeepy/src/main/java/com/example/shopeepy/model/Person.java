package com.example.shopeepy.model;


public class Person {
    private String personId;
    private String name;
    private String familyName;
    private String age;
    private String role;


    public Person(String personId, String name, String familyName, String age, String role) {
        this.personId = personId;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.role = role;
    }





    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age='" + age + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

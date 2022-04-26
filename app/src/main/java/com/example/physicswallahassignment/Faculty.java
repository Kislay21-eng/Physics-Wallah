package com.example.physicswallahassignment;

public class Faculty {
    private String name;
    private String subject;
    private String college;
    private String personURL;

    public Faculty(){}
    public Faculty(String name, String subject, String college, String personURL){
        this.name = name;
        this.subject = subject;
        this.college = college;
        this.personURL = personURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPersonURL() {
        return personURL;
    }

    public void setPersonURL(String personURL) {
        this.personURL = personURL;
    }
}

package org.imaohd.model;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private String email;
    private String cellPhone;
    private LocalDateTime registerDate;

    public User() {
        this.registerDate = LocalDateTime.now();
    }

    public User(String name, String lastname, int age, String email, String cellPhone) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.cellPhone = cellPhone;
        this.registerDate = LocalDateTime.now();
    }

    public User(int id, String name, String lastname, int age, String email, String cellPhone, LocalDateTime registerDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.cellPhone = cellPhone;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}

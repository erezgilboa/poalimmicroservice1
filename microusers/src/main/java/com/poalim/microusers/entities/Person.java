package com.poalim.microusers.entities;

import com.poalim.microusers.enums.Gender;
import com.poalim.microusers.viewmodel.PersonVm;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Document(collection = "person")
public class Person {

    public Person(Address address, Gender gender, String name, Integer age, Double height, Double weight) {

        this.address = address;
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person() {

    }

    @javax.persistence.Id
    @javax.persistence.Transient
    private String id;


    @NotNull(message = "address must not be null")
    private Address address;

    @NotNull(message = "gender must not be null")
    private Gender gender;

    @NotNull(message = "name must not be null")
    private String name;

    @NotNull(message = "age must not be null")
    private Integer age;

    @NotNull(message = "height must not be null")
    private Double height;

    private Double weight;

    public Person(PersonVm personVm) {

    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", address=" + address +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

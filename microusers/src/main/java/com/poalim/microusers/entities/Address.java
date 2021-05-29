package com.poalim.microusers.entities;

import com.poalim.microusers.enums.State;

import javax.validation.constraints.NotNull;

public class Address {

    @NotNull(message = "state must not be null")
    private State state;

    @NotNull(message = "city must not be null")
    private String city;

    @NotNull(message = "street must not be null")
    private String street;

    @NotNull(message = "zipcode must not be null")
    private String zipcode;

    @NotNull(message = "containsAnimals must not be null")
    private Boolean containsAnimals;

    public Address(State state, String city, String street, String zipcode, Boolean containsAnimals) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.containsAnimals = containsAnimals;
    }

    public Address() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Boolean getContainsAnimals() {
        return containsAnimals;
    }

    public void setContainsAnimals(Boolean containsAnimals) {
        this.containsAnimals = containsAnimals;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state=" + state +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", containsAnimals=" + containsAnimals +
                '}';
    }

}

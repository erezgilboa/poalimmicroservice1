package com.poalim.microusers.viewmodel;

import com.poalim.microusers.enums.State;

import java.io.Serializable;

public class AddressVm implements Serializable {

    private State state;

    private String city;

    private String street;

    private String zipcode;

    private Boolean containsAnimals;

    public AddressVm(State state, String city, String street, String zipcode, Boolean containsAnimals) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.containsAnimals = containsAnimals;
    }

    public AddressVm() {

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

    public AddressVm clone() {
        AddressVm addressVm = new AddressVm();
        addressVm.setCity(this.getCity());
        addressVm.setContainsAnimals(this.getContainsAnimals());
        addressVm.setState(this.getState());
        addressVm.setZipcode(this.getZipcode());
        addressVm.setStreet(this.getStreet());
        return addressVm;
    }

    @Override
    public String toString() {
        return "AddressVm{" +
                "state=" + state +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", containsAnimals=" + containsAnimals +
                '}';
    }
}

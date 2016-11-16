package com.journaldev.spring.model;

import javax.persistence.*;

/**
 * Created by Armen on 11/8/2016.
 */
@Entity
@Table(name = "Address")
public class Address {

    /*@Column(name = "id", unique = true, nullable = false)
@GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_id")
    private int personId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Column(name="address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressService{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}

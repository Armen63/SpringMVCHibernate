package com.journaldev.spring.dao;

import com.journaldev.spring.model.Address;

import java.util.List;

/**
 * Created by Armen on 11/15/2016.
 */
public interface AddressDAO {
    public void addAddress(Address p);
    public void updatePerson(Address p);
    public List<Address> listAddress();
    public Address getAddressById(int id);
    public void removeAddress(int id);

}

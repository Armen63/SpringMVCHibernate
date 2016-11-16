package com.journaldev.spring.service;

import com.journaldev.spring.model.Address;

import java.util.List;

/**
 * Created by Armen on 11/15/2016.
 */
public interface AddressService {
    public void addAddress(Address a);
    public void updateAddress(Address a);
    public List<com.journaldev.spring.model.Address> listAddresses();
    public AddressService getAddressById(int id);
    public void removeAddress(int id);
}

package com.journaldev.spring.service;

import com.journaldev.spring.dao.AddressDAO;
import com.journaldev.spring.model.Address;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Armen on 11/15/2016.
 */
@Service
public class AddressServiceImpl implements AddressService {

    private AddressDAO addressDAO;

    public void setAddressDAO(AddressDAO addressDAO){this.addressDAO = addressDAO;}

    @Override
    @Transactional
    public void addAddress(Address a) {
        this.addressDAO.addAddress((com.journaldev.spring.model.Address) a);
    }

    @Override
    @Transactional
    public void updateAddress(Address p) {
        this.addressDAO.updatePerson(p);
    }

    @Override
    @Transactional
    public List<com.journaldev.spring.model.Address> listAddresses() {
        return this.addressDAO.listAddress();
    }

    @Override
    @Transactional
    public AddressService getAddressById(int id) {
        return (AddressService) this.addressDAO.getAddressById(id);
    }

    @Override
    @Transactional
    public void removeAddress(int id) {
        this.addressDAO.removeAddress(id);
    }
}

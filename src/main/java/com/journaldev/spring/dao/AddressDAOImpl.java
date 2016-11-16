package com.journaldev.spring.dao;

import com.journaldev.spring.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Armen on 11/15/2016.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AddressDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){this.sessionFactory = sf;}

    @Override
    public void addAddress(Address a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("AddressService saved successfully, Addres Details=" + a);
    }

    @Override
    public void updatePerson(Address a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        logger.info("AddressService saved successfully, Addres Details=" + a);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Address> listAddress() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Address> addressList = session.createQuery("from address").list();
        for(Address a: addressList){
            logger.info("AddressService List::" +a);
        }
        return  addressList;
    }

    @Override
    public Address getAddressById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address a = (Address) session.load(Address.class, new Integer(id));
        logger.info("AddressService loaded successfully, ADdress deteails" + a);
        return a;
    }

    @Override
    public void removeAddress(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address a = (Address) session.load(Address.class,new Integer(id));
        if(null != a){
            session.delete(a);
        }
        logger.info("AddressService deleted successfully, AddressService details" +a);


    }
}

package com.myapp.kuleba.bank.services;

import com.myapp.kuleba.bank.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Long> {

    Address findAddressByCityAndStreetAndBuildingAndApartment(String city, String street, String building, String apartment);

}

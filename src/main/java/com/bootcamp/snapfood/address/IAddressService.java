package com.bootcamp.snapfood.address;

import java.util.List;

public interface IAddressService {

    Address save(Address address);

    Address update(Address address);

    void delete(Long id);

    Address findById(Long id);

    List<Address> findAll();
}

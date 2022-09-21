package com.bootcamp.snapfood.address;

import com.bootcamp.snapfood.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService{
    private final AddressRepository repository;

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public Address update(Address address) {
        Address savedBefore = findById(address.getId());

        savedBefore.setAddress(address.getAddress());
        savedBefore.setLocation(address.getLocation());
        return repository.save(savedBefore);
    }

    @Override
    public void delete(Long id) {
        val address = findById(id);
        repository.delete(address);
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> optionalAddress = repository.findById(id);
        if (optionalAddress.isEmpty()) throw new NotFoundException("NotFound Address");
        return optionalAddress.get();
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) repository.findAll();
    }

}

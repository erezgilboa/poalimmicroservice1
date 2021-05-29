package com.poalim.microusers.converter;

import com.poalim.microusers.entities.Address;
import com.poalim.microusers.viewmodel.AddressVm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressConverter implements EntityConverter<AddressVm, Address> {
    @Override
    public Address convertFromF(AddressVm addressVm) {
        Address address = new Address();
        address.setCity(addressVm.getCity());
        address.setContainsAnimals(addressVm.getContainsAnimals());
        address.setState(addressVm.getState());
        address.setStreet(addressVm.getStreet());
        address.setZipcode(addressVm.getZipcode());
        return address;
    }

    @Override
    public AddressVm convertFromDB(Address address) {
        AddressVm addressVm = new AddressVm();
        addressVm.setCity(address.getCity());
        addressVm.setContainsAnimals(address.getContainsAnimals());
        addressVm.setState(address.getState());
        addressVm.setStreet(address.getStreet());
        addressVm.setZipcode(address.getZipcode());
        return addressVm;
    }

    @Override
    public List<Address> convertListFromF(List<AddressVm> addressVmList) {
        if (addressVmList == null)
            return null;
        List<Address> addresses = new ArrayList<>();
        for (AddressVm addressVm : addressVmList)
            addresses.add(convertFromF(addressVm));
        return addresses;
    }

    @Override
    public List<AddressVm> convertListFromDB(List<Address> addressList) {
        if (addressList == null)
            return null;
        List<AddressVm> addressVms=new ArrayList<>();
        for(Address address:addressList)
            addressVms.add(convertFromDB(address));
        return addressVms;
    }
}

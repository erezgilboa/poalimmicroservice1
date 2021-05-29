package com.poalim.microusers.controller.validation;

import com.poalim.microusers.controller.PersonValidation;
import com.poalim.microusers.enums.State;
import com.poalim.microusers.utils.FieldConstants;
import com.poalim.microusers.utils.ResultWithSuccess;
import com.poalim.microusers.viewmodel.AddressVm;
import com.poalim.microusers.viewmodel.PersonVm;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PersonValidationImpl implements /*ConstraintValidator*/ PersonValidation {


    @Override
    public ResultWithSuccess<String> validateSavePerson(PersonVm entity) {
        ResultWithSuccess<String> resultWithSuccess = validatePersonNotNull(entity);
        if (!resultWithSuccess.isSuccess())
            return resultWithSuccess;
        if (entity.getName().length() < 3 || entity.getName().length() > 20)
            return new ResultWithSuccess<>(false, "person name should be between 3 to 30 characters");
        if (entity.getAge() < 0 || entity.getAge() > 200)
            return new ResultWithSuccess<>(false, "person age should be between 0 to 200");
        if (entity.getHeight() < 0)
            return new ResultWithSuccess<>(false, "person Height should be bigger than 0");
        if (entity.getWeight() != null && entity.getWeight() < FieldConstants.minWeight)
            return new ResultWithSuccess<>(false, "person Weight should be bigger than " + FieldConstants.minWeight);
        if (entity.getWeight() != null && entity.getWeight() > FieldConstants.maxWeight)
            return new ResultWithSuccess<>(false, "person Weight should be smaller than " + FieldConstants.maxWeight);

        return validateAddress(entity.getAddressVm());
    }

    private ResultWithSuccess<String> validatePersonNotNull(PersonVm entity) {
        if (entity == null)
            return new ResultWithSuccess<>(false, "person is null");
        if (entity.getHeight() == null || entity.getAge() == null || entity.getName() == null || entity.getGender() == null)
            return new ResultWithSuccess<>(false, "some properties in person is null");
        return new ResultWithSuccess<>(true, "");
    }

    private ResultWithSuccess<String> validateAddress(AddressVm addressVm) {
        ResultWithSuccess<String> resultWithSuccess = validateAddressNotNull(addressVm);
        if (!resultWithSuccess.isSuccess())
            return resultWithSuccess;
        if (!addressVm.getState().equals(State.Israel))
            return new ResultWithSuccess<>(false, "address state should be israel");
        if (addressVm.getCity().length() < 3 || addressVm.getCity().length() > 20)
            return new ResultWithSuccess<>(false, "address city should be between 3 to 20 characters");
        if (addressVm.getStreet().length() < 3 || addressVm.getStreet().length() > 50)
            return new ResultWithSuccess<>(false, "address street should be between 3 to 50 characters");
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (!pattern.matcher(addressVm.getZipcode()).matches())
            return new ResultWithSuccess<>(false, "zipcode should be number");
        return new ResultWithSuccess<>(true, "");
    }

    private ResultWithSuccess<String> validateAddressNotNull(AddressVm addressVm) {
        if (addressVm == null)
            return new ResultWithSuccess<>(false, "person is null");
        if (addressVm.getStreet() == null || addressVm.getCity() == null || addressVm.getState() == null || addressVm.getContainsAnimals() == null || addressVm.getZipcode() == null)
            return new ResultWithSuccess<>(false, "some properties in address is null");
        return new ResultWithSuccess<>(true, "");
    }
}

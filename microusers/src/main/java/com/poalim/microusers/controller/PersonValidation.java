package com.poalim.microusers.controller;

import com.poalim.microusers.utils.ResultWithSuccess;
import com.poalim.microusers.viewmodel.PersonVm;

public interface PersonValidation {

    ResultWithSuccess<String> validateSavePerson(PersonVm entity);
}

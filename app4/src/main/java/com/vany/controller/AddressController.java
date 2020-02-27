package com.vany.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vany.exception.UserServiceException;
import com.vany.model.Address;
import com.vany.repository.AddressRepository;
import com.vany.repository.ProfileRespositery;
import com.vany.service.ErrorServiceMessage;
import com.vany.service.LogService;
import com.vany.service.ResponseEntityResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "A1",description = "This Address Contoller")
@RequestMapping(value = "/profile/{profileId}")
public class AddressController {

	@Autowired
	public ProfileRespositery profileRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@GetMapping(value = "/address/{addressId}")
	@ApiOperation(value = "Retruning  Address details by id")
	public ResponseEntity<?> findAddress(@PathVariable("profileId")Integer profileId, @PathVariable("addressId")Integer addressId) {
		return this.getALlAddressByAddressId(profileId,addressId);
	}


	//---------------- This sections custome method implementions
	
	private ResponseEntity<?> getALlAddressByAddressId(Integer profileId, Integer addressId) {
		Optional<Address> address=null;
		try {
			this.checkProfileIdValidOrNot(profileId);
			address=addressRepo.findById(profileId);
			if(address.isEmpty()) {
				return ResponseEntityResult.badRequest(ErrorServiceMessage.NO_REC_ADDRESS+addressId);
			}
		} catch (Exception e) {
			LogService.setLogger(e.getMessage());
			return ResponseEntityResult.badRequest(e.getMessage());
		}
		return ResponseEntityResult.successResponseEntity(address);
	}

	
	// This is checking passing profile id is valid or not	
	public void checkProfileIdValidOrNot(Integer profileId) {
		if (!profileRepo.existsById(profileId)) {
			throw new UserServiceException(ErrorServiceMessage.NO_REC_PROFILE+profileId);
		}
	}
	
}

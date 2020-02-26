package com.vany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vany.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	// This method return list of Address by profile id
	@Query(value = "select * from address  where profile_id=:profileId", nativeQuery = true)
	List<Address> findAddressByProfileId(@Param("profileId") Integer profileId);

}
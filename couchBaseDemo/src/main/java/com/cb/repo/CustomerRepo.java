package com.cb.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.cb.model.Customer;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer, Id>{
	
}
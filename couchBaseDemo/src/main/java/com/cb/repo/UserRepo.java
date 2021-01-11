package com.cb.repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.cb.model.User;
@Repository
public interface UserRepo extends CouchbaseRepository<User, Integer>{
	
	

}

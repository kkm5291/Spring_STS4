package com.tuyano.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tuyano.springboot.MyDataMongo;

import java.util.List;

public interface MyDataMongoRepository 
	extends MongoRepository<MyDataMongo, Long> {
	
	public List<MyDataMongo> findByName(String name);
}

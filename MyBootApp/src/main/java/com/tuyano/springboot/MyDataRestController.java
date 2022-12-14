package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyDataRestController {

	@Autowired
	private MyDataService service;
	
	@Autowired
	MySampleBean bean;
	
	@RequestMapping("/count")
	public int count() {
		return bean.count();
	}
	
	@RequestMapping("/rest")
	public List<MyData> restAll() {
		return service.getAll();
	}
	
	@RequestMapping("/rest/{num}")
	public MyData restBy(@PathVariable int num) {
		return service.get(num);
	}
	
	
}

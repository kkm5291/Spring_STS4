package com.tuyano.springboot;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;

import com.tuyano.springboot.repositories.MyDataMongoRepository;
import com.tuyano.springboot.repositories.MyDataRepository;

@Controller
public class HelloController {
	
	
//	@Autowired
//	private MyDataService service;
//	
//	@Autowired
//	MyDataBean myDataBean;
	
	@Autowired
	MyDataMongoRepository repository;
	
//	@RequestMapping(value = "page/{num}",
//			method = RequestMethod.GET)
//	public ModelAndView page(@PathVariable Integer num, ModelAndView mav) {
//		Page<MyData> page = service.getMyDataInPage(num);
//		mav.setViewName("index");
//		mav.addObject("title", "Find Page");
//		mav.addObject("msg", "MyData의 예제입니다");
//		mav.addObject("pagenumber", num);
//		mav.addObject("datalist", page);
//		return mav;
//	}
	
//	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
//	public ModelAndView indexById(@PathVariable long id, ModelAndView mav) {
//		mav.setViewName("pickup");
//		mav.addObject("title", "Pickup Page");
//		String table = "<table>"
//				+ myDataBean.getTableTagById(id)
//				+ "</table>";
//		mav.addObject("msg", "pickup data id = " + id);
//		mav.addObject("data", table);
//		return mav;
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title","Find Page");
		mav.addObject("msg","MyDataMongo의 예제입니다.");
		List<MyDataMongo> list = repository.findAll(); //●
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(
			@RequestParam("name") String name,
			@RequestParam("memo") String memo,
			ModelAndView mov) {
		MyDataMongo mydata = new MyDataMongo(name, memo);
		repository.save(mydata);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView find(ModelAndView mav) {
		mav.setViewName("find");
		mav.addObject("title","Find Page");
		mav.addObject("msg","MyData의 예제입니다.");
		mav.addObject("value","");
		List<MyDataMongo> list = repository.findAll(); //●
		mav.addObject("datalist", list);
		return mav;
	}
	
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("find") String param,
			ModelAndView mav) {
		mav.setViewName("find");
		if (param == ""){
			mav = new ModelAndView("redirect:/find");
		} else {
			mav.addObject("title","Find result");
			mav.addObject("msg","「" + param + "」의 검색 결과");
			mav.addObject("value",param);
			List<MyDataMongo> list = repository.findByName(param); //●
			mav.addObject("datalist", list);
		}
		return mav;
	}
//
//	@PostConstruct
//	public void init(){
//		MyData d1 = new MyData();
//		d1.setName("tuyano");
//		d1.setAge(123);
//		d1.setMail("kim@gilbut.co.kr");
//		d1.setMemo("090999999");
//		repository.save(d1);
//		MyData d2 = new MyData();
//		d2.setName("lee");
//		d2.setAge(15);
//		d2.setMail("lee@flower");
//		d2.setMemo("080888888");
//		repository.save(d2);
//		MyData d3 = new MyData();
//		d3.setName("choi");
//		d3.setAge(37);
//		d3.setMail("choi@happy");
//		d3.setMemo("070777777");
//		repository.save(d3);
//	}
//
}
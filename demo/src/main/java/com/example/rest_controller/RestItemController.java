package com.example.rest_controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ItemDAO;
import com.example.vo.ItemVO;

@CrossOrigin("*")
@RestController
public class RestItemController {
	
	@Autowired
	private ItemDAO iDAO = null;
	
	@RequestMapping(value="/rest/itemsearch",
			method = {RequestMethod.GET, RequestMethod.POST},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HashMap<String, Object> itemSearch(
			@RequestParam("txt") String txt,
			@RequestParam("key") String key) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(key.equals("abc")) {
			List<ItemVO> list = iDAO.selectItemSearch(txt);
			map.put("ret", "success");
			map.put("data", list);
			map.put("gar", "hello");
		} else {
			map.put("ret", 0);
			map.put("erro", "키값을 확인하세요");
		}
		return map;
	}
	
	@RequestMapping(value="/rest/itemone",
			method = {RequestMethod.GET, RequestMethod.POST},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HashMap<String, Object> itemOne(
			@RequestParam("no") int no,
			@RequestParam("key") String key) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(key.equals("abc")) {
			ItemVO obj = iDAO.selectItemOne(no);
			map.put("ret", "success");
			map.put("data", obj);
			map.put("gar", "hello");

		} else {
			map.put("ret", 0);
			map.put("erro", "키값을 확인하세요");
		}
		return map;
		
	}
}

package com.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.ItemDAO;
import com.example.vo.ItemVO;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
	
	@Autowired
	private ItemDAO iDAO = null;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession httpSession,
			@RequestParam(value="page", defaultValue = "1", required = false) int page) {
		httpSession.setAttribute("SESSION_BOARD_HIT_CHECK", 1);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", page*10-9);
		map.put("end", page*10);
		
		List<ItemVO> list = iDAO.selectItem(map);
		int cnt = iDAO.countItem();
		model.addAttribute("list", list);
		model.addAttribute("cnt", (cnt-1)/10+1);
		return "/item/list";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert() {
		return "1";
	}


}

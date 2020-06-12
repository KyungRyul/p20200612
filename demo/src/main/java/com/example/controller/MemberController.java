package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.MemberDAO;
import com.example.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO = null; //
	
	@RequestMapping(value="/memberlist")
	public String memberlist(Model model) {
		List<MemberVO> list = mDAO.selectMemberlist();
		model.addAttribute("name", "test"); //hashmap<key, value>
		model.addAttribute("list", list); //hashmap<key, value>
		return "memberlist";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginpost(@ModelAttribute MemberVO obj, HttpSession httpSession) {
		MemberVO obj1 = mDAO.selectMemberLogin(obj);
		if(obj1 != null) {
			httpSession.setAttribute("SESSION_ID", obj.getUserid());
			return "redirect:/";
		}
		return "redirect:/member/login";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join"; //join.jsp를 표시하시오.
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinpost(@ModelAttribute MemberVO obj) {
		System.out.println(obj.toString());
		int ret = mDAO.insertMember(obj);
		
		if(ret > 0) { //회원가입 성공시
			return "redirect:/";
		}
		
		//회원가입 실패시
		return "redirect:/member/join";
	}
	
}

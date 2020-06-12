package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.BoardDAO;
import com.example.vo.BoardVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardDAO bDAO = null;
	
	@RequestMapping(value="/getimg")
	public ResponseEntity<byte[]> getimg(@RequestParam("no") int no) {
		BoardVO obj = bDAO.selectBoardImg(no);
		try {
			if(obj.getBrd_img().length > 0) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.IMAGE_JPEG);
				ResponseEntity<byte[]> ret = new ResponseEntity<byte[]>(obj.getBrd_img(), header, HttpStatus.OK);
				return ret;
			}
			return null;
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
	@RequestMapping(value="/insertbatch", method = RequestMethod.GET)
	public String insertBatch(HttpSession httpSession, Model model) {
		String userid = (String)httpSession.getAttribute("SESSION_ID");
		if(userid == null) {
			return "redirect:/member/login";
		}
		model.addAttribute("userid", userid);
		return "/board/insertbatch";
	}
	
	@RequestMapping(value="/insertbatch", method = RequestMethod.POST) 
	public String insertBatchPost(@RequestParam("brd_title[]") String title[],
			@RequestParam("brd_content[]") String content[],
			@RequestParam("brd_id[]") String id[]) throws IOException {
		List<BoardVO> list = new ArrayList<BoardVO>();
		for(int i =0; i<title.length; i++) {
			BoardVO obj = new BoardVO();
			obj.setBrd_title(title[i]);
			obj.setBrd_content(content[i]);
			obj.setBrd_id(id[i]);
			list.add(obj);
		}
		
		//DAO로 obj값 전달하기
		bDAO.insertBoardBatch(list);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET) 
	public String insertBoard(HttpSession httpSession, Model model) {
		String userid = (String)httpSession.getAttribute("SESSION_ID");
		if(userid == null) {
			return "redirect:/member/login";
		}
		model.addAttribute("userid", userid);
		return "/board/insert";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST) 
	public String insertBoardPost(@ModelAttribute BoardVO obj, @RequestParam MultipartFile[] imgs) throws IOException {
		if(imgs != null && imgs.length > 0) {
			for( MultipartFile one : imgs) {
				obj.setBrd_img(one.getBytes());
			}
		}
		//DAO로 obj값 전달하기
		bDAO.insertBoard(obj);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET) 
	public String list(Model model, HttpSession httpSession,
			@RequestParam(value="page", defaultValue = "1", required = false) int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", page * 10 - 9);
		map.put("end", page * 10);
		httpSession.setAttribute("SESSION_BOARD_HIT_CHECK", 1);
		List<BoardVO> list = bDAO.selectBoard(map);
		int cnt = bDAO.countBoard();
		model.addAttribute("list", list);
		model.addAttribute("cnt", (cnt-1)/10+1);
		return "/board/list";
	}
	
	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
	public String content(@PathVariable long id, Model model, HttpSession httpSession) {
		Integer chk = (Integer)httpSession.getAttribute("SESSION_BOARD_HIT_CHECK");
		if(chk != null) {
			if(chk == 1) {
				bDAO.updateHit(id);
			}
			httpSession.setAttribute("SESSION_BOARD_HIT_CHECK", 0);
		}
		
		BoardVO content = bDAO.selectBoardOne(id);
		model.addAttribute("content", content);
		return "/board/content";
	}
}

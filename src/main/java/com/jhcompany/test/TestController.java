package com.jhcompany.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhcompany.test.dao.IDao;
import com.jhcompany.test.dto.MemberDto;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("join")
	public String joinPage() {
		
		return "join";
	}
	
	@RequestMapping("joinMember") 
	public String joinMember(HttpServletRequest request,Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		dao.memberJoin(mid, mpw, mname, memail);
		
		model.addAttribute("mid", mid);
		return "joinOk";
	}
	@RequestMapping("list")
	public String list(Model model) {
	
		 IDao dao = sqlSession.getMapper(IDao.class);
	      
	     ArrayList<MemberDto> mdto = dao.memberList();
	     model.addAttribute("mlist", mdto);
		
		return "list";
	}
	@RequestMapping("searchId")
	public String searchId() {
	
		return "idSearch";
	}
	@RequestMapping("idOk")
	public String idOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		String searchId = request.getParameter("searchId");
		MemberDto mdto = dao.searchIdOk(searchId);
		
		model.addAttribute("mdto", mdto);
		
		return "idOk";
	}
}

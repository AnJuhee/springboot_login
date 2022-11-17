package com.jhcompany.test.dao;

import java.util.ArrayList;

import com.jhcompany.test.dto.MemberDto;

public interface IDao {
	public void memberJoin(String mid, String mpw, String mname, String memail);
	public ArrayList<MemberDto> memberList();
	public MemberDto searchIdOk(String mid); 
}

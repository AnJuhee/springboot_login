package com.jhcompany.test.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {

	private String mid;
	private String mpw;
	private String mname;
	private String memail;
	private Timestamp mdate;
}
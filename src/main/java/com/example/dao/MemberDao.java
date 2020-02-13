package com.example.dao;

import java.util.List;

import com.example.vo.MemberVO;

public interface MemberDao {
	int create(MemberVO memberVo);
	MemberVO read(String userid);
	List<MemberVO> readAll();
	int update(MemberVO memberVo);
	int delete(String userid);
}

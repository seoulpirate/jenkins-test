package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class MyRowMapper implements RowMapper<MemberVO> {
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO memberVo = new MemberVO(rs.getString("userid"), rs.getString("username"), rs.getInt("userage"),
					rs.getString("gender"), rs.getString("city"));
			return memberVo;
		}
	}

	@Override
	public int create(MemberVO memberVo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Member VALUES(?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, memberVo.getUserid(), memberVo.getUsername(), memberVo.getAge(),
				memberVo.getGender(), memberVo.getCity());
	}

	@Override
	public MemberVO read(String userid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Member WHERE userid = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] { userid }, new MyRowMapper());
	}

	@Override
	public List<MemberVO> readAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Member ORDER BY userid DESC";
		return this.jdbcTemplate.query(sql, new MyRowMapper());
	}

	@Override
	public int update(MemberVO memberVo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Member SET userage = ?, gender = ?, city = ? " + "WHERE userid = ?";
		return this.jdbcTemplate.update(sql, memberVo.getAge(), memberVo.getGender(), memberVo.getCity(),
				memberVo.getUserid());
	}

	@Override
	public int delete(String userid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Member WHERE userid = ?";
		return this.jdbcTemplate.update(sql, userid);
	}

}

package com.example.repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	private static final RowMapper<Member>MEMBER_ROW_MAPPER = (rs,num) ->{
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
	};
	
	private NamedParameterJdbcTemplate template;
	
	public List<Member> searchName(String searchWord){
		String sql = "SELECT id,name,age,dep_id FROM members WHERE name LIKE :searchWord;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("searchWord","%"+ searchWord + "%");
		List<Member>list = template.query(sql, param,MEMBER_ROW_MAPPER);
		return list;
	}

}

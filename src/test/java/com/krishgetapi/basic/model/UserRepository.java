package com.krishgetapi.basic.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
@Autowired
JdbcTemplate jdbc;

  public User findByUsernameAndPassword(String username, String password){
        return jdbc.queryForObject("select * from user_login where username=? and password=?",new BeanPropertyRowMapper<>(User.class),username,password);
    }
}
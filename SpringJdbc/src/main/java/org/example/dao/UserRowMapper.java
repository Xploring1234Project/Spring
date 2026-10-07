package org.example.dao;

import org.example.beans.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            User user = new User();
            user.setUserid(rs.getString("userid"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));

            return user;
        }
    }


package org.example.dao;
import org.example.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
@Repository
public class UserDao {
    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager txManager;

    /*public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/
    //@Transactional
    // Insert
    public int insertUser(User user) {
        String sql = "INSERT INTO user VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql, user.getUserid(), user.getUsername(), user.getEmail());
    }

    // Fetch all
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
            return jdbcTemplate.query(sql, (rs, rowNum) ->
                    new User(
                            rs.getString("userid"),
                            rs.getString("username"),
                            rs.getString("email")
                    ));
        }
       // return jdbcTemplate.query(sql, new UserRowMapper());
    //}

    public int updateUser(User user)
    {
        String sql="update user set username=? ,email=? where userid=?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getEmail(),user.getUserid());
    }
}

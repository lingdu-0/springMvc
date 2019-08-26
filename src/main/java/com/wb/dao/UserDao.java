package com.wb.dao;

import com.wb.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends JdbcDaoSupport {
    public List<User> findAll() {
        return getJdbcTemplate().query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setNumber(rs.getInt("number"));
                return user;
            }
        });
    }
}

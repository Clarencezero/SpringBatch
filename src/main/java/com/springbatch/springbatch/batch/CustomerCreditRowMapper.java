package com.springbatch.springbatch.batch;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCreditRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        People people= new People();
        people.setId(rs.getLong("id"));
        people.setFirstName(rs.getString("firstName"));
        people.setLastName(rs.getString("lastName"));

        System.out.println("数据库获取成功(游标测试): " + people);
        return people;
    }
}

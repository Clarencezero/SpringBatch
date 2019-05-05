package com.springbatch.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PeopleProcess implements ItemProcessor<People, People> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String GET_PEOPLE = "select * from people where id = ?";

    @Override
    public People process(People people) throws Exception {
        System.out.println("第一个流程开始:=================");
        List<People> peopleList = jdbcTemplate.query(GET_PEOPLE, new Object[] {people.getId()}, new RowMapper<People>() {
                    @Override
                    public People mapRow(ResultSet resultSet, int rowNum ) throws SQLException {
                        People p = new People();
                        p.setId( resultSet.getLong( 1 ) );
                        p.setFirstName( resultSet.getString( 2 ) );
                        p.setLastName(resultSet.getString(3));
                        System.out.println("批处理Processor: 获取数据成功: " + p);
                        return p;
                    }
                });


        System.out.println("第一个流程结束:=================");


        return people;
    }
}

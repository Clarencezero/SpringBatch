package com.springbatch.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PeopleFilterProcessor implements ItemProcessor<People, People> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public People process(People people) throws Exception {
        System.out.println("第二个流程开始:=================");
        System.out.println("当前处理人员: " + people);

        jdbcTemplate.update("UPDATE PEOPLE SET lastName = '" + people.getLastName() + "' where id = " + people.getId());


        System.out.println("第二个流程结束:=================");
//        throw new NullPointerException("第二个流程发生异常");
        return people;
    }
}
package com.springbatch.springbatch.batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class PeopleWriter implements ItemWriter<People> {
    @Override
    public void write(List<? extends People> list) throws Exception {
        System.out.println("批处理写入开始:=======================");
        for (People people : list) {
            System.out.println("批处理 Writer: " + people);
        }
        System.out.println("批处理写入结束:=======================");

    }
}

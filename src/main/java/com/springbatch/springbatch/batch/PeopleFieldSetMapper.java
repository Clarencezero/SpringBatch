package com.springbatch.springbatch.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PeopleFieldSetMapper implements FieldSetMapper<People> {
    @Override
    public People mapFieldSet(FieldSet fieldSet) throws BindException {
        System.out.println("批处理转换开始:=================");
        People people = new People();
        people.setId(fieldSet.readLong("id"));
        people.setFirstName(fieldSet.readString("firstName"));
        people.setLastName(fieldSet.readString("lastName"));
        System.out.println("批处理转换结束:=================");
        return people;
    }
}

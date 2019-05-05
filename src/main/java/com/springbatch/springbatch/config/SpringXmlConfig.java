package com.springbatch.springbatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:PeopleJobConfig.xml"})
public class SpringXmlConfig {
}

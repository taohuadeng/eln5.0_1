package com.thd.app.uc.service;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:/spring-config/spring-servlet.xml",
        "classpath:/spring-config/spring-context.xml"})
public class BaseWebTests extends AbstractTransactionalJUnit4SpringContextTests {
}

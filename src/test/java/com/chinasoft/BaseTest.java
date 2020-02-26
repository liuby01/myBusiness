package com.chinasoft;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test配置文件
 * 
 * @author 刘炳炎
 */

//Spring和Junit整合
@RunWith(SpringJUnit4ClassRunner.class)

//Spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })

public class BaseTest {

}

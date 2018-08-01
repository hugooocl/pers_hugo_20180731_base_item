package service.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Base;
import service.BaseService;

import java.util.List;

public class BaseServiceTest {
    private static ApplicationContext context;
    @BeforeClass
    public static void init() {
        context=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void testAddBase() throws Exception {
        Base base1 = new Base("hugoBase");
        BaseService manager=context.getBean(BaseService.class);
        Base base2 =  manager.addBase(base1);
        System.out.println(base2.toString());
        Assert.assertTrue(base2.getId()!=null);
    }

    @Test
    public void testFindBase() throws Exception {
        BaseService manager=context.getBean(BaseService.class);
        List<Base> baseList = manager.findAllBase();
       for (Base b :baseList){
           System.out.println(b.toString());
       }
    }
}

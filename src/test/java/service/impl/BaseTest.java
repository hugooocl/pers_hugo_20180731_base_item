package service.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Base;
import pojo.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BaseTest {

    private static EntityManagerFactory factory;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("customers");//持久化单元//datasource
    }

    @AfterClass
    public static void destory() {
        factory.close();
    }

    @Test
    public void testAdd() throws Exception {

        EntityManager em = factory.createEntityManager();//Connection

        Base base1 = new Base("base1");
        Item item1 = new Item("item1",1);
        Item item2 = new Item("item2",2);
        item1.setBase(base1);
        item2.setBase(base1);
        base1.getItems().add(item1);
        base1.getItems().add(item2);
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        em.persist(base1);
        System.out.println(base1.toString());
        tx.commit();
        em.close();
    }


}

package com.oracle.service;

import com.oracle.model.Product;
import com.oracle.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddDemo {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.openSession(); //生成一个session
        session.beginTransaction(); //开启事务

        Product product = new Product();
        product.setName("键鼠套装2");
        product.setPrice(56.00);
        product.setNum(20);
        session.save(product); //观察控制台的输出

        session.getTransaction().commit(); //提交事务
        session.close(); //关闭session
        sessionFactory.close();
    }
}

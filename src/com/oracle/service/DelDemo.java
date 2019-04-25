package com.oracle.service;

import com.oracle.model.Product;
import com.oracle.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DelDemo {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.openSession(); //生成一个session
        session.beginTransaction(); //开启事务

        Product product = (Product) session.get(Product.class, Integer.valueOf(1));
        session.delete(product); //删除

        session.getTransaction().commit(); //提交事务
        session.close(); //关闭session
        sessionFactory.close();
    }
}

package com.oracle.service;

import com.oracle.model.Product;
import com.oracle.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ModifyDemo {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.openSession(); //生成一个session
        session.beginTransaction(); //开启事务

        Product product = (Product) session.get(Product.class, Integer.valueOf(1));
        product.setName("机械键盘");
        product.setPrice(34.5);
        product.setNum(109);
        session.save(product);

        session.getTransaction().commit(); //提交事务
        session.close(); //关闭session
        sessionFactory.close();
    }
}

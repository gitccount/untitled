package com.oracle.service;

import com.oracle.model.Product;
import com.oracle.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FindDemo {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.openSession(); //生成一个session
        session.beginTransaction(); //开启事务

        String hql = "from Product";
        Query query = session.createQuery(hql);
        @SuppressWarnings("unchecked") //压制警告
                List<Product> productList = query.list();
        for (Product product : productList) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + product.getNum());
        }
        session.getTransaction().commit(); //提交事务
        session.close(); //关闭session
        sessionFactory.close();
    }
}

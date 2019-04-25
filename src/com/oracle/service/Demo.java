package com.oracle.service;

import com.oracle.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Demo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure(); //实例化配置文件
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); //实例化服务登记
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry); //获取Session工厂
        Session session = sessionFactory.openSession(); //生成一个session
        session.beginTransaction(); //开启事务
        // 先运行程序，生产数据库表

        Product product = new Product();
        product.setName("键鼠套装");
        product.setPrice(56.98);
        product.setNum(20);
        session.save(product); //观察控制台的输出

        session.getTransaction().commit(); //提交事务
        session.close(); //关闭session
        sessionFactory.close(); //关闭session工厂
    }
}

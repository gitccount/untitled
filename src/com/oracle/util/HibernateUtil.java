package com.oracle.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    //声明SessionFactory对象,将其实例化放在static静态代码块中,保证其在一开始就完成初始化
    private static SessionFactory sessionFactory = null;
//    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
//        Configuration configuration = new Configuration().configure(); //实例化配置文件
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
        //1. 创建Hibernate配置对象
        //2. 加载配置文件:hibernate.cfg.xml,默认加载src目录下的hibernate.cfg.xml
        //3. 实例化SessionFactory对象

        sessionFactory = new Configuration().configure().buildSessionFactory();
        //4. 关闭虚拟机时,释放SessionFactory
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("虚拟机关闭,释放SessionFactory资源");
                sessionFactory.close();
            }
        }));
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (null != sessionFactory) {
            return sessionFactory;
        } else {
            return buildSessionFactory();
        }
    }

    //提供获取Session对象的方法
    public static Session openSession() {
        if (null != sessionFactory) {
            return sessionFactory.openSession();
        } else {
            return buildSessionFactory().openSession();
        }
    }

    //获得当前线程中的绑定的Session
    //注意：必须配置
    //return
    public static Session getCurrentSession() {
        if (null != sessionFactory) {
            return sessionFactory.getCurrentSession();
        } else {
            return buildSessionFactory().getCurrentSession();
        }
    }
}
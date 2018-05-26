package com.chenmo.listener;

import com.chenmo.utils.SqlSessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitSqlSessionListener  implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("service start");
        //初始化sqlSessionFactory对象
        SqlSessionFactoryUtils.initSqlSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("service destory");
        SqlSessionFactoryUtils.close();
    }
}

package org.example.overview.database;


import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void testMybatis() {
        try (
                SqlSession session = sqlSessionFactory.openSession();
                Connection connection = session.getConnection();
        ) {

            Assertions.assertNotNull(connection);
            System.out.println("session = " + session);
            System.out.println("connection = " + connection);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

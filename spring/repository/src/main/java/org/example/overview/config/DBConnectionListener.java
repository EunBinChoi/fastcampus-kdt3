package org.example.overview.config;

import org.example.overview.database.ConnectionPoolMgr;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConnectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPoolMgr connectionPoolMgr = ConnectionPoolMgr.getInstance();
        while (connectionPoolMgr == null) {
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPoolMgr connectionPoolMgr = ConnectionPoolMgr.getInstance();
        connectionPoolMgr.releaseFreeConnections();

    }
}

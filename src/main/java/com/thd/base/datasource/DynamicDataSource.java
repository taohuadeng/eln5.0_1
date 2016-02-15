package com.thd.base.datasource;

import com.google.gson.Gson;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Log LOG = LogFactory.getLog(DynamicDataSource.class);
    private Map<Object, Object> _targetDataSources;

    public static void main(String[] args) {
        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><sms><mt><status>0</status><msgid>8c988a40ed1a4a469ff12474e40ee439</msgid></mt></sms>";
        String substring = a.substring(55, 56);
        System.out.println(substring);
    }


    @Override
    protected Object determineCurrentLookupKey() {
//        if (true) {//启动服务时没有线程变量
//            return null;
//        }

        String dataSourceUrl = "{\"password\":\"thd123\",\"userName\":\"postgres\",\"driverClassName\":\"org.postgresql.Driver\",\"url\":\"jdbc:postgresql://localhost:5432/eln5.0\"}";
        Gson gson = new Gson();
        DataSourceCoordinate coordinate = gson.fromJson(dataSourceUrl, DataSourceCoordinate.class);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(coordinate.getDriverClassName());
        dataSource.setUrl(coordinate.getUrl());
        dataSource.setUsername(coordinate.getUserName());
        dataSource.setPassword(coordinate.getPassword());
        dataSource.setTestWhileIdle(true);
        if (this._targetDataSources == null) {
            this._targetDataSources = new HashMap<Object, Object>();
        }

        this._targetDataSources.put("init", dataSource);
        super.setTargetDataSources(this._targetDataSources);
        afterPropertiesSet();
        return "init";
    }
}
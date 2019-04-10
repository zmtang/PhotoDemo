package com.example.photodemo.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author zmt
 * @date 2019-03-18 11:41
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourse();
    }

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    /**
     * 最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。
     * https://www.cnblogs.com/dolphin0520/p/3920407.html
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER= new ThreadLocal<>();

    public static void setDataSourse(String dataSourse){
        CONTEXT_HOLDER.set(dataSourse);
    }

    public static String getDataSourse(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourse(){
        CONTEXT_HOLDER.remove();
    }

}

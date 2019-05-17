package com.example.photodemo.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author zmt
 * @date 2019-03-18 11:41
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 最常见的 ThreadLocal 使用场景为 用来解决 数据库连接、Session管理等。
     * ThreadLocal用于保存某个线程共享变量：对于同一个static ThreadLocal，不同线程只能从中get，set，remove自己的变量，而不会影响其他线程的变量。
     * https://www.cnblogs.com/dolphin0520/p/3920407.html
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    public static String getDataSourse() {
        // get()方法是用来获取ThreadLocal在当前线程中保存的变量副本
        return CONTEXT_HOLDER.get();
    }

    /**
     * 将数据源存入线程 ThreadLocal
     * @param dataSourse
     */
    public static void setDataSourse(String dataSourse) {
        CONTEXT_HOLDER.set(dataSourse);
    }

    public static void clearDataSourse() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 根据Key获取数据源的信息，上层抽象函数的钩子
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourse();
    }

}

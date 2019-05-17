package com.example.photodemo.util;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Spring表达式语言：SpEL语法
 *
 * @author zmt
 * @date 2019-05-09 17:24
 */
public class SpelParser {
    // 创建一个ExpressionParser对象，用于解析表达式
    private static ExpressionParser parser = new SpelExpressionParser();

    /**
     * Spring表达式语言简称：SpEL，SpEL既可以独立于Spring容器使用，，也可以在Spring配置文件中使用，这样就大大简化了Spring的Bean配置，给配置文件起到了“减肥”的作用
     * @param key el表达式字符串，占位符以#开头
     * @param paramsNames 形参名称，可以理解为占位符的名称
     * @param args 参数值 也可理解为占位符的值
     * @return 返回el表达式经过参数替换后的字符串
     */
    public static String getKey(String key,String[] paramsNames, Object[] args){
        Expression exp = parser.parseExpression(key);// 将key字符串解析为el表达式
        StandardEvaluationContext context = new StandardEvaluationContext();// 初始化赋值上下文
        if (args.length<=0) {
            return null;
        }
        // 将形参和形参值以配对的方式配置到复制的上下文中
        for (int i = 0; i <args.length ; i++) {
            context.setVariable(paramsNames[i],args[i]);
        }
        // 根据复制上下值运算el表达式
        return exp.getValue(context,String.class);
    }
}

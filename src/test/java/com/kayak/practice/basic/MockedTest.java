package com.kayak.practice.basic;


import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpSession;
import java.util.Locale;


/**
 * @Mocked修饰的类/接口，是告诉JMockit，帮我生成一个Mocked对象，这个对象方法（包含静态方法)返回默认值。
 * 即如果返回类型为原始类型(short, int, float, double, long)就返回0，如果返回类型为String就返回null，
 * 如果返回类型是其它引用类型，则返回这个引用类型的Mocked对象（这一点，是个递归的定义，需要好好理解一下）
 */
//@Mocked注解用途
public class MockedTest {

    // 加上了JMockit的API @Mocked, JMockit会帮我们实例化这个对象，不用担心它为null
    @Mocked
    Locale locale;

    // 当@Mocked作用于class
    @Test
    public void testMockedClass() {
        // 静态方法不起作用了,返回了null
        Assert.assertTrue(Locale.getDefault() == null);
        // 非静态方法（返回类型为String）也不起作用了，返回了null
        Assert.assertTrue(locale.getCountry() == null);
        // 自已new一个，也同样如此，方法都被mock了
        Locale chinaLocale = new Locale("zh", "CN");
        Assert.assertTrue(chinaLocale.getCountry() == null);
    }


    // 加上了JMockit的API @Mocked, JMockit会帮我们实例化这个对象，尽管这个对象的类型是一个接口，不用担心它为null
    @Mocked
    HttpSession session;

    // 当@Mocked作用于interface
    @Test
    public void testMockedInterface() {
        // （返回类型为String）也不起作用了，返回了null
        Assert.assertTrue(session.getId() == null);
        // （返回类型为原始类型）也不起作用了，返回了0
        Assert.assertTrue(session.getCreationTime() == 0L);
        // (返回类型为原非始类型，非String，返回的对象不为空，这个对象也是JMockit帮你实例化的，同样这个实例化的对象也是一个Mocked对象)
        Assert.assertTrue(session.getServletContext() != null);
        // Mocked对象返回的Mocked对象，（返回类型为String）的方法也不起作用了，返回了null
        Assert.assertTrue(session.getServletContext().getContextPath() == null);
    }

}

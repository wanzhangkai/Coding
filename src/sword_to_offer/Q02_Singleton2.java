package sword_to_offer;

/**
 * 饿汉模式加载慢，但运行时获取对象快，线程安全；
 * 懒汉模式加载快，但运行获取对象慢，线程不安全
 * （可以加synchronized保证线程安全）。
 */

/**
 * 单例饿汉模式
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/4 13:28
 */
public class Q02_Singleton2 {

    //他懒得提前new对象
    private static Q02_Singleton2 instance = null;

    //他也不允许外部new对象
    private Q02_Singleton2() {
    }

    //加了synchronized来同步，来保证线程安全
    public synchronized static Q02_Singleton2 getInstance() {
        if (instance == null) {
            //他很懒，如果实例为空他才new一个
            instance = new Q02_Singleton2();
        }
        return instance;
    }

}

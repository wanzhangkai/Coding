package sword_to_offer;

/**
 * 单例饿汉模式
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/4 13:28
 */
public class Q2_Singleton2 {

    //他懒得提前new对象
    private static Q2_Singleton2 instance = null;

    //他也不允许外部new对象
    private Q2_Singleton2() {
    }

    //加了synchronized来同步
    public synchronized static Q2_Singleton2 getInstance() {
        if (instance == null) {
            //他很懒，如果实例为空他才new一个
            instance = new Q2_Singleton2();
        }
        return instance;
    }

}
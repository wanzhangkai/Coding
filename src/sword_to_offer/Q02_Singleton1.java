package sword_to_offer;

/**
 * 《剑指Offer面试题》
 * 单例饿汉模式
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/4 13:16
 */
public class Q02_Singleton1 {

    //他很“饥饿”所以提前new好了对象,而且是静态不可更改的对象
    private static final Q02_Singleton1 instance = new Q02_Singleton1();

    //私有构造函数，不让外部建对象
    private Q02_Singleton1() {
    }

    //通过类调用的静态get方法
    private static Q02_Singleton1 getInstance() {
        return instance;
    }

}


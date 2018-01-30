package interview.designpattern.company;

 /**
  * 设计模式---state模式
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/30 22:07
 */
public interface Role {
    //Role接口：将Engineer与Manager从派生关系改成了组合关系，
    //通过改变Role来改变他们的工作方式。
    void doWork();
}
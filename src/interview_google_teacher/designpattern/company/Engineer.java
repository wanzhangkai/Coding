package interview_google_teacher.designpattern.company;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/30 22:17
 */
public class Engineer implements Role {

    @Override
    public void doWork() {
        System.out.println("doing engineer work");
    }

    @Override
    public String toString() {
        return "Engineer";
    }
}
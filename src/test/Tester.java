package test;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/12 19:21
 */
public enum Tester {

    SUCCESS(0, "SUCCESS"),
    ERROR(0, "ERROR");
     final int code;
     final String desc;

    Tester(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(Tester.ERROR.desc);
    }

}
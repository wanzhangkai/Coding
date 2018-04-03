package exam_program.tcl;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/3 19:58
 */
public class Tester1 {
    static class People {
        String name;

        public People() {
            System.out.print(1);
        }

        public People(String name) {
            System.out.print(2);
            this.name = name;
        }
    }

    static class Child extends People {
        People father;

        public Child(String name) {
            System.out.print(3);
            this.name = name;
            father = new People(name + "F");
        }

        public Child() {
            System.out.print(4);
        }
    }

    public static void main(String[] args) {
//        People p = new Child("mike");
//        System.out.println();
//        Child p1 = new Child("mike");

        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1.equals(str1));



    }
}
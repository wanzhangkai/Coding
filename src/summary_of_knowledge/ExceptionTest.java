package summary_of_knowledge;

/**
 * 异常举例
 *    --《Java编程思想》
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/1 23:12
 */
class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

class Human {

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}
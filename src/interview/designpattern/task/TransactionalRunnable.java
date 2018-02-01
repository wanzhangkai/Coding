package interview.designpattern.task;

/**
 * 设计模式-Decorator模式
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/1 22:23
 */
public  class TransactionalRunnable implements Runnable {

   private final Runnable innerRunnable;

    public TransactionalRunnable(Runnable innerRunnable) {
        this.innerRunnable = innerRunnable;
    }

    @Override
    public void run() {
        boolean shouldRollback = false;
        try {
            beginTransaction();
            innerRunnable.run();
        } catch (Exception e) {
            shouldRollback = true;
            throw e;
        } finally {
            if (shouldRollback) {
                rollBack();
            } else {
                commit();
            }
        }
    }

    private void beginTransaction() {
        System.out.println("beginTransaction");
    }

    private void rollBack() {
        System.out.println("rollback");
    }

    private void commit() {
        System.out.println("commit");
    }


}
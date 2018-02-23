package multithreading.thread_demo3_racecondition;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/23 22:03
 */
public class EnergyTransferTask implements Runnable {

    //共享的能量世界
    private EnergySystem energySystem;
    //能量转移的源能量盒子下标
    private int fromBox;
    //单次能量转移最大单元
    private double maxAmount;
    //最大休眠时间（毫秒）
    private int DELAY = 10;

    public EnergyTransferTask(EnergySystem energySystem, int from, double max) {
        this.energySystem = energySystem;
        this.fromBox = from;
        this.maxAmount = max;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toBox = (int) (energySystem.getBoxAmount() * Math.random()); //转移到，某个随机单元
                double amount = maxAmount * Math.random();  //随机取一个能量值
                energySystem.transfer(fromBox, toBox, amount);
                Thread.sleep((int) (DELAY * Math.random()));    //延迟
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
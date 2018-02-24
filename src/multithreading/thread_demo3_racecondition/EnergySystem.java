package multithreading.thread_demo3_racecondition;

/**
 * “能量转移多线程系统”
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/23 21:47
 */
public class EnergySystem {

    //能量盒子，能量存贮的地方
    private final double[] energyBoxes;
    private final Object lockObj = new Object();

    /**
     * @param n             能量盒子的数量
     * @param initialEnergy 每个能量盒子初始含有的能量值
     */
    public EnergySystem(int n, double initialEnergy) {
        energyBoxes = new double[n];
        for (int i = 0; i < energyBoxes.length; i++) {
            energyBoxes[i] = initialEnergy;
        }
    }

    /**
     * 能量的转移，从一个盒子到另一个盒子
     *
     * @param from   能量源
     * @param to     能量终点
     * @param amount 能量值
     */
    public void transfer(int from, int to, double amount) {

        //这里这个lockObj并没有做特殊处理
        synchronized (lockObj) {
            while (energyBoxes[from] < amount) {
                try {
                    lockObj.wait(); //条件不满足时, 将当前线程放入Wait Set
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(Thread.currentThread().getName());
            energyBoxes[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            energyBoxes[to] += amount;
            System.out.printf(" 能量总和：%10.2f%n", getTotalEnergies());
            lockObj.notifyAll();
        }
    }

    /**
     * 获取能量世界的能量总和
     */
    public double getTotalEnergies() {
        double sum = 0;
        for (double amount : energyBoxes)
            sum += amount;
        return sum;
    }

    /**
     * 返回能量盒子的长度
     */
    public int getBoxAmount() {
        return energyBoxes.length;
    }

    public static void main(String[] args) {
        //将要构建的能量世界中能量盒子数量
        int BOX_AMOUNT = 10;
        //每个盒子初始能量
        double INITIAL_ENERGY = 1000;
        EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
            Thread t = new Thread(task, "TransferThread_" + i);
            t.start();
        }
    }

}
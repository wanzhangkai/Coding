package fun;

import javax.swing.*;
import java.awt.*;

/**
 * Java swing实现心形
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 14:55
 */

@SuppressWarnings("serial")
class Cardioid extends JFrame {
    // 定义窗口大小
    private static final int WIDTH = 600;
    private static final int HEIGHT = 550;

    // 获取屏幕大小
    private static int WINDOW_WIDTH = Toolkit.getDefaultToolkit()
            .getScreenSize().width;
    private static int WINDOW_HEIGHT = Toolkit.getDefaultToolkit()
            .getScreenSize().height;

    // 构造函数
    public Cardioid() {
        // 设置窗口标题
        super("❤形线");
        // 设置背景色
//        this.setBackground(Color.black);
        // 设置窗口位置
        this.setLocation((WINDOW_WIDTH - WIDTH) / 2,
                (WINDOW_HEIGHT - HEIGHT) / 2);
        // 设置窗口大小
        this.setSize(WIDTH, HEIGHT);
        // 设置窗口布局
        this.setLayout(getLayout());
        // 设置窗口可见
        this.setVisible(true);
        // 设置窗口默认关闭方式
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void paint1(Graphics page) {
        double x, y, t;
        page.drawString("I love you !", 275, 60);

        for (y = 2; y >= -2; y -= 0.005)
            for (x = -200; x <= 200; x += 0.005) {
                t = x * x + y * y - 1;
                if (t * t * t + x * x * y * y * y <= 0)
                    page.drawOval((int) (x * 200 + 300), (int) (y * 200 + 300), 0, 0);
            }

    }


    public void paint(Graphics g) {

        double x, y, r; // 横纵坐标及半径
        Image image = this.createImage(WIDTH, HEIGHT);
        Graphics pic = image.getGraphics();

        // 绘制图形
        double t;
        for (y = 2; y >= -2; y -= 0.005)
            for (x = -200; x <= 200; x += 0.005) {
                t = x * x + y * y - 1;
                if (t * t * t + x * x * y * y * y <= 0)
                    pic.drawOval((int) (x * 200 + 300), (int) (y * 200 + 300), 0, 0);
                pic.setColor(Color.MAGENTA);
            }

        // 生成图片
        g.drawImage(image, 0, 0, this);
    }


    public void paint3(Graphics g) {

        double x, y, r; // 横纵坐标及半径
        Image image = this.createImage(WIDTH, HEIGHT);
        Graphics pic = image.getGraphics();

        // 绘制图形
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                r = Math.PI / 45 + Math.PI / 45 * i
                        * (1 - Math.sin(Math.PI / 45 * j)) * 18;

                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i)
                        + WIDTH / 2;

                y = -r * Math.sin(Math.PI / 45 * j) + HEIGHT / 2;

                pic.setColor(Color.MAGENTA);
                pic.fillOval((int) x, (int) y, 2, 2);
            }
            // 生成图片
            g.drawImage(image, 0, 0, this);

        }

    }

    public static void main(String[] args) {

        new Cardioid();

    }

}
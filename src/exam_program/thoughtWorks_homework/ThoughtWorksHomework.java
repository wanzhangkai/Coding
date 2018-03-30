package exam_program.thoughtWorks_homework;

import java.util.ArrayList;
import java.util.List;

/**
 * ThoughtWorks春招作业：
 * 无人机的飞行日志
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/14 16:31
 */
public class ThoughtWorksHomework {

    //消息类，用来存放无人机的日志消息
    static class Message {
        String planeName;
        int X;
        int Y;
        int Z;
        int offsetX;
        int offsetY;
        int offsetZ;
        //无人机状态，true表示正常，false表示故障。
        private boolean status = false;

        //初始构造函数
        public Message(String planeName,
                       int X, int Y, int Z) {
            this.planeName = planeName;
            this.X = X;
            this.Y = Y;
            this.Z = Z;
            this.offsetX = 0;
            this.offsetY = 0;
            this.offsetZ = 0;
        }

        //构造函数二
        public Message(String planeName,
                       int X, int Y, int Z,
                       int offsetX, int offsetY, int offsetZ) {
            this.planeName = planeName;
            this.X = X;
            this.Y = Y;
            this.Z = Z;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.offsetZ = offsetZ;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    //判断无人机当前状态
    public static List<Message> lightLog(List<Message> MessageList) {
        if (MessageList.get(0).offsetX != 0 && MessageList.get(0).offsetY != 0 && MessageList.get(0).offsetZ != 0) {
            return null;
        }
        MessageList.get(0).setStatus(true);
        int temX, temY, temZ;
        //边界条件控制 i < size()-1;
        for (int i = 0; i < MessageList.size() - 1; i++) {
            //判断格式,格式不对跳出循环，后面的默认故障
            if (MessageList.get(i + 1).offsetX == 0 && MessageList.get(i + 1).offsetY == 0 && MessageList.get(i + 1).offsetZ == 0) {
                break;
            }
            //判断坐标计算是否匹配，匹配则设为true（正常）。
            temX = MessageList.get(i).X + MessageList.get(i).offsetX;
            temY = MessageList.get(i).Y + MessageList.get(i).offsetY;
            temZ = MessageList.get(i).Z + MessageList.get(i).offsetZ;
            if (temX == MessageList.get(i + 1).X && temY == MessageList.get(i + 1).Y && temZ == MessageList.get(i + 1).Z) {
                MessageList.get(i + 1).setStatus(true);
            }
        }
        return MessageList;
    }

    //响应指定序号来输出结果
    public static void printLightLog(int orderNum) {
        List<Message> messages = lightLog(importMessageTest());
        //指定消息ID大于实际消息序列数量
        if (orderNum >= messages.size()) {
            System.out.println("Cannot find " + orderNum);
            return;
        }
        int temX, temY, temZ;
        if (messages.get(orderNum).getStatus()) {
            temX = messages.get(orderNum).X + messages.get(orderNum).offsetX;
            temY = messages.get(orderNum).Y + messages.get(orderNum).offsetY;
            temZ = messages.get(orderNum).Z + messages.get(orderNum).offsetZ;
            System.out.println(
                    messages.get(orderNum).planeName + " "
                            + orderNum + " " + temX + " "
                            + temY + " " + temZ + " ");
        } else {
            System.out.println("Error: " + orderNum);
        }
    }

    //消息的输入样例,装入List容器
    public static List<Message> importMessageTest() {
        Message message0 = new Message("plane1", 1, 1, 1);
        Message message1 = new Message("plane1", 1, 1, 1, 1, 2, 3);
        Message message2 = new Message("plane1", 2, 3, 4, 1, 1, 1);
        Message message3 = new Message("plane1", 3, 4, 5);
        Message message4 = new Message("plane1", 1, 1, 1, 1, 2, 3);

        List<Message> list = new ArrayList<>();
        list.add(message0);
        list.add(message1);
        list.add(message2);
        list.add(message3);
        list.add(message4);
        return list;
    }

    //测试结果
    public static void main(String[] args) {
        printLightLog(2);
        printLightLog(4);
        printLightLog(100);
    }

}
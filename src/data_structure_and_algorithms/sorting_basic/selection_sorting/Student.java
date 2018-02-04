package data_structure_and_algorithms.sorting_basic.selection_sorting;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/4 22:17
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 重写Student的compareTo函数
    // 如果分数相等，则按照名字的字母序排序
    // 如果分数不等，则分数高的靠前

    @Override
    public int compareTo(Student o) {
        if (this.score < o.score) {
            return -1;
        } else if (this.score > o.score) {
            return 1;
        } else {
            return this.name.compareTo(o.name);
        }
    }

    //重写Student的打印样式
    @Override
    public String toString() {
        return "Student: " + this.name + " " + Integer.toString(this.score);
    }
}
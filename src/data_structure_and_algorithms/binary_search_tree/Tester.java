package data_structure_and_algorithms.binary_search_tree;

import java.util.Vector;

/**
 * @author bobo
 * @date 2018/2/19 22:53
 */

public class Tester {

    // 测试二分搜索树和顺序查找表之间的性能差距
    // 二分搜索树的性能远远优于顺序查找表
    private static void test1() {
        // 使用圣经作为我们的测试用例
        String filename = "bible.txt";
        Vector<String> words = new Vector<String>();
        if (FileOperations.readFile(filename, words)) {
            System.out.println("There are totally " + words.size() + " words in " + filename);
            System.out.println();

            // 测试 BSTree
            long startTime = System.currentTimeMillis();

            // 统计圣经中所有词的词频
            // 注: 这个词频统计法相对简陋, 没有考虑很多文本处理中的特殊问题
            // 在这里只做性能测试用
            BSTree<String, Integer> bst = new BSTree<String, Integer>();
            for (String word : words) {
                Integer res = bst.search(word);
                if (res == null)
                    bst.insert(word, new Integer(1));
                else
                    bst.insert(word, res + 1);
            }

            // 输出圣经中god一词出现的频率
            if (bst.contain("god"))
                System.out.println("'god' : " + bst.search("god"));
            else
                System.out.println("No word 'god' in " + filename);

            long endTime = System.currentTimeMillis();
            System.out.println("BSTree , time: " + (endTime - startTime) + "ms.");

            System.out.println();


            // 测试顺序查找表 SST
            startTime = System.currentTimeMillis();

            // 统计圣经中所有词的词频
            // 注: 这个词频统计法相对简陋, 没有考虑很多文本处理中的特殊问题
            // 在这里只做性能测试用
            SST<String, Integer> sst = new SST<String, Integer>();
            for (String word : words) {
                Integer res = sst.search(word);
                if (res == null)
                    sst.insert(word, new Integer(1));
                else
                    sst.insert(word, res + 1);
            }

            // 输出圣经中god一词出现的频率
            if (sst.contain("god"))
                System.out.println("'god' : " + sst.search("god"));
            else
                System.out.println("No word 'god' in " + filename);

            endTime = System.currentTimeMillis();
            System.out.println("SST , time: " + (endTime - startTime) + "ms.");

        }
    }

    // 测试二分搜索树的前中后序遍历以及层序遍历
    private static void test2() {

        BSTree<Integer, Integer> bst = new BSTree<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int) (Math.random() * M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

        // 测试二分搜索树的层序遍历 levelOrder
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();
    }

    // 测试二分搜索树中的removeMin和removeMax
    private static void test3() {
        BSTree<Integer, Integer> bst = new BSTree<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 100;
        int M = 1000;
        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int) (Math.random() * M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // 测试 removeMin
        // 输出的元素应该是从小到大排列的
        System.out.println("Test removeMin: ");
        while (!bst.isEmpty()) {
            System.out.print("min: " + bst.minimum() + " , ");
            bst.removeMin();
            System.out.println("After removeMin, size = " + bst.size());
        }
        System.out.println();


        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int) (Math.random() * M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // 测试 removeMax
        // 输出的元素应该是从大到小排列的
        System.out.println("Test removeMax: ");
        while (!bst.isEmpty()) {
            System.out.print("max: " + bst.maximum() + " , ");
            bst.removeMax();
            System.out.println("After removeMax, size = " + bst.size());
        }
    }

    // 打乱数组顺序
    private static void shuffle(Object[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    // 测试二分搜索树中的remove
    private static void test4() {
        BSTree<Integer, Integer> bst = new BSTree<>();

        // 取n个取值范围在[0...n)的随机整数放进二分搜索树中
        int N = 100;
        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int) (Math.random() * N));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer order[] = new Integer[N];
        for (int i = 0; i < N; i++)
            order[i] = new Integer(i);
        // 打乱order数组的顺序
        shuffle(order);

        // 乱序删除[0...n)范围里的所有元素
        for (int i = 0; i < N; i++)
            if (bst.contain(order[i])) {
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + " size = " + bst.size());
            }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.size());
    }

    public static void main(String[] args) {
//        Tester.test1();
//        Tester.test2();
//        Tester.test3();
        Tester.test4();

    }
}


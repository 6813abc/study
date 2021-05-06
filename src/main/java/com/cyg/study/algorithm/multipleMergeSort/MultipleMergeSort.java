package com.cyg.study.algorithm.multipleMergeSort;


import java.io.*;
import java.util.*;

/**
 * @author cyg
 * @date 2021/4/26 16:10
 **/
public class MultipleMergeSort {

    public static void main(String[] args) throws IOException {
        //生成一个文件
        randomMaxFile(100);
        //切分小文件,并排序
        int fileNum = splitData(10);
        //创建队列
        List<Queue<Integer>> queues = createQueue(fileNum);
        //初始化队列
        initQueue(queues, 5);
        //初始化有序map
        Map<Integer, Integer> map = initTransitMap(queues);
        System.out.println(map);
    }

    /**
     * 随机写入数据到文件
     *
     * @param len 总数据量
     **/
    private static void randomMaxFile(int len) throws IOException {
        File maxFile = new File("D:\\javahome\\file\\max.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(maxFile));
        if (maxFile.exists()) {
            maxFile.delete();
        }
        maxFile.createNewFile();
        Random ran = new Random();
        for (int i = 0; i < len; i++) {
            int m = ran.nextInt(8) + 1;
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < m; j++) {
                int n;
                if (j == m - 1) {
                    n = ran.nextInt(9);
                } else {
                    n = ran.nextInt(8) + 1;
                }
                s.append(n);
            }
            //System.out.println(s);
            writer.write(s.toString());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    /**
     * 切分小文件
     *
     * @param dataNum 每个文件的数据量
     **/
    private static int splitData(int dataNum) throws IOException {
        File maxFile = new File("D:\\javahome\\file\\max.txt");
        InputStream inputStream = new FileInputStream(maxFile);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String tempString;
        List<List<Integer>> lists = new ArrayList<>();
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while ((tempString = in.readLine()) != null) {
            num++;
            list.add(Integer.parseInt(tempString));
            if (num % dataNum == 0) {
                Collections.sort(list);
                if (list.size() > 0) {
                    lists.add(list);
                }
                list = new ArrayList<>();
            }
        }
        if (list.size() > 0) {
            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            File file = new File("D:\\javahome\\file\\" + (i + 1) + ".txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            List<Integer> integers = lists.get(i);
            for (Integer s : integers) {
                //System.out.println(s);
                writer.write(s.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }
        return lists.size();
    }

    private static List<Queue<Integer>> createQueue(int fileNum) {
        List<Queue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i < fileNum; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queues.add(queue);
        }
        return queues;
    }

    /**
     * 初始化队列
     *
     * @param num 每次入队数据
     **/
    private static void initQueue(List<Queue<Integer>> queues, int num) throws IOException {
        for (int i = 0; i < queues.size(); i++) {
            addQueue(queues.get(i), i, 0, num);
        }
    }

    /**
     * 数据进入队列
     *
     * @param queue    队列
     * @param filePage 第几个文件
     * @param num      每次读取的个数
     * @param start    文件起始位置
     **/
    private static void addQueue(Queue<Integer> queue, int filePage, int start, int num) throws IOException {
        File file = new File("D:\\javahome\\file\\" + (filePage + 1) + ".txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String tempString;
        int i = 0;
        while ((tempString = in.readLine()) != null) {
            if (i >= start && i < (start + num)) {
                queue.offer(Integer.parseInt(tempString));
            }
            i++;
        }
    }

    /****/
    private static Map<Integer, Integer> initTransitMap(List<Queue<Integer>> queues) {
        Map<Integer, Integer> map = new TreeMap<>(Integer::compareTo);
        for (int i = 0; i < queues.size(); i++) {
            map.put(i, queues.get(i).poll());
        }
        return map;
    }
}
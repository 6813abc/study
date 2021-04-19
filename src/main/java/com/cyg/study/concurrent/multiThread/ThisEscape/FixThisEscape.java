package com.cyg.study.concurrent.multiThread.ThisEscape;

/**
 * @author cyg
 * @date 2021/4/19 10:08
 **/
public class FixThisEscape {

    private String value = "";
    private Thread thd;

    public FixThisEscape() {
        /** * 构造函数中可以创建Thread对象，但是不要启动，另外使用start方法启动线程 */
        thd = new Thread(new TestDemo());
        this.value = "fix this escape";
    }

    public void start() {
        thd.start();
    }

    public class TestDemo implements Runnable {
        @Override
        public void run() {
            System.out.println(FixThisEscape.this.value);
        }
    }
}

package net.nanthrax.blog.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class MdcExampleBean {

    private Logger logger = LoggerFactory.getLogger(MdcExampleBean.class);

    public void init() throws Exception {
        CycleThread thread1 = new CycleThread("thread1");
        CycleThread thread2 = new CycleThread("thread2");
        CycleThread thread3 = new CycleThread("thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    class CycleThread extends Thread {
        private String mdcContext;
        public CycleThread(String mdcContext) {
            this.mdcContext = mdcContext;
        }
        public void run() {
            MDC.put("threadId", mdcContext);
            for (int i = 0; i < 20; i++) {
                logger.info("Cycle {}", i);
            }
        }
    }

}

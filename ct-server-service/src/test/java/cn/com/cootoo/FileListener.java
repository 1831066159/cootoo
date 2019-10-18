package cn.com.cootoo;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 文件监听
 *
 * @author zhaoxiang
 * @create 2019/5/20
 **/
public class FileListener extends FileAlterationListenerAdaptor {
    private static final Logger log = LoggerFactory.getLogger(FileListener.class);

    /**
     * 监听目录下文件创建
     *
     * @param file 文件目录，不可以是文件
     */
    @Override
    public void onFileCreate(File file) {
        log.info("监听[文件创建]:{}", file.getAbsolutePath());
        System.out.println("目录下文件创建");

    }


    public static void main(String[] args) throws Exception {
        // 监控目录
        String rootDir = "/opt/data/";
        // 轮询间隔 30分钟
        long interval = TimeUnit.SECONDS.toMillis(5);

        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));
        observer.addListener(new FileListener());

        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        monitor.start();
        System.out.println("开始监控");
    }





}

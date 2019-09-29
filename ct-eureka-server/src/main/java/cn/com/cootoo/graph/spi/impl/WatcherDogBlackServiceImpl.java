package cn.com.cootoo.graph.spi.impl;

import cn.com.cootoo.graph.spi.IWatchDogService;

/**
 * @author zhaoxiang
 * @create 2019/4/25
 **/
public class WatcherDogBlackServiceImpl implements IWatchDogService{


    @Override
    public void watcher() {
        System.out.println("black watcher.....");
    }
}

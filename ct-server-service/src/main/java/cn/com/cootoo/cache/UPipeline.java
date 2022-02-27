package cn.com.cootoo.cache;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @author system
 * @create 2019/6/27
 **/
public class UPipeline {


    public static void usePipeline() {
        String key = "key";
        Jedis jedis = new Jedis("xx.xx.xx.xx");
        Pipeline p = jedis.pipelined();
        //要插入的数据列表
        List<String> myData = new ArrayList<>();
        for (String data : myData) {
            p.hset("hh", "k_", data);
        }
        p.sync();
        jedis.close();

    }


}

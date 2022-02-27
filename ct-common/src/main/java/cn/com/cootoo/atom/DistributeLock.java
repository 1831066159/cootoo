package cn.com.cootoo.atom;

import io.etcd.jetcd.*;
import io.etcd.jetcd.kv.GetResponse;
import io.etcd.jetcd.lease.LeaseTimeToLiveResponse;
import io.etcd.jetcd.options.LeaseOption;
import io.etcd.jetcd.watch.WatchEvent;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author system
 * @create 2019/8/20
 **/
public class DistributeLock {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        watch();
    }


    // 创建客户端，本例中Etcd服务端为单机模式
    private static Client client = Client.builder().endpoints("http://localhost:2379").build();

    private static Charset UTF8 = Charset.forName("utf-8");

    /**
     * key-value 存储
     */
    public void KV() {
        try {
            KV kvClient = client.getKVClient();
            // 对String类型的key-value进行类型转换
            ByteSequence key = ByteSequence.from("test_key".getBytes());
            ByteSequence value = ByteSequence.from("test_value".getBytes());

            // put操作，等待操作完成
            kvClient.put(key, value).get();
            // get操作，等待操作完成
            CompletableFuture<GetResponse> getFuture = kvClient.get(key);
            GetResponse response = getFuture.get();
            System.out.println("get result:" + response.toString());
            // delete操作，等待操作完成
            //kvClient.delete(key).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 用于创建租约、续约、解约，以及检索租约的详情，租约绑定的键值等信息
     */
    public static void lease() {
        try {
            // 创建Lease客户端
            Lease leaseClient = client.getLeaseClient();
            // 创建一个60s的租约，等待完成，超时设置阈值30s
            Long leaseId = leaseClient.grant(60).get(30, TimeUnit.SECONDS).getID();
            System.out.println(leaseId);
            // 使指定的租约永久有效，即永久租约
            leaseClient.grant(leaseId);
            // 续约一次
            leaseClient.keepAliveOnce(leaseId);
            // 解除租约，绑定该租约的键值将被删除
            leaseClient.revoke(leaseId);
            // 检索指定ID对应的租约的详细信息
            LeaseTimeToLiveResponse lTRes = leaseClient.timeToLive(leaseId, LeaseOption.newBuilder().withAttachedKeys().build()).get();

            System.out.println(lTRes.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听客户端，可为key或者目录（前缀机制）创建 Watcher，
     * Watcher 可以监听 key 的事件（put、delete 等），
     * 如果事件发生，可以通知客户端，客户端采取某些措施。
     */
    public static void watch() {
        try {
            // 对String类型的key进行类型转换
            ByteSequence key = ByteSequence.from("test_key", UTF8);

            CountDownLatch latch = new CountDownLatch(200);

            // 开始listen，如果监听的key有事件(如删除、更新等)发生则返回
            Watch.Listener listener = Watch.listener(watchResponse -> {
                System.out.println("Watching for key=" + Optional.ofNullable(key).map(bs -> bs.toString(UTF8)));
                // 解析eventlist，判断是否为自己关注的事件，作进一步操作
                for (WatchEvent event : watchResponse.getEvents()) {
                    System.out.println("type=" + event.getEventType()
                            + ", key=" + Optional.ofNullable(event.getKeyValue().getKey()).map(bs -> bs.toString(UTF8))
                            + ", value=" + Optional.ofNullable(event.getKeyValue().getValue()).map(bs -> bs.toString(UTF8)));

                    // To do something
                }
                latch.countDown();
            });

            try (
                    // 创建Watch客户端
                    Watch watchClient = client.getWatchClient();
                    // 为key创建一个Watcher
                    Watch.Watcher watcher = watchClient.watch(key, listener);
            ) {
                System.out.println("创建Watch客户端监听......");
                latch.await();

            } catch (Exception e) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.utsoft.redis01;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Arrays;
import java.util.List;

/**
 * redis 的 java API
 */
public class TestSingleRedis {
    private static Jedis jedis; // redis 实例
    private static ShardedJedis shard; // 分片
    private static ShardedJedisPool pool; // 池化，就相当于是一个连接池。


    // 连接池的配置 的一些参数。
    @BeforeClass
    public static void setUpBeforClass()throws Exception{
        jedis = new Jedis("192.168.40.129",6379);

        List<JedisShardInfo> shards = Arrays.asList(
                new JedisShardInfo("192.168.40.129",6379));
        shard = new ShardedJedis(shards);

        GenericObjectPoolConfig goConfig = new GenericObjectPoolConfig();
        //
        //
        goConfig.setMaxTotal(100);
        goConfig.setMaxIdle(20);
        goConfig.setMaxWaitMillis(-1);
        goConfig.setTestOnBorrow(true);
        pool = new ShardedJedisPool(goConfig, shards);
    }

    @AfterClass
    public static void tearDownafterClass(){
        jedis.disconnect();
        shard.disconnect();
        pool.destroy();
    }

    // 就相当于是 redis 哪个哪些命令，往 redis 里面添加数据，只是 针对 redis string 类型的测试
    @Test
    public void testString(){
        String reslut = jedis.set("naem","bhr");
        System.out.println(reslut);
        System.out.println(jedis.get("naem"));
    }

    // 还有其它 redis 4种类型的测试。


}

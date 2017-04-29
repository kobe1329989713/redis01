package com.utsoft.redis01;

import redis.clients.jedis.Jedis;

/**
 *
 */
public class TestRedis {

    public void test(){
        final String SYS_USER_TABLE = "SYS_USER_TABLE";
        final String SYS_USER_TABLE_1 = "SYS_USER_TABLE_1";
        final String SYS_USER_TABLE_2 = "SYS_USER_TABLE_2";
        final String SYS_USER_TABLE_3 = "SYS_USER_TABLE_3";

        Jedis j = new Jedis("192.168.40.129",6379);


    }
}

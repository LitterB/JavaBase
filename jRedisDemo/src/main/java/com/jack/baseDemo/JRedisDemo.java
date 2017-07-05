package com.jack.baseDemo;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by jack on 2017/7/4.
 */
public class JRedisDemo {
    private static final String HOST = "115.159.146.80";
    private static final Integer PORT = 6379;

    public static void main(String[] args){
        //连接redis
        Jedis jedis = new Jedis(HOST,PORT);
        System.out.println("connect success!");
        System.out.println("server is running:" + jedis.ping());
        stringMethod(jedis);
        listMethod(jedis);
        keyMethod(jedis);
        jedis.close();
        System.out.println("connect closed!");
    }

    //redis字符串操作
    private static void stringMethod(Jedis jedis){
        String runoobkey = jedis.set("runoobkey", "www.runboob.com");
        System.out.println(runoobkey);
        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
    }

    private static void listMethod(Jedis jedis){
        //存储数据到列表中
        jedis.lpush("site-list","Runoob");
        jedis.lpush("site-list","Google");
        Long taobao = jedis.lpush("site-list", "Taobao");

        //获取存储的数据并输出
        List<String> list = jedis.lrange("site-list",0,2);
        for (String aList : list) {
            System.out.println("列表项为：" + aList);
        }
        System.out.println(taobao);
    }

    private static void keyMethod(Jedis jedis){
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}

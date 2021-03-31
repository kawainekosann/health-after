package com.kawainekosann.server.jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestPing {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.10.1",6379);
        //jedis所有命令就是我们之前学的命令
        //System.out.println(jedis.ping());
        jedis.flushAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","word");
        jsonObject.put("name","kuangshen");
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();
        // jedis.watch(result)
        try {
            multi.set("user1",result);
            multi.set("user2",result);
            int i = 1/0 ; // 代码抛出异常事务，执行失败！
            multi.exec(); // 执行事务！
        } catch (Exception e) {
            multi.discard(); // 放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close(); // 关闭连接
        }
    }
}

package com.iFox.utils;

import com.google.gson.Gson;
import com.iFox.utils.vo.TokenModel;
import redis.clients.jedis.Jedis;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
public class RedisUtils {
    private static final int expTime = 30 * 24 * 60 * 60;
    private static Gson gson = new Gson();

    public static void addToken(TokenModel tokenModel) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("redis连接成功");
        String key = String.valueOf(tokenModel.getUuid());
        String result = jedis.set(key, gson.toJson(tokenModel));
        jedis.expire(key,expTime);
        if (result != null) {
            System.out.println("token存储成功");
        } else {
            System.out.println("token存储失败");
        }
        jedis.close();
    }

    public static boolean getToken(TokenModel tokenModel) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("redis连接成功");
        String resultToken = jedis.get(String.valueOf(tokenModel.getUuid()));
        jedis.close();
        if (resultToken != null) {
            return true;
        }
        return false;
    }

    public static void deleteToken(TokenModel tokenModel) {
        Jedis jedis = new Jedis("localhost");
        String key = String.valueOf(tokenModel.getUuid());
        long delStatus =  jedis.del(key);
        if (delStatus > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("该token已经过期");
        }
        jedis.close();
    }
}

package com.mygeno.test.redis.dao.impl;

import com.mygeno.test.redis.dao.JedisDao;
import redis.clients.jedis.Jedis;

/**
 * @Auther: yt
 * @Date: 2019/2/14
 * @Description: com.mygeno.test.redis.dao.impl
 * @version: 1.0
 */
public class JedisDaoImpl implements JedisDao {

    private Jedis jedis;

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean exists(String key) {
        return jedis.exists(key);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public String set(String key, String value) {
        return jedis.set(key, value);
    }
}

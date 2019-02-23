package com.mygeno.test.redis.dao;

/**
 * @Auther: yt
 * @Date: 2019/2/14
 * @Description: com.mygeno.test.redis.dao
 * @version: 1.0
 */
public interface JedisDao {

    /**
      * 功能描述: 判断是否存在
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/14 15:39
      */
    public boolean exists(String key);

    /**
     * 功能描述: 取value
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/14 15:39
     */
    public String get(String key);

    /**
     * 功能描述: 设置key和value
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/14 15:39
     */
    public String set(String key, String value);
}

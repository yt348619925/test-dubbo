package com.mygeno.test.utils;

import org.springframework.util.DigestUtils;

/**
 * @Auther: yt
 * @Date: 2019/2/13
 * @Description: com.mygeno.test.utils
 * @version: 1.0
 */
public class Md5Utils {

    private final static String DEFAULT_SALT = "mygeno";
    private static String salt = DEFAULT_SALT;

    private final static Integer DEFAULT_ITERATOR = 2;
    private static Integer iterator = DEFAULT_ITERATOR;

    public static String getSalt() {
        return salt;
    }

    public static void setSalt(String salt) {
        Md5Utils.salt = salt;
    }

    public static Integer getIterator() {
        return iterator;
    }

    public static void setIterator(Integer iterator) {
        Md5Utils.iterator = iterator;
    }

    /**
      * 功能描述: md5加盐迭代加密
      * content   密码原文
      * salt   盐,可为空,有默认值---mygeno
      * iterator   迭代次数,有默认值, 2次
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/13 10:24
      */
    public static String md5(String content, String salt, Integer iterator){
        String newContent = "";
        if(salt != null && salt != ""){
            newContent = content + salt;
        }else{
            newContent = content + Md5Utils.getSalt();
        }

        if(iterator != null){
            for (int i = 0;i < iterator;i++){
                newContent = DigestUtils.md5DigestAsHex(newContent.getBytes());
            }
        }else{
            for (int i = 0;i < Md5Utils.getIterator();i++){
                newContent = DigestUtils.md5DigestAsHex(newContent.getBytes());
            }
        }
        return newContent;
    }

    /**
     * 功能描述: md5加盐迭代加密,迭代次数为默认值2次
     * content   密码原文
     * salt   盐,可为空,有默认值---mygeno
     * iterator   迭代次数,有默认值, 2次
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/13 10:24
     */
    public static String md5(String content, String salt){
        String newContent = "";
        if(salt != null && salt != ""){
            newContent = content + salt;
        }else{
            newContent = content + Md5Utils.getSalt();
        }


        for (int i = 0;i < Md5Utils.getIterator();i++){
            newContent = DigestUtils.md5DigestAsHex(newContent.getBytes());
        }

        return newContent;
    }

    /**
     * 功能描述: md5加盐迭代加密,迭代次数为默认值2次,盐为默认值---mygeno
     * content   密码原文
     * salt   盐,可为空,有默认值---mygeno
     * iterator   迭代次数,有默认值, 2次
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/13 10:24
     */
    public static String md5(String content){
        String newContent = "";

        newContent = content + Md5Utils.getSalt();

        for (int i = 0;i < Md5Utils.getIterator();i++){
            newContent = DigestUtils.md5DigestAsHex(newContent.getBytes());
        }

        return newContent;
    }


    public static void main(String[] args){
        System.out.println(md5("123456"));
    };
}

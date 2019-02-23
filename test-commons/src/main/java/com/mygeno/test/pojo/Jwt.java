package com.mygeno.test.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: yt
 * @Date: 2019/2/19
 * @Description: com.mygeno.test.pojo
 * @version: 1.0
 */
public class Jwt implements Serializable {

    public static final String typ = "JWT";

    public static final String alg = "HS256";

    private String iss;//jwt签发者

    private String sub;//jwt所面向的用户

    private String aud;//接收jwt的一方

    private Date exp;//jwt的过期时间，这个过期时间必须大于签发时间

    private Date nbf;//定义在什么时间之前，该jwt都是不可用的

    private Date iat;//jwt的签发时间

    private String jti;//jwt的唯一身份标识，主要用来作为一次性token，从而回避重放攻击

    private long ttlMillis;

    public long getTtlMillis() {
        return ttlMillis;
    }

    public void setTtlMillis(long ttlMillis) {
        this.ttlMillis = ttlMillis;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Date getNbf() {
        return nbf;
    }

    public void setNbf(Date nbf) {
        this.nbf = nbf;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}

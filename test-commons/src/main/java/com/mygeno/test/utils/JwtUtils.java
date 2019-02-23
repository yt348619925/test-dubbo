package com.mygeno.test.utils;

import com.mygeno.test.pojo.Jwt;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yt
 * @Date: 2019/2/19
 * @Description: com.mygeno.test.utils
 * @version: 1.0
 */
public class JwtUtils {

    /**
      * 功能描述: 创建jwt返回体
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/19 10:19
     *
     * iss：jwt签发者
     * sub：jwt所面向的用户
     * aud：接收jwt的一方
     * exp：jwt的过期时间，这个过期时间必须大于签发时间
     * nbf：定义在什么时间之前，该jwt都是不可用的
     * iat：jwt的签发时间
     * jti：jwt的唯一身份标识，主要用来作为一次性token，从而回避重放攻击
     *
      */
    public static String createJwt(Jwt jwt){
        //添加加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typ", jwt.typ);
        map.put("alg", jwt.alg);

        String header = JsonUtils.objectToJson(map);

        //ApiKey密钥签署JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(header);

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());


        //设置JWT Claims
        JwtBuilder builder = Jwts.builder().setIssuer(jwt.getIss())
                //jwt所面向的用户
                .setSubject(jwt.getSub())
                //接收jwt的一方
                .setAudience(jwt.getAud())
//                //定义在什么时间之前，该jwt都是不可用的
//                .setNotBefore(jwt.getNbf())
                //jwt的签发时间
                .setIssuedAt(jwt.getIat())
                //jwt签发者
                .setIssuer(jwt.getIss())
                .signWith(signatureAlgorithm, signingKey);

        if(jwt.getTtlMillis() >= 0){
            long expMillis = System.currentTimeMillis() + jwt.getTtlMillis();
            jwt.setExp(new Date(expMillis));
            builder.setExpiration(jwt.getExp());
        }

        //构建JWT并将其序列化为一个紧凑的url安全字符串
        return builder.compact();
    };
}

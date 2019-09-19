package com.ysd.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 *  * token工具类
 *
 */
public class TokenUtil {
	private static String secretKey ="哈哈";
	/**
	 * 根据用户名以及用户id生成token
	 * @param name 用户名
	 * @param id 用户id
	 * @param lastLoginTime 最后登录时间
	 * @return token字符串
	 */
	public static String createToken(String name,String id,Date lastLoginTime) {
		JwtBuilder builder = Jwts.builder()
							//设置id
							 .setId(id) 
							//设置用户名
							 .setSubject(name)
							//设置最后登录时间
							 .setIssuedAt(lastLoginTime)
							//设置过期时间
							 .setExpiration(new Date(lastLoginTime.getTime()+1000*60*20))
							 //设置签名密钥及盐值
							 .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
							//设置自定义属性，可添加多个键值对
							 .claim("role", "admin")
				;
		return builder.compact();
	}
	/**
	 * 解析token
	 * @param token 要解析的token
	 * @return 获取到的一个键值对集合 （存储的是生成token时放入的相关信息）
	 */
	public static  Claims parserTonken(String token){
		Claims body = Jwts.parser()
		.setSigningKey(secretKey.getBytes())
		.parseClaimsJws(token)
		.getBody();
		return body;
	}
	
	
	
	
	public static void main(String[] args) {
		String createToken = TokenUtil.createToken("张三", "1", new Date());
		System.out.println(createToken);
		
		Claims parserTonken = TokenUtil.parserTonken(createToken);
		System.out.println(parserTonken.getId()+"=="+parserTonken.getSubject());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parserTonken.getExpiration()));
		
		
	}
}

package com.demo.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil  {
	
	public static final long JWT_TOKEN_VALIDITY =5 * 60 * 60;
	
	private String secrete = "jwtTokenKey";
	
	
	//retriew username from jwt token 
	
	public String getUsernameFromToken(String token){
		
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	
	// expiration date from jwt token 
	public Date getExpirationDateFromToken(String token) {
		
		return getClaimFromToken(token,Claims::getExpiration) ;
		
	}
	
	public <T> T getClaimFromToken(String token,Function<Claims,T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}


	private Claims getAllClaimsFromToken(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(secrete).parseClaimsJwt(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token); 
		return expiration.before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims,userDetails.getUsername()); 
			
		}
		
	private String doGenerateToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm .HS512, secrete).compact();
	}
	
	 // validate token 
	public boolean validateToken(String token , UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	


	private String getClaimFromToken(String token, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

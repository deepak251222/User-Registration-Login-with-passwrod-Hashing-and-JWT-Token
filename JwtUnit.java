package com.main.secrity;


import java.security.Key;
import java.util.Arrays;
import java.util.List;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmConstraints.ConstraintType;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.springframework.stereotype.Component;

import com.main.Entity.User;


@Component
public class JwtUnit {
	
	public String generateToken(User user) {
		
		try {
		    RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
            rsaJsonWebKey.setKeyId("k1");
            JwtClaims claims = new JwtClaims();
		    claims.setClaim("User id",user.getUid());
		    claims.setClaim("User name",user.getUser_name());
		    claims.setClaim("User  age",user.getUage());
		    claims.setClaim("User city",user.getUcity());
		    claims.setClaim("User email",user.getUsername());
		    claims.setClaim("User pwd",user.getUpwd());
		    JsonWebSignature jws = new JsonWebSignature();
		    jws.setPayload(claims.toJson());
		    jws.setKey(rsaJsonWebKey.getPrivateKey());
		    jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
		    jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);   
		    String jwt = jws.getCompactSerialization();
		    System.out.println("JWT: " + jwt);
		    return jwt;
		}
		catch (Exception e){
			e.printStackTrace();
			return "";
		}
	}
}

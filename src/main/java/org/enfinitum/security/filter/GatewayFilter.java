package org.enfinitum.security.filter;

import javax.servlet.http.HttpServletRequest;

import org.enfinitum.security.util.AESEncryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author Puneet.Negi
 *   This filter can modify request and response object.
 */
public class GatewayFilter extends ZuulFilter {

	@Value("${mobile.clientId}")
	private String clientId;

	@Value("${mobile.clientSecret}")
	private String clientSecret;
	
	@Value("${secure.aes.key}")
	private String aesKey;
	
	private static Logger log = LoggerFactory.getLogger(GatewayFilter.class);
	@Override
	public String filterType() {
		return "pre";
	}
	@Override
	public int filterOrder() {
		return 1;
	}
	@Override
	public boolean shouldFilter() {
		return true;
	}
	@Override
	public Object run() {

		try{
		RequestContext ctx = RequestContext.getCurrentContext();	   
		HttpServletRequest request = ctx.getRequest();

		String tokenKey=clientId+":"+clientSecret;

		String encryptedString = AESEncryption.encrypt(tokenKey, aesKey) ;
		ctx.addZuulRequestHeader("authToken", encryptedString);

		log.info(String.format("%s request to puneet %s", request.getMethod(), request.getRequestURL().toString()));
		}catch(Exception e){		
			log.error(String.format("Error is data entryption %s",e.getMessage()));
			
		}
		return null;
	}
}

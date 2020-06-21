package com.zuul.gateway;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return RequestContext.getCurrentContext().getRequest().getHeader("Authorization") != null;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		// izvuci token iz zahteva i dodaj ga u zuul
		try {
			if (request.getHeader("Authorization") != "") {
				String token = request.getHeader("Authorization");
				System.out.println("Token: " + token);
				ctx.addZuulRequestHeader("Authorization", token);
			}
		} catch (Exception e) {
			System.out.println("null kod filterType");
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}

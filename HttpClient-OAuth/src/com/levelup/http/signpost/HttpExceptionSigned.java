package com.levelup.http.signpost;

import com.levelup.http.HttpException;

public class HttpExceptionSigned extends HttpException {

	private static final long serialVersionUID = 4762520740398938346L;

	private final OAuthUser user;
	
	protected HttpExceptionSigned(Builder builder) {
		super(builder);
		this.user = builder.user;
	}
	
	public OAuthUser getOAuthUser() {
		return user;
	}

	@Override
	public String getMessage() {
		if (null==user)
			return super.getMessage();
		StringBuilder sb = new StringBuilder(super.getMessage());
		sb.append(" for ");
		sb.append(user);
		return sb.toString();
	}
	
	public static class Builder extends HttpException.Builder {
	
		private final OAuthUser user;
		
		public Builder(HttpRequestSigned request) {
			super(request);
			this.user = request.getOAuthUser();
		}
		
		public Builder(HttpExceptionSigned e) {
			super(e);
			this.user = e.user;
		}
	}

}

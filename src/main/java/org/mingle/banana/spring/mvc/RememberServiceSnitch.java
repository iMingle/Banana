package org.mingle.banana.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;

public class RememberServiceSnitch {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RememberServiceSnitch.class);

	public void tellMe() {
		LOGGER.error("************   KEY: " + rememberService.getKey());
	}

	public void setRememberService(AbstractRememberMeServices rememberService) {
		this.rememberService = rememberService;
	}

	public AbstractRememberMeServices getRememberService() {
		return rememberService;
	}

	private AbstractRememberMeServices rememberService;
}

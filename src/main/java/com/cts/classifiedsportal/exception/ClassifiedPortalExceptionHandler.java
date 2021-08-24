package com.cts.classifiedsportal.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ClassifiedPortalExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(FeignException.class)
	public ModelAndView handleFeignException(FeignException fe) {
		if (fe.getMessage().contains("Unauthorized")) {
			log.error("Bad request:Invalid Credentials");
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
		log.error("Bad request:Service unavailable");
		ModelAndView modelAndView = new ModelAndView("errorpage");
		return modelAndView;

	}

	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(NullPointerException npe) {
		log.error("Bad request:Session Expired");
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;

	}

}

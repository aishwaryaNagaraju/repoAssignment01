package com.te.electionmanagement.controller2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.electionmanagement.exception.CandidateException;

@ControllerAdvice
public class CandidateExceptionController {
	
	@ExceptionHandler(CandidateException.class)
	public String handleException(HttpServletRequest request, CandidateException exception) {
		request.setAttribute("errMsg", exception.getMessage());
		return "loginform";
	}

}

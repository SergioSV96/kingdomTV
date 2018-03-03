package daw.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	
	private Log logger = LogFactory.getLog(ExceptionController.class);
	
	@ExceptionHandler(value = Exception.class)
	public String handleError(HttpServletRequest request, Exception exception){
		logger.error("Request: " + request.getRequestURL() + " raised ", exception);
		//logger.error("Request: " + request.getRequestURL() + " raised " + exception);
		return "redirect:/error";
	
	}
	
	
	
}

package tn.com.abt.smw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    private Object[] params;
	
	public NotFoundException(String message, Object[] params) {
		super(message);
		this.params = params;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
}
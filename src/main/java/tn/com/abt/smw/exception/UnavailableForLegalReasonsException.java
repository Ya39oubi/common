package tn.com.abt.smw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
public class UnavailableForLegalReasonsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    private Object[] params;
	
	public UnavailableForLegalReasonsException(String message, Object[] params) {
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
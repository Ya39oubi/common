package tn.com.abt.smw.exception;

import java.io.Serializable;
import java.util.Date;

public class ErrorDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	private Object[] params;
	
    
	public ErrorDetails(Date timestamp, int status, String error, String message, String path, Object[] params) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.params = params;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
	
}

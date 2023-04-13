package tn.com.abt.smw.exception;

import java.io.Serializable;
import java.util.Date;

public class InfoDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private int status;
	private String info;
	private String message;
	private String path;
	private Object[] params;
	
	public InfoDetails(Date timestamp, int status, String info, String message, String path, Object[] params) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.info = info;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

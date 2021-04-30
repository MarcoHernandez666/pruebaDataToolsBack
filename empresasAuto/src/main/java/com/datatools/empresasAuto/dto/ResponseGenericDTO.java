package com.datatools.empresasAuto.dto;

import org.springframework.http.HttpStatus;

public class ResponseGenericDTO {
	
	private Object data;
	private boolean success;
	private String message;
	private HttpStatus status;
	
	public ResponseGenericDTO() {
		super();
	}

	public ResponseGenericDTO(Object data, boolean success, String message, HttpStatus status) {
		super();
		this.data = data;
		this.success = success;
		this.message = message;
		this.status = status;
	}
	public ResponseGenericDTO(Object data, boolean success, String message) {
		super();
		this.data = data;
		this.success = success;
		this.message = message;
	}
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (success ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseGenericDTO other = (ResponseGenericDTO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		return !(success != other.success);
	}

	@Override
	public String toString() {
		return "ResponseGenericDTO [data=" + data + ", success=" + success + ", message=" + message + ", status="
				+ status + "]";
	}
	
	public String responseArchivos() {
		return "{\"data\":\"" + data + "\", \"success\":" + success + ", \"message\":\"" + message + "\", \"status\":\""
				+ status + "\"}";
	}

}

package com.ss.mp.common.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ss.mp.common.constant.Constants;

@Setter
@Getter
@NoArgsConstructor
public class CommonResponse<T> implements Serializable{

    public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	private static final long serialVersionUID = 1L;
    private Integer resultCode;
    private String message;
    private T value;
    
	public CommonResponse<T> successfulRespone(T value) {
		this.resultCode = Constants.RESULT_CODE_SUCCESS;
		this.message = Constants.MESSAGE_SUCCESS;
		this.value = value;
		
		return this;
	}
    
	public CommonResponse<T> failedRespone(T value) {
		this.resultCode = Constants.RESULT_CODE_FAIL;
		this.message = Constants.MESSAGE_FAIL;
		this.value = value;
		
		return this;
	}
}

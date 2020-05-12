package com.pdw.exceptionalHandling;

@SuppressWarnings("serial")
public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(String msg) {
		super(msg);
	}
	public DuplicateUserIdException(String msg,Throwable e) {
		super(msg,e);
	}
	

} 

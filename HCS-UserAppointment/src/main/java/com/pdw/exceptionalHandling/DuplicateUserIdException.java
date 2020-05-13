package com.pdw.exceptionalHandling;

@SuppressWarnings("serial")
//Throws a Duplicate user Id exception if the user is trying to make a new appointment with the
//same user Id
public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(String msg) {
		super(msg);
	}
	public DuplicateUserIdException(String msg,Throwable e) {
		super(msg,e);
	}
	

} 

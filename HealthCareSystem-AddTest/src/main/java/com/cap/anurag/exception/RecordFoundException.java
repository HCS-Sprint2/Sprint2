package com.cap.anurag.exception;

@SuppressWarnings("serial")
public class RecordFoundException  extends RuntimeException{
	 public RecordFoundException(String msg){
	        super(msg);
	    }

	    public RecordFoundException(String msg,Throwable e){
	        super(msg,e);
	    }

}

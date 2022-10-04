package com.ear.core.util;

public class SolutionException extends Exception {
	
	private static final long serialVersionUID = -5081758655663775352L;

	public SolutionException() {
		super();
	}

	public SolutionException(String message) {
		super(message);
	}

	public SolutionException(Throwable cause) {
		super(cause);
	}

	public SolutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public SolutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}	
	
}


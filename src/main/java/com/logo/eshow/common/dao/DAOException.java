package com.logo.eshow.common.dao;

/**
 * DAO Exception
 * <p>
 * 
 * @author leida
 */
public class DAOException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3257284725541254961L;

	/**
	 * construction
	 * 
	 * @param code
	 *            message
	 * @param cause
	 *            throwable
	 */
	public DAOException(String message, Throwable cause) {

		super(message, cause);

	}
}

package com.directory.base;

public interface IBaseAPI {

	/**
	 * Get the event instance of the given class.
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public <T> T getEvent(Class<T> clazz);
	
	/**
	 * Set the user context.
	 * @param userContext
	 */
	//public void setUserContext(IUserContext userContext);
}

package com.directory.event;

public class BaseEvent extends Event {

	private static final long serialVersionUID = -6287331787409891438L;



	public BaseEvent(){}

	public BaseEvent(String eventName) {
		this.setEventName(eventName);
	}

	public <T> T get(String keyToRead, Class<T> clazz) {
		return (T) getFromResponse(keyToRead);
	}

	public void put(String key, Object value) {
		putInResponse(key, value);
	}


}

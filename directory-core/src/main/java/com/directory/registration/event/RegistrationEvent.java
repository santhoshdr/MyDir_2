package com.directory.registration.event;

import org.directory.entity.RegistrationInfoData;

import com.directory.event.BaseEvent;
import com.directory.user.AppUser;

public class RegistrationEvent extends BaseEvent {

	private static final long serialVersionUID = 1L;

	private AppUser appuser;


	private RegistrationInfoData registrationInfoData;

	private static String REGISTRATION_EVENT = "registrationEvent";

	public RegistrationEvent(String eventName) {
		super(eventName);
	}

	public RegistrationEvent() {
		super(REGISTRATION_EVENT);
	}

	public AppUser getAppuser() {
		return appuser;
	}

	public void setAppuser(AppUser appuser) {
		this.appuser = appuser;
	}

	public RegistrationInfoData getRegistrationInfoData() {
		return registrationInfoData;
	}

	public void setRegistrationInfoData(RegistrationInfoData registrationInfoData) {
		this.registrationInfoData = registrationInfoData;
	}
}

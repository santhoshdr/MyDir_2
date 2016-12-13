package com.directory.user;

public class AppUser extends User {

	private String userEmailId;

	private String userPassword;

	private boolean rememberme;

	private SecurityConfig securityConfig;


	/**
	 * @return the userEmailId
	 */
	public String getUserEmailId() {
		return userEmailId;
	}

	/**
	 * @param userEmailId the userEmailId to set
	 */
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the rememberme
	 */
	public boolean isRememberme() {
		return rememberme;
	}

	/**
	 * @param rememberme the rememberme to set
	 */
	public void setRememberme(boolean rememberme) {
		this.rememberme = rememberme;
	}

	/**
	 * @return the securityConfig
	 */
	public SecurityConfig getSecurityConfig() {
		return securityConfig;
	}

	/**
	 * @param securityConfig the securityConfig to set
	 */
	public void setSecurityConfig(SecurityConfig securityConfig) {
		this.securityConfig = securityConfig;
	}



}

package com.lawencon.bookleasing.model;

import org.springframework.stereotype.Component;

/**
 * @author Imron Rosyadi
 */

@Component
public class ProfileSession {

	private Profiles activeProfile;

	public Profiles getActiveProfile() {
		return activeProfile;
	}

	public void setActiveProfile(Profiles activeProfile) {
		this.activeProfile = activeProfile;
	}

}
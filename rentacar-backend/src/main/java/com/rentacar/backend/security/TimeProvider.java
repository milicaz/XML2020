package com.rentacar.backend.security;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6567704301502694697L;

	public Date now() {
		return new Date();
	}

}

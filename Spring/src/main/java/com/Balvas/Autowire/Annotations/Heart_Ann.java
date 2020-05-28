package com.Balvas.Autowire.Annotations;

import org.springframework.beans.factory.annotation.Value;

public class Heart_Ann {

	int heartCount;

	@Value(value = "${Octopus.heartCount}")
	public void setHeartCount(int heartCount) {
		this.heartCount = heartCount;
	}

	public String getHeartCount() {
		return "Heart Count Called with Count " + heartCount;

	}
}

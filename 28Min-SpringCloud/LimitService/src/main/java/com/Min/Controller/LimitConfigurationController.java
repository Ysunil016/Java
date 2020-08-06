package com.Min.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Min.Beans.limitConfiguration;
import com.Min.Config.LimitConfiguration;

@RestController
public class LimitConfigurationController {

	@Autowired
	private LimitConfiguration limitConfig;

	@GetMapping("/limits")
	public limitConfiguration retrieveLimitFromConfig() {
		return new limitConfiguration(limitConfig.getMin(), limitConfig.getMax());
	}

}

package com.Sunil.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restricted")
@PreAuthorize("isAuthenticated()") // Class Level Security
public class PrivateController {

	@GetMapping
	public String getRestrictedHome() {
		return "Restricted Home";
	}

}

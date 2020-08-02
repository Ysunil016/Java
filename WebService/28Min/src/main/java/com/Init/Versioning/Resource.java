package com.Init.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	// URI - Versioning
	
	@GetMapping("/v1/getName")
	private UserV1 getByAPIV1() {
		return new UserV1("Sunil");
	}

	@GetMapping("/v2/getName")
	private UserV2 getByAPIV2() {
		return new UserV2("Sunil", "Yadav");
	}

	// Request - Versioning
	
	@GetMapping(value = "/getName", params = "version=1")
	private UserV1 getByParamV1() {
		return new UserV1("Sunil");
	}

	@GetMapping(value = "/getName", params = "version=2")
	private UserV2 getByParamV2() {
		return new UserV2("Sunil", "Yadav");
	}

	// Header - Versioning
	
	@GetMapping(value = "/getName", headers = "VERSION=1")
	private UserV1 getByHeaderV1() {
		return new UserV1("Sunil");
	}

	@GetMapping(value = "/getName", headers = "VERSION=2")
	private UserV2 getByHeaderV2() {
		return new UserV2("Sunil", "Yadav");
	}
	
	// MIME - Versioning
	
	@GetMapping(value = "/getName", produces = "application/v1+json")
	private UserV1 getByProducesV1() {
		return new UserV1("Sunil");
	}

	@GetMapping(value = "/getName", produces = "application/v2+json")
	private UserV2 getByProducesV2() {
		return new UserV2("Sunil", "Yadav");
	}

}

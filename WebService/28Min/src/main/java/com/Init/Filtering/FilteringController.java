package com.Init.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/userBeanFilter")
	private UserFilter getFilter() {
		return new UserFilter("Sunil", "12345", 25);
	}

	@GetMapping("/userListBeanFilter")
	private List<UserFilter> getListFilter() {
		return Arrays.asList(new UserFilter("Sanjay", "Sanjay01", 32), new UserFilter("Nirmala", "Nirmala01", 35));
	}

	@GetMapping("/userBeanDynamicFilter")
	private MappingJacksonValue getDynamicFilter() {
		UserFilter user = new UserFilter("Sunil", "12345", 25);

		MappingJacksonValue mapJson = new MappingJacksonValue(user);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "age"); // Only
																											// Username
																											// and
																											// Password
																											// allowed.

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilterDynamic", filter);

		mapJson.setFilters(filters);

		return mapJson;
	}

	@GetMapping("/userListBeanDynamicFilter")
	private MappingJacksonValue getDynamicListFilter() {

		UserFilter user = new UserFilter("Sunil", "12345", 25);
		UserFilter user2 = new UserFilter("Sanjay", "123456", 32);

		// Object with List of Beans
		MappingJacksonValue mapJson = new MappingJacksonValue(Arrays.asList(user, user2));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilterDynamic", filter);

		mapJson.setFilters(filters);

		return mapJson;
	}
}

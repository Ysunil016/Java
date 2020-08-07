package com.Min.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Min.Bean.ExchangeValue;

@RestController
@RequestMapping("/exchange")
public class CurrencyExchangeController {

	@Autowired
	Environment environment;

	@GetMapping(value = "/from/{from}/to/{to}")
	public ExchangeValue getCurrencyExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		ExchangeValue eVal = new ExchangeValue(123L, from, to, BigDecimal.valueOf(64.5));
		eVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return eVal;
	}

}

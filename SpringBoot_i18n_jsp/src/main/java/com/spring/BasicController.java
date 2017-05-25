package com.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

	@RequestMapping("/")
	public String welcome(Map<String, String> model) {
		model.put("message", "hello");
		return "welcome";
	}

}
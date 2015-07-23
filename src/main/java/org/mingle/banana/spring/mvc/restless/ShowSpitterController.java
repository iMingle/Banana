package org.mingle.banana.spring.mvc.restless;

import java.util.Map;

import org.mingle.banana.spring.mvc.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowSpitterController {
	@RequestMapping(value = "/showSpitter", method = RequestMethod.GET)
	public String showSpitter(@RequestParam String username,
			Map<String, Object> model) {
		model.put("spitter", spitterService.getSpitter(username));
		return "spitter";
	}

	@Autowired
	SpitterService spitterService;
}

package org.mingle.banana.spring.mvc.rest;

import java.util.List;

import javax.inject.Inject;

import org.mingle.banana.spring.jdbc.Spitter;
import org.mingle.banana.spring.jdbc.Spittle;
import org.mingle.banana.spring.mvc.service.SpitterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/spitters")
public class SpittersController {
	private SpitterService spitterService;

	@Inject
	public SpittersController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}

	@RequestMapping(value = "/{spitterName}/spittles", method = RequestMethod.GET)
	public @ResponseBody List<Spittle> spittlesForSpitter(
			@PathVariable("spitterName") String spitterName) {
		Spitter spitter = spitterService.getSpitter(spitterName);
		return spitterService.getSpittlesForSpitter(spitter);
	}
}

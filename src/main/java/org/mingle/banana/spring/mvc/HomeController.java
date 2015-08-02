package org.mingle.banana.spring.mvc;

import java.util.Map;

import javax.inject.Inject;

import org.mingle.banana.spring.mvc.service.SpitterService;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ManagedResource(objectName = "spitter:name=HomeController")	// 导出为MBean
public class HomeController {

	private SpitterService spitterService;

	@Inject
	public HomeController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		model.put("spittles", spitterService.getRecentSpittles(spittlesPerPage));
		return "home";
	}

	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	@ManagedAttribute	// 将spittlesPerPage发布为托管属性
	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}

	@ManagedAttribute
	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}
}

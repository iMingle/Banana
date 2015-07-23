package org.mingle.banana.spring.mvc;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.mingle.banana.spring.jdbc.Spittle;
import org.mingle.banana.spring.mvc.service.SpitterService;

public class HomeControllerTest {
	private static final int DEFAULT_SPITTLES_PER_PAGE = 8;

	@Test
	public void shouldDisplayRecentSpittles() {
		List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(),
				new Spittle());

		SpitterService spitterService = mock(SpitterService.class);
		
		when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE))
				.thenReturn(expectedSpittles);

		HomeController controller = new HomeController(spitterService);

		HashMap<String, Object> model = new HashMap<String, Object>();
		String viewName = controller.showHomePage(model);

		assertEquals("home", viewName);

		assertSame(expectedSpittles, model.get("spittles"));
		verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
	}
}

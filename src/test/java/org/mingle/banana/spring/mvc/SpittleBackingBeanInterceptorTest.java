package org.mingle.banana.spring.mvc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ModelMap;

public class SpittleBackingBeanInterceptorTest {
	@Test
	public void shouldPutEmptySpittleObjectInModelInPostHandle()
			throws Exception {
		SpittleBackingBeanInterceptor interceptor = new SpittleBackingBeanInterceptor();
		ModelMap model = new ModelMap();
		interceptor.postHandle(null, model);
		assertNotNull(model.get("spittle"));
	}
}

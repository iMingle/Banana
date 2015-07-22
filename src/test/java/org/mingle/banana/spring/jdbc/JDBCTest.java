package org.mingle.banana.spring.jdbc;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/jdbc/jdbc.xml")
public class JDBCTest {
	@Inject
	private JdbcTemplateSpitterDao hibernateDao;
	@Inject
	private JpaTemplateSpitterDao jpaDao;
//	@Inject
//	private SessionFactory sessionFactory;

	@Test
	public void audienceShouldApplaud() throws Exception {
		System.out.println(hibernateDao.getSpitterById(1));
//		System.out.println(sessionFactory);
//		sessionFactory.getCurrentSession();
		System.out.println(jpaDao.getSpitterById(2));
	}

}

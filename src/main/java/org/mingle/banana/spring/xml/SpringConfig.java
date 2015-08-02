package org.mingle.banana.spring.xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring基于Java的配置
 * 
 * @since 1.8
 * @author Mingle
 */
@Configuration
public class SpringConfig {
	/**
	 * 方法名作为ID
	 * 
	 * @return
	 */
	@Bean
	public Performer duke() {
		return new Juggler();
	}

	@Bean
	public Performer duke15() {
		return new Juggler(15);
	}

	@Bean
	public Performer poeticDuke() {
		return new PoeticJuggler(sonnet());
	}

	@Bean
	public Poem sonnet() {
		return new Sonnet();
	}

	@Bean
	public Performer kenny() {
		Instrumentalist kenny = new Instrumentalist();
		kenny.setSong("Jingle Bells");
		return kenny;
	}

}

package org.mingle.banana.spring.jms;

import org.mingle.banana.spring.jdbc.Spittle;

public interface AlertService {
	void sendSpittleAlert(Spittle spittle);
}

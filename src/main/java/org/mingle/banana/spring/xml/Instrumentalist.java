package org.mingle.banana.spring.xml;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Instrumentalist implements Performer {
	public Instrumentalist() {}

	public void perform() {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}

	private String song;

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public String screamSong() {
		return song;
	}

	@Autowired
	@Qualifier
	private Instrument instrument;
	
	@Inject
	@Named
	private Instrument instrumentInject;
	
	@Resource
	private Instrument instrumentResource;

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}

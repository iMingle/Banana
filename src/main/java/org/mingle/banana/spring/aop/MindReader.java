package org.mingle.banana.spring.aop;

public interface MindReader {
	void interceptThoughts(String thoughts);

	String getThoughts();
}
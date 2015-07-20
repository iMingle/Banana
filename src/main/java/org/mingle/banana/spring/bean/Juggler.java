package org.mingle.banana.spring.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Juggler implements Performer {
	private int beanBags = 3;
	private int[] array;
	private List<String> list;
	private Set<String> set;
	private Map<String, Integer> map;
	private Properties properties;

	public Juggler() {}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	
	/**
	 * 延迟加载
	 */
	private static class JugglerHolder {
		static Juggler instance = new Juggler(100);
	}
	
	public static Juggler getInstance() {
		return JugglerHolder.instance;
	}

	public void perform() throws PerformanceException {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

	public int getBeanBags() {
		return beanBags;
	}

	public void setBeanBags(int beanBags) {
		this.beanBags = beanBags;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Juggler [beanBags=" + beanBags + ", array="
				+ Arrays.toString(array) + ", list=" + list + ", set=" + set
				+ ", map=" + map + ", properties=" + properties + "]";
	}
	
}

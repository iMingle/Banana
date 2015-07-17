package org.mingle.banana.spring.knights;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/knights/knights.xml"); // <co id="co_loadKnightContext"/>

		Knight knight = (Knight) context.getBean("knight"); // <co id="co_getBeanKnight"/>

		knight.embarkOnQuest();// <co id="co_useKnight"/>
		
		Map<String, Boolean> map = new HashMap<String, Boolean>(16);
		Set<String> set = Collections.newSetFromMap(map);
		set.add("Name");
		set.add("Name1");
		set.add("Name2");
		set.add("Name3");
		System.out.println(set);
		System.out.println(map);
	}
}

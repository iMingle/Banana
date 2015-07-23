package org.mingle.banana.spring.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mingle.banana.spring.jdbc.Spittle;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import com.rometools.rome.feed.atom.Entry;

public class SpittlesAtomView extends AbstractAtomFeedView {

	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		@SuppressWarnings("unchecked")
		List<Spittle> spittles = (List<Spittle>) model.get("spittles");
		List<Entry> entries = new ArrayList<Entry>();
		for (Spittle spittle : spittles) {
			Entry entry = new Entry();
			entry.setTitle(spittle.getText());
			entry.setCreated(spittle.getWhen());
			entries.add(entry);
		}

		return entries;
	}
}

package org.mingle.banana.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateSpitterDao extends JdbcTemplate {
	@Inject
	public JdbcTemplateSpitterDao(@Named("dataSource") DataSource dataSource) {
		setDataSource(dataSource);
	}

	private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, update_by_email) values (?, ?, ?, ?, ?)";

	private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ?, set email = ?"
			+ "where id = ?";

	private static final String SQL_SELECT_SPITTER = ""
			+ "select id, username, password, fullname, email from spitter";

	private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER
			+ " where id=?";

	public Spitter getSpitterById(long id) {
		return queryForObject(SQL_SELECT_SPITTER_BY_ID,
				new RowMapper<Spitter>() {
					public Spitter mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Spitter spitter = new Spitter();
						spitter.setId(rs.getLong(1));
						spitter.setUsername(rs.getString(2));
						spitter.setPassword(rs.getString(3));
						spitter.setFullName(rs.getString(4));
						spitter.setEmail(rs.getString(5));
						return spitter;
					}
				}, id);
	}

	public void addSpitter(Spitter spitter) {
		update(SQL_INSERT_SPITTER, spitter.getUsername(),
				spitter.getPassword(), spitter.getFullName(),
				spitter.getEmail(), spitter.isUpdateByEmail());
	}

	public void saveSpitter(Spitter spitter) {
		update(SQL_UPDATE_SPITTER, spitter.getUsername(),
				spitter.getPassword(), spitter.getFullName(),
				spitter.getEmail(), spitter.getId());
	}

}

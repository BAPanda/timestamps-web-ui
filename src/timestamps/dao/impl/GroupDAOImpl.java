package timestamps.dao.impl;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import timestamps.dao.GroupDAO;
import timestamps.models.Group;

public class GroupDAOImpl implements GroupDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Group getByID(BigInteger id) {
		String query = "SELECT \"ID\", \"Name\", \"Address\" FROM \"Group\" WHERE \"ID\" = ?";

		return jdbcTemplate.query(query, new ResultSetExtractor<Group>() {
			@Override
			public Group extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next())
					return new GroupRowMapper().mapRow(rs, 1);
				else
					return null;
			}
		}, id.intValue());
	}

	@Override
	public List<Group> getAll() {
		String query = "SELECT \"ID\", \"Name\", \"Address\" FROM \"Group\"";

		return jdbcTemplate.query(query, new GroupRowMapper());
	}

	@Override
	public void add(Group group) {
		String query = "INSERT INTO \"Group\" (\"ID\", \"Name\", \"Address\") VALUES (?, ?, ?)";
		group.setID(BigInteger.valueOf(new Random().nextLong() % 200));
		
		jdbcTemplate.update(query, group.getID().intValue(), group.getName(), group.getAddress());
	}

	@Override
	public void delete(BigInteger id) {
		String query = "DELETE FROM \"Group\" WHERE \"ID\" = ?";
		
		jdbcTemplate.update(query, id.intValue());
	}

	class GroupRowMapper implements RowMapper<Group> {

		@Override
		public Group mapRow(ResultSet rs, int row) throws SQLException {
			Group g = new Group();

			g.setID(rs.getBigDecimal("ID").toBigInteger());
			g.setAddress(rs.getString("Address"));
			g.setName(rs.getString("Name"));

			return g;
		}

	}

}

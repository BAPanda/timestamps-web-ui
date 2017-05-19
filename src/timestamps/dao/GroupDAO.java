package timestamps.dao;

import java.math.BigInteger;
import java.util.List;

import timestamps.models.Group;

public interface GroupDAO {
	public Group getByID(BigInteger id);
	public List<Group> getAll();
	
	public void add(Group group);
	public void delete(BigInteger id);
}

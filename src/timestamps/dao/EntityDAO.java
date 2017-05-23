package timestamps.dao;

import java.math.BigInteger;
import java.util.List;

import timestamps.models.Entity;

public interface EntityDAO {
	public Entity getByID(BigInteger ID);
	public List<Entity> getAll();
	public Entity getByName(String name);
	public List<Entity> getByGroup(BigInteger ID);
	
	public void add(Entity entity);
	public void delete(BigInteger id);
	public boolean validate(Entity entity);
}

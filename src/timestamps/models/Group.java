package timestamps.models;

import java.math.BigInteger;

public class Group {
	private BigInteger ID;
	private String name;
	private String address;
	
	public BigInteger getID() {
		return ID;
	}
	
	public void setID(BigInteger iD) {
		ID = iD;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}

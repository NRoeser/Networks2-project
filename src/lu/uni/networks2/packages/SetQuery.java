package lu.uni.networks2.packages;

public class SetQuery extends Packet{
	
	private String key;
	
	private String value;

	public SetQuery(int id, String key, String value) {
		super(id);
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public void print() {
		System.out.println("SET: " + id + " : " + key + " : " + value);
	}
	
	

}

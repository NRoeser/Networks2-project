package lu.uni.networks2.packages;

public class GetQuery extends Packet {
	
	private String key;

	public GetQuery(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void print() {
		System.out.println("GET: " + id + " : " + key);
	}
	
	

}

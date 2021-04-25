package lu.uni.networks2.query;

public class GetQuery extends Query {
	
	private String key;

	public GetQuery(int id, String key) {
		super(id);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	

}

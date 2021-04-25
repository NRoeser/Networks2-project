package lu.uni.networks2.packages;

public class GetQuery extends Package {
	
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

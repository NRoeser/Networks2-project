package lu.uni.networks2.packages;

public class GETResponse extends Package {
	
	private String value;
	private String receiverIP;

	public GETResponse(int id, String value, String receiverIP) {
		super(id);
		this.value = value;
		this.receiverIP = receiverIP;
	}

	public String getValue() {
		return value;
	}

	public String getReceiverIP() {
		return receiverIP;
	}
	
	public void print() {
		System.out.println("GETResponse: " + id + " : " + value + " : " + receiverIP);
	}
	

}

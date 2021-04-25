package lu.uni.networks2.packages;

public class GiveConnectionPermission extends Packet{
	
	private String giverIP;
	private String receiverIP;

	public GiveConnectionPermission(int id, String gIP, String rIP) {
		super(id);
		this.giverIP = gIP;
		this.receiverIP = rIP;
	}

	public String getGiverIP() {
		return giverIP;
	}

	public String getReceiverIP() {
		return receiverIP;
	}

	public void print() {
		System.out.println("GCP: " + id + " : " + giverIP + " : " + receiverIP);
	}
	
	
}

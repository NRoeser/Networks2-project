package lu.uni.networks2.packages;

public class DenyConnectionPermission extends Packet {
	
	private String askerIP;

	public DenyConnectionPermission(String aIP) {
		super();
		this.askerIP = aIP;
	}

	public String getAskerIP() {
		return askerIP;
	}
	
	public void print() {
		System.out.println("DCP: " + id + " : " + askerIP);
	}
	
}

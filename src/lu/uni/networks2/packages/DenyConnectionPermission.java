package lu.uni.networks2.packages;

public class DenyConnectionPermission extends Packet {
	
	private String askerIP;

	public DenyConnectionPermission(int id, String aIP) {
		super(id);
		this.askerIP = aIP;
	}

	public String getAskerIP() {
		return askerIP;
	}
	
	public void print() {
		System.out.println("DCP: " + id + " : " + askerIP);
	}
	
}

package lu.uni.networks2.packages;

public class AskConnectPermission extends Packet {
	
	private String ip;

	public AskConnectPermission(String ip) {
		super();
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}
	
	public void print() {
		System.out.println("ACP : " + id + " : " + ip);
	}
	
}

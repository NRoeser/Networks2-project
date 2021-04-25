package lu.uni.networks2.packages;

public class AskConnectPermission extends Package {
	
	private String ip;

	public AskConnectPermission(int id, String ip) {
		super(id);
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}
	
	public void print() {
		System.out.println("ACP : " + id + " : " + ip);
	}
	
}

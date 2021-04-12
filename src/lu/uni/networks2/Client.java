package lu.uni.networks2;

public class Client {
	private String connectedNodeIP = null;
	private String ip;
	
	public Client(String s) {
		ip = s;
	}
	
	public void askUser() {
		boolean ongoing = true;
		while (ongoing) {
			
		}
	}
	
	public void setQuery(String key, String value) {
		
	}
	
	public void getQuery(String key) {
		
	}
	
	public void connect(String ip) {
		if(connectedNodeIP == null) {
			connectedNodeIP = ip;
			System.out.println("Now connected to: " + ip);
		} else {
			System.out.println("Already connected to a node, needs to be disconnected first");
		}
	}
	
	public void disconnect() {
		if (connectedNodeIP == null) {
			System.out.println("Not connected to any node");
		} else {
			connectedNodeIP = null;
			System.out.println("Now disconnected from former node");
		}
	}

	

}

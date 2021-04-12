package lu.uni.networks2;

public class Client {
	private String connectedNodeIP = null;
	private String ip;
	private String port;
	
	public Client(String i, String p) {
		ip = i;
		port = p;
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
	
	private void connect(String ip) {
		if(connectedNodeIP == null) {
			connectedNodeIP = ip;
			System.out.println("Now connected to: " + ip);
		} else {
			System.out.println("Already connected to a node, needs to be disconnected first");
		}
	}
	
	private void disconnect() {
		if (connectedNodeIP == null) {
			System.out.println("Not connected to any node");
		} else {
			connectedNodeIP = null;
			System.out.println("Now disconnected from former node");
		}
	}

	public void setPort(String port) {
		this.port = port;
	}

	

}

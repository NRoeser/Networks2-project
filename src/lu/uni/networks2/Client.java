package lu.uni.networks2;

import lu.uni.main.main;
import lu.uni.networks2.packages.AskConnectPermission;
import lu.uni.networks2.packages.GiveConnectionPermission;
import lu.uni.networks2.packages.Packet;

public class Client {
	private Node connectedNode = null;
	private String ip;
	private String port;
	
	public Client(String i, String p) {
		ip = i;
		port = p;
	}
	
	
	
	public boolean connect(String s) {
		if(connectedNode == null) {
			for (Node n: main.listOfNodes) {
				if (n.getIP().equals(s)) {
					AskConnectPermission asc = new AskConnectPermission(this.getIp());
					Packet permissionResponse = n.connectToClient(this, asc);
					if (permissionResponse.getClass() == GiveConnectionPermission.class){
						connectedNode = n;
						n.connectClient(this);
						System.out.println("Now connected to: " + s);
						return true;
					} else {
						System.out.println("Connection has been denied! ");
						return false;
					}
				}
			}
			System.out.println("No node found with that IP");
		} else {
			System.out.println("Already connected to a node, needs to be disconnected first");
		}
		return false;
	}
	
	public void disconnect() {
		if (connectedNode == null) {
			System.out.println("Not connected to any node");
		} else {
			connectedNode = null;
			System.out.println("Now disconnected from former node");
		}
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIp() {
		return ip;
	}
	
	

	

}

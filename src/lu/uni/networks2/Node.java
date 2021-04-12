package lu.uni.networks2;

import java.util.ArrayList;

public class Node {

	private String IP;
	private String port;
	
	private ArrayList<Node> connectedNodes = new ArrayList<Node>();
	private ArrayList<Client> connectedClients = new ArrayList<Client>();
	//private ArrayList<Query> queryList = new ArrayList<Query>();
	
	public Node(String IP, String port) {
		this.IP = IP;
		this.port = port;
	}
	
	public void setQuery(Query q) {
		
	}
	
	public void getQuery(Query q) {
		
	}
	
	public void connectToNode(Node n) {
		connectedNodes.add(n);
		if(connectedNodes.contains(this)) {
			n.connectToNode(this);
		}
		
	}
	
	public void disconnectFromNode(Node n) {
		connectedNodes.remove(n);
		if(connectedNodes.contains(this)) {
			n.disconnectFromNode(this);
		}
		
	}
	
	public void connectClient(Client c) {
		c.connect(IP);
	}
	
}

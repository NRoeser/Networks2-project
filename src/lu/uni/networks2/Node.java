package lu.uni.networks2;

import java.util.ArrayList;

public class Node {

	private String IP;
	private String port;
	
	private ArrayList<Node> connectedNodes = new ArrayList<Node>();
	private ArrayList<Client> connectedClients = new ArrayList<Client>();
	private ArrayList<Query> queryList = new ArrayList<Query>();
	
	public Node(String IP, String port) {
		this.IP = IP;
		this.port = port;
	}
	
	public void setQuery(Query q) {
		queryList.add(q);
	}
	
	public Query getQuery(String key) {
		
		Query q = null;
		
		for(int i = 0; i<queryList.size();i++) {
			if(queryList.get(i).getKey() == key) {
				q = queryList.get(i);
			}
		}
		
		return q;
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
		connectedClients.add(c);
	}
	
	public void disconnectClient(Client c) {
		c.disconnect();
		connectedClients.remove(c);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

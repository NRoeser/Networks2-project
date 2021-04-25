package lu.uni.networks2;

import java.util.ArrayList;
import lu.uni.networks2.packages.*;


public class Node {

	private String IP;
	private String port;
	
	private ArrayList<Node> connectedNodes = new ArrayList<Node>();
	private ArrayList<Client> connectedClients = new ArrayList<Client>();
	private ArrayList<Packet> queryList = new ArrayList<Packet>();
	
	public Node(String IP, String port) {
		this.IP = IP;
		this.port = port;
	}
	
	
	public void start(ArrayList<Node> nl) {
		if(nl!=null) {
			for(int i = 0; i< nl.size(); i++) {
				if(nl.get(i).getPort()== port) {
					connectToNode(nl.get(i));
					i=nl.size();// only connects to first other node
				}
			}
		}
		
	}
	
	
	public void setQuery(Packet q) {
		queryList.add(q);
		System.out.println("Query has been added");
	}
	
	public Package getQuery(String key) {
		
		Package q = null;
		int c = 0;
		int maxC = connectedNodes.size();
		
		for(int i = 0; i<queryList.size();i++) {
			if(queryList.get(i).getKey().equals(key) && queryList.get(i).getId()== id) {
				q = queryList.get(i);
			}
		}
		while(c<maxC) {
			if(q == null) {
			
				for(int j = 0; j<connectedNodes.size();j++) {
					
					connectedNodes.get(j).getQuery(key,id);
				}
			
			}else {
				c = maxC;
			}
			c++;
		}
		
		
		return q;
	}
	
	
	
	public String getIP() {
		return IP;
	}


	public void connectToNode(Node n) {
		boolean connected=false;
		for(int i = 0; i<connectedNodes.size();i++) {
			if(n == connectedNodes.get(i)) {
				connected = true;
			}
		}
		
		if(connected==false) {
			connectedNodes.add(n);
			if(connectedNodes.contains(this)) {
				n.connectToNode(this);
			}
		}
		
		
	}
	
	public void disconnectFromNode(Node n) {
		connectedNodes.remove(n);
		if(connectedNodes.contains(this)) {
			n.disconnectFromNode(this);
		}
		
	}
	
	public void connectClient(Client c) {
		connectedClients.add(c);
	}
	
	public void disconnectClient(Client c) {
		c.disconnect();
		connectedClients.remove(c);
	}
	
	
	public String getPort() {
		return port;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

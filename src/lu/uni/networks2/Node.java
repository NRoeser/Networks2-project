package lu.uni.networks2;

import java.util.ArrayList;
import java.util.Random;

import lu.uni.networks2.packages.*;


public class Node {

	private String IP;
	private String port;
	private boolean letConnect = true;
	
	private ArrayList<Packet> packetsInNode = new ArrayList<Packet>();
	private ArrayList<Node> connectedNodes = new ArrayList<Node>();
	private ArrayList<Client> connectedClients = new ArrayList<Client>();
	private ArrayList<SetQuery> queryList = new ArrayList<SetQuery>();
	private ArrayList<AskConnectPermission> pastAskConnectPermissions = new ArrayList<AskConnectPermission>();
	
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
	
	
	public void setQuery(SetQuery q) {
		queryList.add(q);
		System.out.println("Query has been added");
	}
	
	
	public Packet connectToClient(Client c, AskConnectPermission asc) {
		pastAskConnectPermissions.add(asc);
		if (letConnect) {
			GiveConnectionPermission gcp = new GiveConnectionPermission(this.getIP(), c.getIp());
			return gcp;
		} else {
			DenyConnectionPermission dcp = new DenyConnectionPermission(c.getIp());
			return dcp;
		}
	}
	
	public SetQuery checkQuery(GetQuery getQ) {
		
		boolean r=false;
		for(SetQuery query:queryList) {
			if(query.getKey().equals(getQ.getKey())) {
				return query;
			}
		}
		
		return null;
	}
	
	public GETResponse getQuery(GetQuery getQ, Client c) {
		
		GETResponse q = null;
		
		if(!packetsInNode.contains(getQ)) {
			packetsInNode.add(getQ);
			SetQuery s = checkQuery(getQ);
			if(s!=null) {
				q = new GETResponse(s.getValue(),c.getIp()); // TODO: Client who asked for it 
				System.out.println("Found query with value: " +s.getValue() +" on node: " +this.IP);
			}else {
				System.out.println("no query found on this node: " +this.IP);
				for(Node conNode:connectedNodes) {
					conNode.getQuery(getQ,c);
					
				}
			}
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

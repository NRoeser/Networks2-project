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
	private ArrayList<GETResponse> temporaryList = new ArrayList<GETResponse>();
	
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
	
	public Client checkClient(GetQuery query) {
		for (Client c: connectedClients) {
			if (c.getListOfGetQuery().contains(query)) {
				return c;
			}
		}
		return null;
	}
	
	
	public void sendGETResponsePacket(ArrayList<Node> pathToClient, GetQuery query) {
		System.out.println("Sending query to Node: " + pathToClient.get(pathToClient.size()-1).getIP());
		int size = pathToClient.size()-1;
		if (pathToClient.size() == 1) {
			Client c = checkClient(query);
			c.getListOfResponses().add(pathToClient.get(0).getTemporaryList().get(0));
			pathToClient.get(0).getTemporaryList().get(0);
			System.out.println("GETResponse has reached its client");
		} else {
			System.out.println("ADDING TO: " + Integer.toString(size-1));
			pathToClient.get(size-1).getTemporaryList().add(pathToClient.get(size).getTemporaryList().get(0));
			pathToClient.get(size).getTemporaryList().remove(0);
			pathToClient.remove(size);
			sendGETResponsePacket(pathToClient, query);
		}
		
	}
	
	public boolean getQuery(GetQuery getQ, ArrayList<Node> pathToClient) {
		if(!packetsInNode.contains(getQ)) {
			packetsInNode.add(getQ);
			pathToClient.add(this);
			SetQuery s = checkQuery(getQ);
			if(s!=null) {
				Client c = pathToClient.get(0).checkClient(getQ);
				GETResponse getR = new GETResponse(s.getValue(),c.getIp());
				pathToClient.get(pathToClient.size()-1).getTemporaryList().add(getR);
				System.out.println("Found query with value: " +s.getValue() +" on node: " +this.IP);
				sendGETResponsePacket(pathToClient, getQ);
				return true;
			}else {
				System.out.println("no query found on this node: " +this.IP);
				for(Node conNode:connectedNodes) {
					conNode.getQuery(getQ, pathToClient);
					
				}
			}
		}
		return false;
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


	public ArrayList<GETResponse> getTemporaryList() {
		return temporaryList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

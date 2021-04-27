package lu.uni.networks2;

import java.util.ArrayList;

import lu.uni.main.main;
import lu.uni.networks2.packages.AskConnectPermission;
import lu.uni.networks2.packages.GETResponse;
import lu.uni.networks2.packages.GetQuery;
import lu.uni.networks2.packages.GiveConnectionPermission;
import lu.uni.networks2.packages.Packet;

public class Client {
	private Node connectedNode = null;
	private String ip;
	private String port;
	private ArrayList<GetQuery> listOfGetQuery = new ArrayList<GetQuery>();
	private ArrayList<GETResponse> listOfResponses = new ArrayList<GETResponse>();

	public Client(String i, String p) {
		ip = i;
		port = p;
	}

	public boolean connect(String s) {
		if (connectedNode == null) {
			for (Node n : main.listOfNodes) {
				if (n.getIP().equals(s)) {
					AskConnectPermission asc = new AskConnectPermission(this.getIp());
					Packet permissionResponse = n.connectToClient(this, asc);
					if (permissionResponse.getClass() == GiveConnectionPermission.class) {
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

	public boolean askNodeForQuery(GetQuery query) {
		ArrayList<Node> pathToClient = new ArrayList<Node>();
		this.listOfGetQuery.add(query);
		return this.connectedNode.getQuery(query, pathToClient);
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Node getConnectedNode() {
		return connectedNode;
	}

	public String getIp() {
		return ip;
	}

	public ArrayList<GetQuery> getListOfGetQuery() {
		return listOfGetQuery;
	}

	public ArrayList<GETResponse> getListOfResponses() {
		return listOfResponses;
	}

}

package lu.uni.main;

import java.util.ArrayList;
import java.util.Scanner;

import lu.uni.networks2.Client;
import lu.uni.networks2.Node;
import lu.uni.networks2.packages.*;
import lu.uni.networks2.packages.Packet;

public class main {
	
	public static ArrayList<Node> listOfNodes = new ArrayList<Node>();
	public static ArrayList<Client> listOfClients = new ArrayList<Client>();
	
	public static void implimentationA() {
		listOfNodes.removeAll(listOfNodes);
		Scanner scanner = new Scanner(System.in);
		Client myClient = new Client("192.158.1.38", "xy");
		Node myNode = new Node("162.130.9.42", "mn");
		listOfNodes.add(myNode);
		myNode.connectClient(myClient);
		System.out.println("Enter the IP address to connect to: ");
		String input = scanner.nextLine();
		while (!myClient.connect(input)) {
			System.out.println("Enter a new IP address to connect to: ");
			input = scanner.nextLine();
		}
		
		System.out.println("Enter a key for SET query: ");
		String keyInput = scanner.nextLine();
		System.out.println("Enter a value for the SET query: ");
		String valueInput = scanner.nextLine();
		SetQuery firstQuery = new SetQuery(keyInput, valueInput);
		myNode.setQuery(firstQuery);
		System.out.println("Enter the key value for the GET query: ");
		String inputKeyQuery = scanner.nextLine();
		while (myNode.getQuery(inputKeyQuery) == null) {
			System.out.println("Wrong key, enter a new one: ");
			inputKeyQuery = scanner.nextLine();
		}
		GETResponse foundQuery = myNode.getQuery(inputKeyQuery);
		System.out.println("Your Query: " + foundQuery.getId() + "; Value: " + foundQuery.getValue());
		scanner.close();
	}
	
	public static void implementationB() {
		listOfNodes.removeAll(listOfNodes);
		Node a = new Node("162.1a1.123","5432");
		Node b = new Node("162.1b1.965","5432");
		Node c = new Node("162.1c1.451","5432");
		Node d = new Node("162.1d1.951","5432");
		Node e = new Node("162.1e1.361","5432");
		Node f = new Node("162.1f1.489","5432");
		Node g = new Node("162.1g1.615","5432");
		Node h = new Node("162.1h1.985","5432");
		Client c1 = new Client("169.121.541","5236");
		Client c2 = new Client("169.131.948","5236");
		
		listOfNodes.add(a);listOfNodes.add(b);listOfNodes.add(c);listOfNodes.add(d);listOfNodes.add(e);listOfNodes.add(f);listOfNodes.add(g);listOfNodes.add(h);
		listOfClients.add(c1);listOfClients.add(c2);
		
		a.connectToNode(b);
		b.connectToNode(f);b.connectToNode(g);
		c.connectToNode(b);
		f.connectToNode(e);f.connectToNode(g);
		g.connectToNode(h);g.connectToNode(d);
		
		c1.connect("162.1b1.965");c2.connect("162.1f1.489");
		
		SetQuery q = new SetQuery("key1","valude");
		a.setQuery(q);
		
		GetQuery q1 = new GetQuery("key1");
		c2.getConnectedNode().getQuery(q1,c2);
		
	}

	public static void main(String[] args) {
		//implimentationA();
		implementationB();
		
		
	}

}

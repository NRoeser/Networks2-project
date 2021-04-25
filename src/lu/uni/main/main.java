package lu.uni.main;

import java.util.ArrayList;
import java.util.Scanner;

import lu.uni.networks2.Client;
import lu.uni.networks2.Node;

public class main {
	
	public static ArrayList<Node> listOfNodes = new ArrayList<Node>();
	
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
		System.out.println("Enter an ID for the query: ");
		int idInput = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter a key for SET query: ");
		String keyInput = scanner.nextLine();
		System.out.println("Enter a value for the SET query: ");
		String valueInput = scanner.nextLine();
		Query firstQuery = new Query(keyInput, valueInput, idInput);
		myNode.setQuery(firstQuery);
		System.out.println("Enter the ID for the GET query: ");
		int inputID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the key value for the GET query: ");
		String inputKeyQuery = scanner.nextLine();
		while (myNode.getQuery(inputKeyQuery) == null) {
			System.out.println("Wrong key, enter a new one: ");
			inputKeyQuery = scanner.nextLine();
		}
		Query foundQuery = myNode.getQuery(inputKeyQuery);
		System.out.println("Your Query: " + foundQuery.getId() + "; "+ foundQuery.getKey() + "; " + foundQuery.getValue());
		scanner.close();
	}

	public static void main(String[] args) {
		implimentationA();
	}

}

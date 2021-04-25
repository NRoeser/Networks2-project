package lu.uni.networks2.query;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Query {

	private static ArrayList<Integer> listOfIDs = new ArrayList<Integer>();
	private int id;
	
	
	public Query(int id) {
		super();
		while (listOfIDs.contains(id)) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Id already exists, enter a new one!");
			id = scanner.nextInt();
			scanner.nextLine();
			scanner.close();
		}
		this.id = id;
		listOfIDs.add(id);
	}

	public int getId() {
		return id;
	}

	
	
	
	
}

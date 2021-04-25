package lu.uni.networks2.packages;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Package {

	private static ArrayList<Integer> listOfIDs = new ArrayList<Integer>();
	protected int id;
	
	
	public Package(int id) {
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
<<<<<<< HEAD:src/lu/uni/networks2/Query.java
	public void setID(int id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	
	public void setValue(String value) {
		this.value = value;
	}
=======

>>>>>>> ebdac320cfae3f73c36518fe9a294f4e435ce790:src/lu/uni/networks2/packages/Package.java
	
	
	
	
}

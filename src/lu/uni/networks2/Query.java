package lu.uni.networks2;

import java.util.ArrayList;
import java.util.Scanner;

public class Query {

	private static ArrayList<Integer> listOfIDs = new ArrayList<Integer>();
	private String key;
	private String value;
	private int id;
	
	
	public Query(String key, String value, int id) {
		super();
		this.key = key;
		this.value = value;
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
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}

package lu.uni.networks2.packages;

import java.util.ArrayList;
import java.util.Scanner;

public class GetQuery extends Packet {
	
	private String key;
	private static ArrayList<String> listOfKeys = new ArrayList<String>();

	public GetQuery(String key) {
		super();
		while (listOfKeys.contains(key)) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Key already exists, enter a new key! ");
			key = scanner.nextLine();
		}
		this.key = key;
		listOfKeys.add(key);
	}

	public String getKey() {
		return key;
	}

	public void print() {
		System.out.println("GET: " + id + " : " + key);
	}
	
	

}

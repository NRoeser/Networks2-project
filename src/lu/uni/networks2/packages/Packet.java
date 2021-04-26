package lu.uni.networks2.packages;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Packet {

	private static ArrayList<Integer> listOfIDs = new ArrayList<Integer>();
	protected int id;
	
	
	public Packet() {
		super();
		this.id = generateID();
		listOfIDs.add(id);
	}

	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public static int generateID() {
		int id;
		Random r = new Random();
		id = r.nextInt(5000);
		while (listOfIDs.contains(id)) {
			id = r.nextInt();
		}
		return id;
	}
	
	
	
	
}

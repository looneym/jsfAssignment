package cans4cash.customer;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	

	private String name;
	private String password;

	
	@Id
	@GeneratedValue
	private int id;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("set name "+name);
		this.name = name;
	}
	public void setPassword(String pass) {
		password = pass;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	@Override
	public String toString() {
		return "Customer name=" + name;
				}
	
}




























//
//
//public class Customer {
//	static int CustomerId=0;
//	private int id;
//	private String name;
//	private String description;
//	private double price;
//	private String imageFile;
//	Customer (Customer p){
//		id=p.id;
//		name=p.name;
//		description=p.getDescription();
//		price=p.getPrice();
//		imageFile=p.imageFile;
//	}
//	Customer (String n, String d, double p,String i){
//		id=CustomerId++;
//		name=n;
//		description=d;
//		price=p;
//		imageFile=i;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	public String getImageFile() {
//		return imageFile;
//	}
//	public void setImageFile(String imageFile) {
//		this.imageFile = imageFile;
//	} 
//	public void Print(){
//	
//		System.out.println(" Customer id = "+ id);
//		System.out.print(" name= "+name);
//		System.out.print(" description= "+description);
//		System.out.print(" price= "+price);
//		System.out.println(" imageFile= "+imageFile);
//	}
//}

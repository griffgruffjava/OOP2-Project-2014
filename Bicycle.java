import java.io.*;  // needed for saving arrays of bicycles to file
/** minimal class which models a bicycle */
public class Bicycle implements Serializable{  // needed for saving
	
	private String owner;
	private double value;
	private String make;
	
	public  Bicycle( String s, double v ){
		owner = s;
		make = "unknown make";
		value = v;
	}
	
	public  Bicycle( String s ){
		owner = s;
		make = "unknown make";
	}
	
	public  Bicycle( ){
		owner = "unassigned";
		make = "unknown make";
	}
	
	public void setOwner(String s){
		owner = s;
	}
	
	public void setMake(String m){
		make = m;
	}
	
	public void setValue(double v){
		value = v;
	}
	
	public String getOwner(){
	  return owner;	
	}
	
	public String getMake(){
	  return make;	
	}
	
	public double getValue(){
	  return value;	
	}
	
	public String toString() {
		return owner + " " + make + " " + value;
	}
}
/**
 * 
 */
package org.cuatrovientos.consolerp.model;

/**
 * @author Aitor Jauregi
 *
 */
public class Product {
	private int id;
	private String name;
	private float price;
	
	
	public Product() {
		
	}

	
	/**
	 * 
	 * @param clave
	 * @param name
	 * @param price
	 */
	public Product(int clave, String name, float price) {
		super();
		this.id = clave;
		this.name = name;
		this.price = price;
	}

	
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
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Product [clave=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
}

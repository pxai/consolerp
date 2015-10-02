/**
 * 
 */
package org.cuatrovientos.consolerp.model;

/**
 * @author Aitor Jauregi
 *
 */
public class Product {
	private int clave;
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
		this.clave = clave;
		this.name = name;
		this.price = price;
	}

	
	public int getClave() {
		return clave;
	}


	public void setClave(int clave) {
		this.clave = clave;
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
		return "Product [clave=" + clave + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
}

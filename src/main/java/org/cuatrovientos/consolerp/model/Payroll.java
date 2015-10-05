/**
 * Created by Bassbeats
 */
package org.cuatrovientos.consolerp.model;

public class Payroll {
	int id;
	String description;
	float gross;
	
	public Payroll(){
		
	}
	
	public Payroll(int id) {
		super();
		this.id = id;
	}

	public Payroll(int id, String description, float gross) {
		super();
		this.id = id;
		this.description = description;
		this.gross = gross;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getGross() {
		return gross;
	}

	public void setGross(float gross) {
		this.gross = gross;
	}

	@Override
	public String toString() {
		return "Payroll [id=" + id + ", description=" + description + ", gross=" + gross + "]";
	}
	
	
	
	
}

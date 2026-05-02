package com.klu.student;

public class Address {
	private String City;
	private String State;
	public void setCity(String City)
	{
		this.City=City;
	}
	public void setState(String State)
	{
		this.State=State;
	}
	@Override
	public String toString()
	{
		return "Address{city='"+City+"',State='"+State+"'}";
	}

}

package com.example.medbuddy.db;

/**
 * child class that help retrieve child data
 * @author hongyu
 *
 */
public class Child {

	/*child index*/
	private long id;
	/*child's name*/
	private String name;
	
	public Child()
	{
		
	}
	/**
	 * get the child index
	 * @return the index
	 */
	public long getId()
	{
		return id;
	}
	/**
	 * set the child index
	 * @param id 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * get child's name
	 * @return child's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name of the child name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return name;
	}
}

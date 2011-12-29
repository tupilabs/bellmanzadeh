package br.com.mackenzie.fuzzy.bellmanzadeh.model;

public class CrispVo
{
	private boolean value;
	private String name;

	/**
	 * @param value
	 * @param name
	 */
	public CrispVo(boolean value, String name)
	{
		super();
		this.value = value;
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param value
	 */
	public CrispVo(boolean value)
	{
		super();
		this.value = value;
	}

	/**
	 * 
	 */
	public CrispVo()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the value
	 */
	public boolean isValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value)
	{
		this.value = value;
	}
	
	
	public String toString()
	{
		return this.name;
	}
	
}

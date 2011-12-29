package br.com.mackenzie.fuzzy.bellmanzadeh.model;

public class TypeVo
{

	public static int LONG 		= 0;
	public static int DOUBLE   	= 1;
	public static int STRING  	= 10;
	public static int BOOLEAN 	= 100;
	
	private String name;
	private int type;
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
	 * @return the type
	 */
	public int getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}
	/**
	 * @param name
	 * @param type
	 */
	public TypeVo(String name, int type)
	{
		super();
		this.name = name;
		this.type = type;
	}
	/**
	 * 
	 */
	public TypeVo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return this.name;
	}
	
	
}

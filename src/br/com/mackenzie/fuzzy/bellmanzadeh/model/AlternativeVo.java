package br.com.mackenzie.fuzzy.bellmanzadeh.model;

public class AlternativeVo
{
	private String name;
	private TypeVo type;	
	
	public AlternativeVo() {
		super();
	}

	/**
	 * @param name
	 * @param type
	 */
	public AlternativeVo(String name, TypeVo type)
	{
		super();
		this.name = name;
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TypeVo getType()
	{
		return type;
	}

	public void setType(TypeVo type)
	{
		this.type = type;
	}
}

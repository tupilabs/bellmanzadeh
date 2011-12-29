package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import java.net.URL;

import javax.swing.ImageIcon;

public abstract class MembershipFunction
{
	
	private String name_;
	private double[] parameters_;
	private double x_;
	private ImageIcon image_;
	
	public MembershipFunction() {
		super();
	}
	
	public MembershipFunction(String name) {
		super();
		this.name_ = name;
	}
	
	public MembershipFunction(String name, ImageIcon image) {
		super();
		this.name_ = name;
		this.image_ = image;
	}
	
	public MembershipFunction(String name, String pathToImage) {
		super();
		this.name_ = name;
		this.image_ = loadImage(pathToImage);
	}
	
	public MembershipFunction(String name, int x, double[] parameters, ImageIcon image) {
		super();
		this.name_ = name;
		this.x_ = x;
		this.parameters_ = parameters;
		this.image_ = image;
	}
	
	public MembershipFunction(int x, double[] parameters) {
		this.x_ = x;
		this.parameters_ = parameters;
	}
	
	public MembershipFunction(int x, double[] parameters, ImageIcon image) {
		this.x_ = x;
		this.parameters_ = parameters;
		this.image_ = image;
	}
	
	public MembershipFunction(int x, double[] parameters, String pathToImage) {
		this.x_ = x;
		this.parameters_ = parameters;
		this.image_ = loadImage(pathToImage);
	}
	
	public ImageIcon loadImage(String path) {
		ImageIcon image = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL url = classLoader.getResource(path);
			image = new ImageIcon(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public abstract double compute();
	
	public double getX() {
		return this.x_;
	}
	
	public void setX(double x) {
		this.x_ = x;
	}
	
	public double[] getParameters() {
		return this.parameters_;
	}
	
	public void setParameters(double[] parameters) {
		this.parameters_ = parameters;
	}
	
	public void showChart() {}
	
	public ImageIcon getImage() {
		return this.image_;
	}
	
	public void setImage(ImageIcon image) {
		this.image_ = image;
	}
	
	public void setImage(String pathToImage) {
		this.image_ = loadImage(pathToImage);
	}
	
	public void setName(String name) {
		this.name_ = name;
	}
	
	public String getName() {
		return this.name_;
	}
	
	public String toString() {
		return this.getName();
	}
}

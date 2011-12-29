package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class TriangularMembershipFunction extends MembershipFunction{

	public TriangularMembershipFunction() {
		super();
	}
	
	public TriangularMembershipFunction(String pathToImage) {
		super("trimf", pathToImage);
	}
	
	public TriangularMembershipFunction(int x, double[] parameters) {
		super(x, parameters);
	}
	
	public double compute() {
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];
		double c = this.getParameters()[2];
		
		return Math.max(Math.min( (getX()-a)/(b-a) , (c-getX())/(c-b) ), 0);
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("trimf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"TRIMF CHART",
				"X",
				"Y",
				data,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		ChartPanel panel = new ChartPanel(chart);
		RunForm.runPanel(panel);
	}
	
	public static void main(String[] args) {
		TriangularMembershipFunction mf = new TriangularMembershipFunction();
		mf.setParameters(new double[]{3, 6, 8});
		mf.showChart();
	}	
}

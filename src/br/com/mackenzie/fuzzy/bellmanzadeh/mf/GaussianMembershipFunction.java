package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class GaussianMembershipFunction extends MembershipFunction
{
	
	public GaussianMembershipFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public GaussianMembershipFunction(String pathToImage) {
		super("gmf", pathToImage);
	}
	
	public double compute()
	{
		double sigma = this.getParameters()[0];
		double c = this.getParameters()[1];
		double e = Math.E;
				
		return (
					Math.pow(
							e,
							- ( Math.pow( ( getX()-c ) , 2 ) ) 
							/
							( 2 * Math.pow(sigma, 2) )
					)
				); // cruzes
		
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("gaussmf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"GAUSSMF CHART",
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
	
	public static void main(String[] args)
	{
		GaussianMembershipFunction mf = new GaussianMembershipFunction();
		mf.setParameters(new double[]{2, 5});
		mf.showChart();
	}
}

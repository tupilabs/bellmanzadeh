package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class SShapedMembershipFunction extends MembershipFunction
{

	public SShapedMembershipFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public SShapedMembershipFunction(String pathToImage) {
		super("smf", pathToImage);
	}
	
	public double compute()
	{
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];
		double e = Math.E;
				
		return (
					1 
					/
					(  1+ (b*Math.pow(e, -(a*getX()) ))  )
				); // cruzes
		
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("smf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"SMF CHART",
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
		SShapedMembershipFunction mf = new SShapedMembershipFunction();
		mf.setParameters(new double[]{1,8});
		mf.showChart();
	}
	
}

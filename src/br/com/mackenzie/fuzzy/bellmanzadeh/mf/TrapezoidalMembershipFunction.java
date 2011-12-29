package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class TrapezoidalMembershipFunction extends MembershipFunction
{
	
	public TrapezoidalMembershipFunction()
	{
		// TODO Auto-generated constructor stub
	}
	
	public TrapezoidalMembershipFunction(String pathToImage)
	{
		super("trapmf", pathToImage);
	}
	
	public double compute()
	{
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];
		double c = this.getParameters()[2];
		double d = this.getParameters()[3];

		double min1 = Math.min( (getX()-a)/ (b-a) , 1);
		double min2 = Math.min( min1, (d-getX())/(d-c) );
		
		return Math.max( min2, 0);
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("trapmf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"TRAPMF CHART",
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
		TrapezoidalMembershipFunction mf = new TrapezoidalMembershipFunction();
		mf.setParameters(new double[]{1, 5, 7, 8});
		mf.showChart();
	}

}

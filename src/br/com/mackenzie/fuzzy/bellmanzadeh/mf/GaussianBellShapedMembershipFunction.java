package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class GaussianBellShapedMembershipFunction extends MembershipFunction
{
	
	public GaussianBellShapedMembershipFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public GaussianBellShapedMembershipFunction(String pathToImage) {
		super("gbellmf", pathToImage);
	}
	
	public double compute()
	{
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];
		double c = this.getParameters()[2];
				
		return (
					1
					/
					(
						1+
						Math.pow(
							(
								Math.abs((getX() - c) / a)
							)
							,
							(2*b)
						)
					)
				); // cruzes
		
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("gbellmf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"GBELLMF CHART",
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
		GaussianBellShapedMembershipFunction mf = new GaussianBellShapedMembershipFunction();
		mf.setParameters(new double[]{2, 4, 6});
		mf.showChart();
	}
}

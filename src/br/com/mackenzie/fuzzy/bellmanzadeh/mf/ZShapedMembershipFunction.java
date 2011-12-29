package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class ZShapedMembershipFunction extends MembershipFunction
{

	public ZShapedMembershipFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public ZShapedMembershipFunction(String pathToImage) {
		super("zmf", pathToImage);
	}
		
	public double compute()
	{
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];

		if ((double) getX() <= (double) a)
		{
			return 1;
		} else if ((a <= getX()) && (getX() <= ((a + b) / 2)))
		{
			return (1 - (2 * Math.pow(((getX() - a) / (b - a)), 2)));
		} else if (((a + b) / 2) <= getX() && (getX() <= b))
		{
			return (2 * Math.pow((b - getX()) / (b - a), 2));
		} else if (getX() >= b)
		{
			return 0;
		}

		return 0;
	}

	public void showChart()
	{
		XYSeries series = new XYSeries("zmf(x, "
				+ this.getParameters().toString() + ")");
		for (double x = 0; x < 10; x += 0.1)
		{
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart("ZMF CHART", "X",
				"Y", data, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(chart);
		RunForm.runPanel(panel);
	}

	public static void main(String[] args)
	{
		ZShapedMembershipFunction mf = new ZShapedMembershipFunction();
		mf.setParameters(new double[] { 3, 7 });
		mf.showChart();
	}

}
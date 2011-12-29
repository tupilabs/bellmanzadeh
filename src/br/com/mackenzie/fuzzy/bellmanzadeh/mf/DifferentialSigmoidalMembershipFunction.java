package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class DifferentialSigmoidalMembershipFunction extends MembershipFunction
{
	
	public DifferentialSigmoidalMembershipFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public DifferentialSigmoidalMembershipFunction(String pathToImage) {
		super("dsigmf", pathToImage);
	}

	public double compute()
	{
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];
		
		double c = this.getParameters()[2];
		double d = this.getParameters()[3];
		
		double e = Math.E;
				
		double f1 =  (
					1 
					/
					(1+ (
							Math.pow(e, - ( a * (getX()-b) ))))
				); // cruzes
		
		double f2 =  (
				1 
				/
				(1+ (
						Math.pow(e, - ( c * (getX()-d) ))))
			); // cruzes
		
		return f1-f2;
		
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("dsigmf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"DSIGMF CHART",
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
		DifferentialSigmoidalMembershipFunction mf = new DifferentialSigmoidalMembershipFunction();
		mf.setParameters(new double[]{5, 2, 5, 7});
		mf.showChart();
	}
	
}

package br.com.mackenzie.fuzzy.bellmanzadeh.mf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

/**
 * 
 * @author 12006024 - Kinoshita, Bruno
 * @deprecated
 */
public abstract class PiShapedMembershipFunction extends MembershipFunction
{

	private PiShapedMembershipFunction(){};
	public double compute()
	{
		double a = this.getParameters()[0];
		double b = this.getParameters()[1];
		double c = this.getParameters()[2];
		double d = this.getParameters()[3];
		double e = Math.E;
			
		if(b <= getX() && getX() <= c) {
			return 1;
		} else if(a>=getX()) {
			return 0;
		}  else if(getX()>=d) {
			return 0;
		} else if(a<=getX() && getX()<=b) {
			return (1/(1+(Math.pow(e, - ( a * (getX()-b) )))));
		}
		
		/*double f1=  (1/(1+(Math.pow(e, - ( a * (getX()-b) ))))); // cruzes
		double f2=  (1/(1+(Math.pow(e, - ( c * (getX()-d) ))))); // cruzes
		
		return f1/f2;*/
		return 0;
	}
	
	public void showChart()
	{
		XYSeries series = new XYSeries("pimf(x, "+ this.getParameters().toString() +")");
		for(double x = 0; x < 10; x+=0.1) {
			this.setX(x);
			series.add(x, this.compute());
		}
		XYSeriesCollection data = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"PIMF CHART",
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
		/*PiShapedMembershipFunction mf = new PiShapedMembershipFunction();
		mf.setParameters(new double[]{1,4,5,10});
		mf.showChart();*/
	}
	
}

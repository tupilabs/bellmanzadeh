package br.com.mackenzie.fuzzy.bellmanzadeh.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MembershipFunctionHelper {

	public static double[] parseParameters(String value) {
		ArrayList temp = new ArrayList();
		StringTokenizer tokenizer = new StringTokenizer(value, " ,");
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			temp.add(token);
		}

		double[] array = new double[temp.size()];
		Iterator iter = temp.iterator();
		int index = 0;
		while(iter.hasNext()) {
			array[index] = Double.parseDouble(iter.next().toString());
			index++;
		}
		
		return array;
	}

	public static void main(String[] args) {
		String s = new String("1 2 3 4 5");
		double[] d = MembershipFunctionHelper.parseParameters(s);
		
		for(int i = 0 ; i < d.length ; ++i ) {
			 System.out.println(d[i]);
		}
	}	
	
}

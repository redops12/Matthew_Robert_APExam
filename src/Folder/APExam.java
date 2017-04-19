package Folder;

import java.awt.Canvas;
import java.util.Scanner;

import javax.swing.JFrame;

public class APExam extends Canvas {
    
    static int width = 256;
    static int height = 144;
    static int scale = 3;
    double answer, comp;
    
	private void thing(double x, double y) {
    	if (comp == 1) {
    		System.out.println(add(x, y));
    	} else if (comp == 2) {
    		System.out.println(subtract(x, y));
    	} else if (comp == 3){
    		System.out.println(multiply(x, y));
    	} else if (comp == 4) {
    		System.out.println(divide(x, y));
    	} else if (comp == 5) {
    		System.out.println(exponentialMultiplication(x,y));
    	} else if (comp == 6){
    		System.out.println(radicals(x,y));
    	}
	}
    
	private double add(double x, double y) {
    	answer = x + y;
    	return answer;
	}
    
	private double subtract(double x, double y) {
    	answer = x - y;
    	return answer;
	}
    
	private double multiply(double x, double y) {
    	answer = x * y;
    	return answer;
	}
    
	private double divide(double x, double y) {
    	answer = x / y;
    	return answer;
	}
	
	private double radicals(double x, double y) {
		double a = 1;
		double ai = 0;
		double incri = 1;
		while (!(((ai-x<0) && (ai-x>-0.000000001)) || ((ai-x>0) && (ai-x<0.000000001)))) {
			ai = exponentialMultiplication(a,y);
			if (ai < x){
				a = a+incri;
			} else if (ai > x){
				a = a-incri;
				incri = incri/10.0;
			}
			System.out.println(a);
		}
		a = Math.floor(a * 100000000) / 100000000;
		answer = a;
		return answer;
	}
    
	private double exponentialMultiplication(double x, double y) {
    	double a = x;
    	long ipart = (long) y;
    	y = y - ipart;
    	if (ipart>1) {
    		for (int i = 0; i < ipart-1; i++) {
    			a = a * x;
    		}
    	} else if (ipart<0) {
    		a = 1;
    		for (int i = 0; i > ipart; i--) {
    			a = a / x;
    		}
    	} else if(ipart==0.0) {
    		a = 1;
    	} 
    	if (y<0){
    		for (double i = 0; i > y; i = i-0.0000001) {
    			a = a / radicals(x,10000000);
    		}
    	} else if (y>0){
    		for (double i = 0; i < y; i = i+0.0000001) {
    			a = a * radicals(x,10000000);
    		}
    	}
    	answer = a;
    	return answer;
	}
    
	public static void main(String[] args) {
    	APExam main = new APExam();
    	JFrame frame = new JFrame();
    	Scanner scanner = new Scanner(System.in);
    	double x, y;
    	x = scanner.nextDouble();
    	y = scanner.nextDouble();
    	main.comp = scanner.nextDouble();
    	//String comp;
   	 
    	frame.add(main);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	frame.setSize(width * scale, height * scale);
    	frame.pack();
   	 
    	main.thing(x, y);
	}
    
}



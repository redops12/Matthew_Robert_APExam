package Folder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APExam {
        double answer, comp;
        
	private void centralProcessor(double x, double y) {
    	if (comp == 1) {
    		System.out.println("adding");
    		System.out.println(add(x, y));
    	} else if (comp == 2) {
    		System.out.println("subtracting");
    		System.out.println(subtract(x, y));
    	} else if (comp == 3){
    		System.out.println("multiplying");
    		System.out.println(multiply(x, y));
    	} else if (comp == 4) {
    		System.out.println("dividing");
    		System.out.println(divide(x, y));
    	} else if (comp == 5) {
    		System.out.println("exponential");
    		System.out.println(expo(x,y));
    	} else if (comp == 6) {
    		System.out.println("radical");
    		System.out.println(radicals(x,y));
    	} else if (comp == 7) {
    		System.out.println("prime factor");
    		System.out.println(primeFactor(x,0));
  		} else if(comp == 9) {
    		System.out.println("converting decimal to fraction");
  			int[] frac = new int[2];
  			frac = decToFrac(x,y);
    		System.out.println(frac[0]+"/"+frac[1]);
    	} else if (comp == 8) {
    		System.out.println(sin((int) x, 0));
    	} else if (comp == 10) {
    		System.out.println("greatest common factor");
    		System.out.println(gcf((int) x, (int) y));
    	}
	}
    
	private double add(double x, double y) {
    	answer = x + y;
    	answer = Math.round(answer*10000000)/10000000.0;
    	return answer;
	}
    
	private double subtract(double x, double y) {
    	answer = x - y;
    	answer = Math.round(answer*10000000)/10000000.0;
    	return answer;
	}
    
	private double multiply(double x, double y) {
    	answer = x * y;
    	answer = Math.round(answer*10000000)/10000000.0;
    	return answer;
	}
    
	private double divide(double x, double y) {
    	answer = x / y;
    	answer = Math.round(answer*10000000)/10000000.0;
    	return answer;
	}
	
	private double radicals(double x, double y) {
		double a = 1;
		double ai = 0;
		double incri = 1;
		while (!(((ai-x<0) && (ai-x>-0.0000000001)) || ((ai-x>0) && (ai-x<0.0000000001)) || ai==x)) {
			ai = 1;
    		for (int i = 0; i < y; i++) {
    			ai = ai * a;
    		}
			if (ai < x){
				a = a+incri;
			} else if (ai > x){
				a = a-incri;
				incri = incri/10.0;
			}
		}
		a = Math.floor(a * 100000000) / 100000000;
		answer = a;
		return answer;
	}
	
	List<Integer> factors = new ArrayList<Integer>();
	private List<Integer> primeFactor(double x, double y) {
		factors.clear();
		for (int i = 2; i <= x/2; i++){
			double tempx = x/i;
			if (tempx == (int)tempx) {
				factors.add(i);
				x = tempx;
				//System.out.println(x);
				i--;
			}
		}
		factors.add((int)x);
		return factors;
	}
	
	List<Integer> factorsA = new ArrayList<Integer>();
	private List<Integer> primeFactorA(double x, double y) {
		factorsA.clear();
		for (int i = 2; i <= x/2; i++){
			double tempx = x/i;
			if (tempx == (int)tempx) {
				factorsA.add(i);
				x = tempx;
				//System.out.println(x);
				i--;
			}
		}
		factorsA.add((int)x);
		return factorsA;
	}
	
	List<Integer> factors1 = new ArrayList<Integer>();
	List<Integer> factors2 = new ArrayList<Integer>();
	List<Integer> outcome = new ArrayList<Integer>();
	private int gcf(int x, int y) {
		factors1.clear();
		factors2.clear();
		outcome.clear();
		primeFactor(x, 0);
		factors1 = factors;
		//System.out.println(factors1.size());
		//System.out.println();
		
		primeFactorA(y, 0);
		factors2 = factorsA;
		for (int a = 0; a < factors1.size(); a++) {
			for (int b = 0; b < factors2.size(); b++) {
				if (factors1.get(a) == factors2.get(b)) {
					//System.out.println(factors1.get(a));
					outcome.add(factors1.get(a));
					factors1.remove(a);
					factors2.remove(b);
				}
			}
		}
		//System.out.println();
		//System.out.println(outcome);
		int result = 1;
		for (int c = 0; c < outcome.size(); c++) {
			result *= outcome.get(c);
		}
		if (x==y){
			result = x;
		}
		//System.out.println();
		return result;
	}
	
	private int[] decToFrac(double x, double y){
		double numer = 1;
		double denom = 1;
		int i = 1;
		while (divide((int) numer,(int) denom)!=x){
			denom = i*1/x;
			if (denom == (int) denom) {				
				numer = i;
			}
			i++;
		}
		int[] frac = new int[2];
		frac[0] = (int) numer;
		frac[1] = (int) denom;
		return frac;
	}
    
	private double expo(double x, double y) {
    	double a = x;
    	int ipart = (int) y;
    	if (ipart>0){
    		y = subtract(y,ipart);    		
    	} else if (ipart<0) {
    		y = y + ipart;
    	} if (ipart==0){
    		a = 1;
    	}
    	if (ipart>1) {
    		for (int i = 0; i < ipart-1; i++) {
    			a = a * x;
    		}
    	} else if (ipart<0) {
    		a = 1;
    		for (int i = 0; i > ipart; i--) {
    			a = a / x;
    		}
    	}
    	if (y<0.0){
    		y = y*-1;
    		int[] frac = new int[2];
    		frac = decToFrac(y,0);
    		for (int g = 0; g < frac[0]; g++){
    			a = a/radicals(x,frac[1]);
    		}
    	} else if (y>0.0){
    		int[] frac = new int[2];
    		frac = decToFrac(y,0);
    		for (int g = 0; g < frac[0]; g++){
    			a = a*radicals(x,frac[1]);
    		}
    	} if(ipart==0.0 && y==0.0) {
    		a = 1;
    	} 
    	answer = Math.round(a*100000)/100000.0;
    	return answer;
	}

	
	private int sin(int ang, int y) {
		int[] sinValues = {12, 13, 14};
		return sinValues[ang - 1];
	}
    
	public static void main(String[] args) {
    	APExam main = new APExam();
    	int u = 0;
    	while (u == 0) {
    		Scanner scanner = new Scanner(System.in);

	    	double x, y;

	        x = scanner.nextDouble();
	        y = scanner.nextDouble();
	        main.comp = scanner.nextDouble();
	        
	    	main.centralProcessor(x, y);
    	}
	}
    
}

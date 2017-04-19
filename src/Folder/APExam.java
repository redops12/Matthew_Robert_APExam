package Folder;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class APExam extends Canvas {
    
    static int width = 256;
    static int height = 144;
    static int scale = 3;
    double answer, comp;
    
    private JPanel window = new JPanel();
	private JButton zero, one, two, three, four, five, six, seven, eight, nine, addition, subtraction;
	private Rectangle rzero, rone, rtwo, rthree, rfour, rfive, rsix, rseven, reight, rnine, raddition, rsubtraction;
	protected int buttonWidth = 60;
	protected int buttonHeight = 30;
    
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
	
	private void drawButtons(String name, JButton button, Rectangle rect, int x, int y, final int id) {
    	button = new JButton(name);
        rect = new Rectangle(x, y, buttonWidth, buttonHeight);
        button.setBounds(rect);
        window.add(button);
        
        button.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			int a = 0;
        			int b = 0;
        			if (id == 1) {
        				System.out.println("Button One!");
        				a = 1;
        				System.out.println(a);
        			} else if (id == 2) {
        				System.out.println("Button Two!");
        				b = 2;
        				System.out.println(b);
        			} else if (id == 3) {
        				System.out.println("Button Three!");
        				
        			} else if (id == 4) {
        				System.out.println("Button Four!");
        				
        			} else if (id == 5) {
        				System.out.println("Button Five!");
        				
        			} else if (id == 6) {
        				System.out.println("Button Six!");
        				
        			} else if (id == 7) {
        				System.out.println("Button Seven!");
        				
        			} else if (id == 8) {
        				System.out.println("Button Eight!");
        				
        			} else if (id == 9) {
        				System.out.println("Button Nine!");
        				
        			} else if (id == 0) {
        				System.out.println("Button Zero!");
        				
        			} else if (id == 10) {
        				System.out.println("Add!");
        				comp = 1;
        				thing(a, b);
        				
        			} else if (id == 110) {
        				System.out.println("Subtract!");
        				
        			}
        		}
        });
        
    }
    
	public static void main(String[] args) {
    	APExam main = new APExam();
    	Scanner scanner = new Scanner(System.in);
    	double x, y;
    	//String comp;
   	 
    	JFrame frame = new JFrame();//original code named this "FrameDemo" as a string parameter
        frame.setPreferredSize(new Dimension(width * scale, height * scale));//not in original code, used to set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(main.window);
        frame.pack();
        frame.setVisible(true);
        main.window.setLayout(null);
        
        main.drawButtons("1", main.one, main.rone, 12, 12, 1);
        main.drawButtons("2", main.two, main.rtwo, 12, 54, 2);
        main.drawButtons("3", main.three, main.rthree, 12, 96, 3);
        main.drawButtons("4", main.four, main.rfour, 84, 12, 4);
        main.drawButtons("5", main.five, main.rfive, 84, 54, 5);
        main.drawButtons("6", main.six, main.rsix, 84, 96, 6);
        main.drawButtons("7", main.seven, main.rseven, 156, 12, 7);
        main.drawButtons("8", main.eight, main.reight, 156, 54, 8);
        main.drawButtons("9", main.nine, main.rnine, 156, 96, 9);
        main.drawButtons("0", main.zero, main.rzero, 84, 138, 0);
        main.drawButtons("+", main.addition, main.raddition, 228, 12, 10);
        main.drawButtons("-", main.subtraction, main.rsubtraction, 228, 54, 11);
   	 
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        main.comp = scanner.nextDouble();
        
    	main.thing(x, y);
	}
    
}



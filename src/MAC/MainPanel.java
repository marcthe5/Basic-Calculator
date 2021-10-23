package MAC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;



/* Developer: MAC
 * Date Develop: 10/8/21
 */
public class MainPanel extends JFrame {
	
	
	static MainPanel frame = new MainPanel();
	
	protected static JLabel Result;
	//FIELDS
	
	//Result
	protected String output;
	protected char equals;
    
	//Operands
	protected int keypad1;
	protected int keypad2;
	protected int keypad3;
	protected int keypad4;
	protected int keypad5;
	protected int keypad6;
	protected int keypad7;
	protected int keypad8;
	protected int keypad9;
	protected int keypad0;
	protected String keypadDec;
	protected String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
	
	//Operands - new instance
	protected String key1;
	protected String key2;
	protected String key3;
	protected String key4;
	protected String key5;
	protected String key6;
	protected String key7;	
	protected String key8;
	protected String key9;
	protected String key0;
	
	//Operators
	protected String Csum;
	protected String Csub;
	protected String Cmult;
	protected String Cdiv;
	protected String[] operators = {"-", "+", "x", "/"};
	
	//Result 
	protected String res;
	protected int operand_1;
	protected int operand_2;
	protected double DoubleOperand_1;
	protected double DoubleOperand_2;
	protected int nums;
	protected int operatorIndex;
	protected static String OP;
	
	//Output-Inputs
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> firstOperands = new ArrayList<String>();
	ArrayList<String> secondOperands = new ArrayList<String>();
    protected String next;
    protected String firstOPS;
    protected String secondOPS;

	
	//listChecking
    protected boolean listProceed = false;

	GetSet gs = new GetSet();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPanel() {

		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(0, 0, 433, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
	    Result = new JLabel("New label");
		Result.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		Result.setBounds(4, 11, 424, 76);
		Result.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(Result);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(1, 98, 431, 3);
		contentPane.add(separator);
		
		JButton btnClose_1 = new JButton("CLOSE");
		btnClose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnClose_1.setForeground(Color.WHITE);
		btnClose_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnClose_1.setFocusPainted(false);
		btnClose_1.setBackground(new Color(128, 0, 0));
		btnClose_1.setBounds(35, 144, 359, 32);
		contentPane.add(btnClose_1);
		
		JButton bttn_reset = new JButton("RESET");
		bttn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.clear();
				Result.setText(null);
				
			}
		});
		bttn_reset.setForeground(Color.WHITE);
		bttn_reset.setFont(new Font("Segoe UI", Font.BOLD, 26));
		bttn_reset.setFocusPainted(false);
		bttn_reset.setBackground(Color.DARK_GRAY);
		bttn_reset.setBounds(35, 106, 359, 32);
		contentPane.add(bttn_reset);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		separator_1.setBackground(new Color(128, 0, 0));
		separator_1.setBounds(0, 182, 431, 3);
		contentPane.add(separator_1);
		
		JButton sum = new JButton("+");
		sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OP = "+";
				Csum = (sum.getLabel());
				list.add(String.valueOf(Csum));
				Csum = list.toString();
				Csum = Csum.substring(1, Csum.length() - 1);
				Csum = String.valueOf(Csum.replaceAll(" ",""));
				Csum = String.valueOf(Csum.replaceAll(",",""));
				
				Result.setText(Csum);
				
	
				
			}
		});
		sum.setForeground(new Color(255, 255, 255));
		sum.setBackground(Color.DARK_GRAY);
		sum.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		sum.setFocusPainted(false);
		sum.setFont(new Font("Segoe UI", Font.BOLD, 40));
		sum.setBounds(334, 290, 89, 94);
		contentPane.add(sum);
		
		JButton mult = new JButton("x");
		mult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OP = "x";
				Cmult = (mult.getLabel());
				list.add(String.valueOf(Cmult));
				Cmult = list.toString();
				Cmult = Cmult.substring(1, Cmult.length() - 1);
				Cmult = String.valueOf(Cmult.replaceAll(" ",""));
				Cmult = String.valueOf(Cmult.replaceAll(",",""));
				
				Result.setText(Cmult);
				
				
			}
		});
		mult.setForeground(new Color(255, 255, 255));
		mult.setFont(new Font("Segoe UI", Font.BOLD, 44));
		mult.setFocusPainted(false);
		mult.setBackground(Color.DARK_GRAY);
		mult.setBounds(334, 190, 89, 97);
		contentPane.add(mult);
		
		JButton div = new JButton("/");
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OP = "/";
				Cdiv = (div.getLabel());
				list.add(String.valueOf(Cdiv));
				Cdiv = list.toString();
				Cdiv = Cdiv.substring(1, Cdiv.length() - 1);
				Cdiv = String.valueOf(Cdiv.replaceAll(" ",""));
				Cdiv = String.valueOf(Cdiv.replaceAll(",",""));
				
				Result.setText(Cdiv);
			}
		});
		div.setForeground(new Color(255, 255, 255));
		div.setFont(new Font("Segoe UI", Font.BOLD, 34));
		div.setFocusPainted(false);
		div.setBackground(Color.DARK_GRAY);
		div.setBounds(242, 190, 89, 97);
		contentPane.add(div);
		
		JButton sub = new JButton("-");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OP = "-";
				Csub = (sub.getLabel());
				list.add(String.valueOf(Csub));
				Csub = list.toString();
				Csub = Csub.substring(1, Csub.length() - 1);
				Csub = String.valueOf(Csub.replaceAll(" ",""));
				Csub = String.valueOf(Csub.replaceAll(",",""));
				
				Result.setText(Csub);
			}
		});
		sub.setForeground(new Color(255, 255, 255));
		sub.setFont(new Font("Segoe UI", Font.BOLD, 44));
		sub.setFocusPainted(false);
		sub.setBackground(Color.DARK_GRAY);
		sub.setBounds(242, 290, 89, 94);
		contentPane.add(sub);
		
		JButton num1 = new JButton("1");
		num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad1 = Integer.parseInt(num1.getLabel());
				//list.add(Integer.valueOf(keypad2));
				list.add(String.valueOf(keypad1));
			
				key1 = list.toString();
				key1 = key1.substring(1, key1.length() - 1);
				key1 = String.valueOf(key1.replaceAll(" ",""));
				key1 = String.valueOf(key1.replaceAll(",",""));
				
				Result.setText(key1);
			}
		});
		
		JButton decimal_bttn = new JButton(".");
		decimal_bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keypadDec = decimal_bttn.getLabel();
				list.add(String.valueOf(keypadDec));
			
				keypadDec = list.toString();
				keypadDec = keypadDec.substring(1, keypadDec.length() - 1);
				keypadDec = String.valueOf(keypadDec.replaceAll(" ",""));
				keypadDec = String.valueOf(keypadDec.replaceAll(",",""));
				
				Result.setText(keypadDec);
				
			}
		});
		decimal_bttn.setBorder(null);
		decimal_bttn.setFont(new Font("Segoe UI", Font.BOLD, 34));
		decimal_bttn.setFocusPainted(false);
		decimal_bttn.setBackground(SystemColor.menu);
		decimal_bttn.setBounds(354, 394, 69, 59);
		contentPane.add(decimal_bttn);
		num1.setBorder(null);
		num1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num1.setFocusPainted(false);
		num1.setBackground(SystemColor.menu);
		num1.setBounds(9, 190, 69, 59);
		contentPane.add(num1);
		
		JButton num2 = new JButton("2");
		num2.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				keypad2 = Integer.parseInt(num2.getLabel());
				list.add(String.valueOf(keypad2));
			
				key2 = list.toString();
				key2 = key2.substring(1, key2.length() - 1);
				key2 = String.valueOf(key2.replaceAll(" ",""));
				key2 = String.valueOf(key2.replaceAll(",",""));
				
				Result.setText(key2);
                
				
			}
			
		}
		);
		
			num2.setBorder(null);
			num2.setFont(new Font("Segoe UI", Font.BOLD, 34));
			num2.setFocusPainted(false);
			num2.setBackground(SystemColor.menu);
			num2.setBounds(87, 190, 69, 59);
			contentPane.add(num2);
		
		JButton num3 = new JButton("3");
		num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keypad9 = Integer.parseInt(num3.getLabel());
			list.add(String.valueOf(keypad9));
		
			key3 = list.toString();
			key3 = key3.substring(1, key3.length() - 1);
			key3 = String.valueOf(key3.replaceAll(" ",""));
			key3 = String.valueOf(key3.replaceAll(",",""));
			
			Result.setText(key3);
			}
		});
		num3.setBorder(null);
		num3.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num3.setFocusPainted(false);
		num3.setBackground(SystemColor.menu);
		num3.setBounds(165, 190, 69, 59);
		contentPane.add(num3);
		
		JButton num4 = new JButton("4");
		num4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad4 = Integer.parseInt(num4.getLabel());
				list.add(String.valueOf(keypad4));
			
				key4 = list.toString();
				key4 = key4.substring(1, key4.length() - 1);
				key4 = String.valueOf(key4.replaceAll(" ",""));
				key4 = String.valueOf(key4.replaceAll(",",""));
				
				Result.setText(key4);
			}
		});
		num4.setBorder(null);
		num4.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num4.setFocusPainted(false);
		num4.setBackground(SystemColor.menu);
		num4.setBounds(9, 257, 69, 59);
		contentPane.add(num4);
		
		JButton num5 = new JButton("5");
		num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad5 = Integer.parseInt(num5.getLabel());
				list.add(String.valueOf(keypad5));
			
				key5 = list.toString();
				key5 = key5.substring(1, key5.length() - 1);
				key5 = String.valueOf(key5.replaceAll(" ",""));
				key5 = String.valueOf(key5.replaceAll(",",""));
				
				Result.setText(key5);
			}
		});
		num5.setBorder(null);
		num5.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num5.setFocusPainted(false);
		num5.setBackground(SystemColor.menu);
		num5.setBounds(87, 257, 69, 59);
		contentPane.add(num5);
		
		JButton num6 = new JButton("6");
		num6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad6 = Integer.parseInt(num6.getLabel());
				list.add(String.valueOf(keypad6));
			
				key6 = list.toString();
				key6 = key6.substring(1, key6.length() - 1);
				key6 = String.valueOf(key6.replaceAll(" ",""));
				key6 = String.valueOf(key6.replaceAll(",",""));
				
				Result.setText(key6);
			}
		});
		num6.setBorder(null);
		num6.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num6.setFocusPainted(false);
		num6.setBackground(SystemColor.menu);
		num6.setBounds(165, 257, 69, 59);
		contentPane.add(num6);
		
		JButton num9 = new JButton("9");
		num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad9 = Integer.parseInt(num9.getLabel());
				list.add(String.valueOf(keypad9));
			
				key9 = list.toString();
				key9 = key9.substring(1, key9.length() - 1);
				key9 = String.valueOf(key9.replaceAll(" ",""));
				key9 = String.valueOf(key9.replaceAll(",",""));
				
				Result.setText(key9);
			}
		});
		
		JButton num8 = new JButton("8");
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad8 = Integer.parseInt(num8.getLabel());
				list.add(String.valueOf(keypad8));
			
				key8 = list.toString();
				key8 = key8.substring(1, key8.length() - 1);
				key8 = String.valueOf(key8.replaceAll(" ",""));
				key8 = String.valueOf(key8.replaceAll(",",""));
				
				Result.setText(key8);
			}
		});
		
		JButton num7 = new JButton("7");
		num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad7 = Integer.parseInt(num7.getLabel());
				list.add(String.valueOf(keypad7));
			
				key7 = list.toString();
				key7 = key7.substring(1, key7.length() - 1);
				key7 = String.valueOf(key7.replaceAll(" ",""));
				key7 = String.valueOf(key7.replaceAll(",",""));
				
				Result.setText(key7);
			}
		});
		num7.setBorder(null);
		num7.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num7.setFocusPainted(false);
		num7.setBackground(SystemColor.menu);
		num7.setBounds(9, 324, 69, 59);
		contentPane.add(num7);
		num8.setBorder(null);
		num8.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num8.setFocusPainted(false);
		num8.setBackground(SystemColor.menu);
		num8.setBounds(87, 324, 69, 59);
		contentPane.add(num8);
		num9.setBorder(null);
		num9.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num9.setFocusPainted(false);
		num9.setBackground(SystemColor.menu);
		num9.setBounds(165, 324, 69, 59);
		contentPane.add(num9);
		
		JButton equals_bttn = new JButton("=");
		equals_bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						//locate operator's
				            if(!list.isEmpty()) {
				            	listProceed = true;
				            }
				            if(listProceed == true) {
							//for(String lists : list) {
							if(list.contains(OP)) {
								operatorIndex = list.indexOf(OP);
								
								//forList (find operator's)
								ListIterator<String> listIter = list.listIterator(operatorIndex); /* The ITERATOR Starts with the OPERATOR */
								
								//locate number's - 1st Operand
								while(listIter.hasPrevious()) {
									firstOperands.add(listIter.previous());

									}
								
								//Removing ArrayList Regex
								firstOPS = firstOperands.toString();

								if(firstOPS.contains(OP)) {
									firstOPS = firstOPS.substring(1, firstOPS.length() - 1);
									firstOPS = String.valueOf(firstOPS.replaceAll(OP,""));
									firstOPS = String.valueOf(firstOPS.replaceAll(" ",""));
									firstOPS = String.valueOf(firstOPS.replaceAll(",",""));
								}
								else {
								firstOPS = firstOPS.substring(1, firstOPS.length() - 1);
								firstOPS = String.valueOf(firstOPS.replaceAll(" ",""));
								firstOPS = String.valueOf(firstOPS.replaceAll(",",""));
								}
								
								//reverseStringMethod
								firstOPS = new StringBuilder(firstOPS).reverse().toString();
							    //JOptionPane.showMessageDialog(null, firstOPS);
                                
								if(!firstOPS.contains(".")) {
								operand_1 = Integer.valueOf(firstOPS); /* to first Operand */
								}
								else if(firstOPS.contains(".")) {
								DoubleOperand_1 = Double.valueOf(firstOPS); /* to first Operand */
								}
    
								//locate number's - 2nd Operand
								while(listIter.hasNext()) {
									
									next = listIter.next(); 
									
									if(next.equals(OP)) {
										while(listIter.hasNext()) {
                   	            secondOperands.add(listIter.next()); 
									
								}
								}
								}
								//Removing ArrayList Regex
								secondOPS = secondOperands.toString();
								if(secondOPS.contains(OP)) {
									secondOPS = secondOPS.substring(1, secondOPS.length() - 1);
									secondOPS = String.valueOf(secondOPS.replaceAll(OP,""));	
									secondOPS = String.valueOf(secondOPS.replaceAll(" ",""));
									secondOPS = String.valueOf(secondOPS.replaceAll(",",""));
								}
								else {
								secondOPS = secondOPS.substring(1, secondOPS.length() - 1);
								secondOPS = String.valueOf(secondOPS.replaceAll(" ",""));
								secondOPS = String.valueOf(secondOPS.replaceAll(",",""));
								
								}
							    
								if(!secondOPS.contains(".")) {
								operand_2 = Integer.valueOf(secondOPS); /* to second Operand */
								}
								else if(secondOPS.contains(".")) {
					            DoubleOperand_2 = Double.valueOf(secondOPS); /* to second Operand */
								}
                               // System.out.println(operand_2);

								//JOptionPane.showMessageDialog(null, operand_1 + " " + operand_2);
								
							//MATCH OPERATORS
							if(list.contains("-")) {
								String stringOperand_1 = String.valueOf(DoubleOperand_1);
								String stringOperand_2 = String.valueOf(DoubleOperand_2);
								
								String stringOperand_11 = String.valueOf(operand_1);
								String stringOperand_22 = String.valueOf(operand_2);
								if(operand_1 > operand_2 && (!stringOperand_11.contains(".") && !stringOperand_22.contains("."))) {
									nums= subMethodInt(operand_1,operand_2);
									res = String.valueOf(nums);
								Result.setText(res);
								}
								if(stringOperand_1.contains(".") || stringOperand_2.contains(".") && DoubleOperand_1 > DoubleOperand_2) {
									nums=(int)subMethodDouble(DoubleOperand_1,DoubleOperand_2);
									res = String.valueOf(nums);
								double doubleRes = Double.valueOf(res);
								Result.setText(String.valueOf(doubleRes));
								}
								else {
								Result.setText("-"+res);
								}
								firstOperands.clear();
								secondOperands.clear();
								list.clear();
							}
								
							
							
							if(list.contains("+")) {
								String stringOperand_1 = String.valueOf(DoubleOperand_1);
								String stringOperand_2 = String.valueOf(DoubleOperand_2);
								
								String stringOperand_11 = String.valueOf(operand_1);
								String stringOperand_22 = String.valueOf(operand_2);
								
								if(operand_1 > operand_2 && (!stringOperand_11.contains(".") && !stringOperand_22.contains("."))) {
									nums= sumMethodInt(operand_1,operand_2);
									res = String.valueOf(nums);
								Result.setText(res);
								}
								if(stringOperand_1.contains(".") || stringOperand_2.contains(".") && DoubleOperand_1 > DoubleOperand_2) {
									nums= (int)sumMethodDouble(DoubleOperand_1,DoubleOperand_2);
									res = String.valueOf(nums);
								double doubleRes = Double.valueOf(res);
								Result.setText(String.valueOf(doubleRes));
								}
								else {
								Result.setText("-"+res);
								}
								firstOperands.clear();
								secondOperands.clear();
								list.clear();
							}

							
							
							if(list.contains("x")) {
								String stringOperand_1 = String.valueOf(DoubleOperand_1);
								String stringOperand_2 = String.valueOf(DoubleOperand_2);
								
								String stringOperand_11 = String.valueOf(operand_1);
								String stringOperand_22 = String.valueOf(operand_2);
								if(operand_1 > operand_2 && (!stringOperand_11.contains(".") && !stringOperand_22.contains("."))) {
									nums=multMethodInt(operand_1,operand_2);
									res = String.valueOf(nums);
								Result.setText(res);
								}
								if(stringOperand_1.contains(".") || stringOperand_2.contains(".") && DoubleOperand_1 > DoubleOperand_2) {
									nums=(int)multMethodDouble(DoubleOperand_1,DoubleOperand_2);
									res = String.valueOf(nums);
								double doubleRes = Double.valueOf(res);
								Result.setText(String.valueOf(doubleRes));
								}
								else {
								Result.setText("-"+res);
								}
								firstOperands.clear();
								secondOperands.clear();
								list.clear();
							}
							
							
							
							if(list.contains("/")) {
								String stringOperand_1 = String.valueOf(DoubleOperand_1);
								String stringOperand_2 = String.valueOf(DoubleOperand_2);
								
								String stringOperand_11 = String.valueOf(operand_1);
								String stringOperand_22 = String.valueOf(operand_2);
								if(operand_1 > operand_2 && (!stringOperand_11.contains(".") && !stringOperand_22.contains("."))) {
									nums=divMethodInt(operand_1,operand_2);
									res = String.valueOf(nums);
								Result.setText(res);
								}
								if(stringOperand_1.contains(".") || stringOperand_2.contains(".") && DoubleOperand_1 > DoubleOperand_2) {
									nums=(int)divMethodDouble(DoubleOperand_1,DoubleOperand_2);
									res = String.valueOf(nums);
								double doubleRes = Double.valueOf(res);
								Result.setText(String.valueOf(doubleRes));
								}
								else {
								Result.setText("-"+res);
								}
								firstOperands.clear();
								secondOperands.clear();
								list.clear();
							}
							}
							
				}
				            
				          
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}});
		
		JButton num0 = new JButton("0");
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keypad0 = Integer.parseInt(num0.getLabel());
				list.add(String.valueOf(keypad0));
			
				key0 = list.toString();
				key0 = key0.substring(1, key0.length() - 1);
				key0 = String.valueOf(key0.replaceAll(" ",""));
				key0 = String.valueOf(key0.replaceAll(",",""));
				
				Result.setText(key0);
			}
		});
		num0.setBorder(null);
		num0.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num0.setFocusPainted(false);
		num0.setBackground(SystemColor.menu);
		num0.setBounds(10, 394, 69, 59);
		contentPane.add(num0);
		equals_bttn.setForeground(new Color(255, 255, 255));
		equals_bttn.setBackground(Color.DARK_GRAY);
		equals_bttn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		equals_bttn.setFocusPainted(false);
		equals_bttn.setFont(new Font("Segoe UI", Font.BOLD, 36));
		equals_bttn.setBounds(88, 394, 258, 58);
		contentPane.add(equals_bttn);
	}
	//OVERLOADING METHOD (OPERATORS && DECIMALS)
	static int subMethodInt(int operand_1, int operand_2) {
		return operand_1 - operand_2 ;
		
	}
	static double subMethodDouble(Double operand1, Double operand2) {
		return operand1 - operand2;
	}
	static int sumMethodInt(int operand_1, int operand_2) {
		return operand_1 + operand_2 ;
		
	}
	static double sumMethodDouble(Double operand1, Double operand2) {
		return operand1 + operand2;
	}
	static int multMethodInt(int operand_1, int operand_2) {
		return operand_1 * operand_2 ;
		
	}
	static double multMethodDouble(Double operand1, Double operand2) {
		return operand1 * operand2;
	}
	static int divMethodInt(int operand_1, int operand_2) {
		return operand_1 / operand_2 ;
		
	}
	static double divMethodDouble(Double operand1, Double operand2) {
		return operand1 / operand2;
	}
}

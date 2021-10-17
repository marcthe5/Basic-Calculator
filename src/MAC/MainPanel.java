package MAC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
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
    
	//Numbers
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
	protected String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
	
	//Numbers
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
	protected int num_1;
	protected int num_2;
	protected int nums;
	protected int operatorIndex;
	protected static String OP;
	
	//Output-Inputs
	ArrayList<Integer> numList = new ArrayList<Integer>();
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> opsList = new ArrayList<String>();
    //Collection<String> list;
	
	//while-ops
	protected static boolean checkOps = true;

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
				
				
        /*
				try {
				//toOutput
				for(String fNum : numbers) {
					
				if(Result.getText().contains(fNum)) {	
				Result.setText(Csum);
              
			}
				else {
					Result.setText(null);
					list.clear();
				}
			}
				}
				catch(NullPointerException e1) {
					e1.printStackTrace();
				}
				*/
				
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
				Cmult = (mult.getLabel());
				list.add(String.valueOf(Cmult));
				Cmult = list.toString();
				Cmult = Cmult.substring(1, Cmult.length() - 1);
				Cmult = String.valueOf(Cmult.replaceAll(" ",""));
				Cmult = String.valueOf(Cmult.replaceAll(",",""));
				
				Result.setText(Cmult);
				
				/* try {
				//toOutput
				for(String fNum : numbers) {
				if(Result.getText().contains(fNum)) {	
				Result.setText(Cmult);
				//checkOps = true;
			}
				
				else {
					Result.setText(null);
					//checkOps = false;
					list.clear();
				}
			
				}
				}
				catch(NullPointerException e1) {
					e1.printStackTrace();
				}
				*/
				
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
				//list.add(Integer.valueOf(keypad2));
				list.add(String.valueOf(keypad2));
			
				key2 = list.toString();
				key2 = key2.substring(1, key2.length() - 1);
				key2 = String.valueOf(key2.replaceAll(" ",""));
				key2 = String.valueOf(key2.replaceAll(",",""));
				
				Result.setText(key2);
                
				/*
				try {
					//toOutput
					for(String fOps : operators) {
						
					if(Result.getText().contains(fOps)) {	
					Result.setText(null);
	              
				}
					else {
						Result.setText(key2);
					}
				}
					}
					catch(NullPointerException e1) {
						e1.printStackTrace();
					}
                 */
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
			}
		});
		
		JButton num8 = new JButton("8");
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton num7 = new JButton("7");
		num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

				
		                   
						//locate operator's
							for(String lists : list) {
							if(lists.contains(OP)) {
								operatorIndex = list.indexOf(OP);
								//forList (find operator's)
								ListIterator<String> listOperator = list.listIterator(operatorIndex);
								
								//locate number's - 1st digit
								while(listOperator.hasPrevious()) {
									String PLO = listOperator.previous();
						            num_1 = Integer.valueOf(PLO);


								
								//locate number's - 2nd digit
								while(listOperator.hasNext()) {
									String NLO = listOperator.next();
									
									if(NLO.equals(OP)) {
									listOperator.remove();
									num_2 = Integer.valueOf(listOperator.next());
											
							//match operators
							if(Result.getText().contains("-")) {
					
								nums=num_1 - num_2;
								res = String.valueOf(nums);
								Result.setText(res);

							
							}
							if(lists.contains("+")) {
								nums=num_1 + num_2;
								res = String.valueOf(nums);
								JOptionPane.showMessageDialog(null, res);
								//Result.setText(res);

							
							}
							if(Result.getText().contains("x")) {
								
								nums=num_1 * num_2;
								res = String.valueOf(nums);
								Result.setText(res);

							}
							if(Result.getText().contains("/")) {
								nums=num_1 / num_2;
								res = String.valueOf(nums);
								Result.setText(res);

	
								
							
									}
								}
					}}
				}
				}
				
			}
			
		});
		
		JButton num0 = new JButton("0");
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
}

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
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class MainPanel extends JFrame {
	static MainPanel frame = new MainPanel();
	
	protected JLabel Result;
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
	
	//Operators
	protected char Csum;
	protected char Csub;
	protected char Cmult;
	protected char Cdiv;
	
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
		sum.setForeground(new Color(255, 255, 255));
		sum.setBackground(Color.DARK_GRAY);
		sum.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		sum.setFocusPainted(false);
		sum.setFont(new Font("Segoe UI", Font.BOLD, 40));
		sum.setBounds(334, 290, 89, 94);
		contentPane.add(sum);
		
		JButton mult = new JButton("*");
		mult.setForeground(new Color(255, 255, 255));
		mult.setFont(new Font("Segoe UI", Font.BOLD, 44));
		mult.setFocusPainted(false);
		mult.setBackground(Color.DARK_GRAY);
		mult.setBounds(334, 190, 89, 97);
		contentPane.add(mult);
		
		JButton div = new JButton("/");
		div.setForeground(new Color(255, 255, 255));
		div.setFont(new Font("Segoe UI", Font.BOLD, 34));
		div.setFocusPainted(false);
		div.setBackground(Color.DARK_GRAY);
		div.setBounds(242, 190, 89, 97);
		contentPane.add(div);
		
		JButton sub = new JButton("-");
		sub.setForeground(new Color(255, 255, 255));
		sub.setFont(new Font("Segoe UI", Font.BOLD, 44));
		sub.setFocusPainted(false);
		sub.setBackground(Color.DARK_GRAY);
		sub.setBounds(242, 290, 89, 94);
		contentPane.add(sub);
		
		JButton num1 = new JButton("1");
		num1.setBorder(null);
		num1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num1.setFocusPainted(false);
		num1.setBackground(SystemColor.menu);
		num1.setBounds(9, 190, 69, 59);
		contentPane.add(num1);
		
		JButton num4 = new JButton("4");
		num4.setBorder(null);
		num4.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num4.setFocusPainted(false);
		num4.setBackground(SystemColor.menu);
		num4.setBounds(9, 257, 69, 59);
		contentPane.add(num4);
		
		JButton num7 = new JButton("7");
		num7.setBorder(null);
		num7.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num7.setFocusPainted(false);
		num7.setBackground(SystemColor.menu);
		num7.setBounds(9, 324, 69, 59);
		contentPane.add(num7);
		
		JButton num0 = new JButton("0");
		num0.setBorder(null);
		num0.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num0.setFocusPainted(false);
		num0.setBackground(SystemColor.menu);
		num0.setBounds(10, 394, 69, 59);
		contentPane.add(num0);
		
		JButton equals_bttn = new JButton("=");
		equals_bttn.setForeground(new Color(255, 255, 255));
		equals_bttn.setBackground(Color.DARK_GRAY);
		equals_bttn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		equals_bttn.setFocusPainted(false);
		equals_bttn.setFont(new Font("Segoe UI", Font.BOLD, 36));
		equals_bttn.setBounds(88, 394, 258, 58);
		contentPane.add(equals_bttn);
		
		JButton decimal_bttn = new JButton(".");
		decimal_bttn.setBorder(null);
		decimal_bttn.setFont(new Font("Segoe UI", Font.BOLD, 34));
		decimal_bttn.setFocusPainted(false);
		decimal_bttn.setBackground(SystemColor.menu);
		decimal_bttn.setBounds(354, 394, 69, 59);
		contentPane.add(decimal_bttn);
		
		JButton num2 = new JButton("2");
		num2.setBorder(null);
		num2.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num2.setFocusPainted(false);
		num2.setBackground(SystemColor.menu);
		num2.setBounds(87, 190, 69, 59);
		contentPane.add(num2);
		
		JButton num5 = new JButton("5");
		num5.setBorder(null);
		num5.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num5.setFocusPainted(false);
		num5.setBackground(SystemColor.menu);
		num5.setBounds(87, 257, 69, 59);
		contentPane.add(num5);
		
		JButton num8 = new JButton("8");
		num8.setBorder(null);
		num8.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num8.setFocusPainted(false);
		num8.setBackground(SystemColor.menu);
		num8.setBounds(87, 324, 69, 59);
		contentPane.add(num8);
		
		JButton num3 = new JButton("3");
		num3.setBorder(null);
		num3.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num3.setFocusPainted(false);
		num3.setBackground(SystemColor.menu);
		num3.setBounds(165, 190, 69, 59);
		contentPane.add(num3);
		
		JButton num6 = new JButton("6");
		num6.setBorder(null);
		num6.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num6.setFocusPainted(false);
		num6.setBackground(SystemColor.menu);
		num6.setBounds(165, 257, 69, 59);
		contentPane.add(num6);
		
		JButton num9 = new JButton("9");
		num9.setBorder(null);
		num9.setFont(new Font("Segoe UI", Font.BOLD, 34));
		num9.setFocusPainted(false);
		num9.setBackground(SystemColor.menu);
		num9.setBounds(165, 324, 69, 59);
		contentPane.add(num9);
	}
}

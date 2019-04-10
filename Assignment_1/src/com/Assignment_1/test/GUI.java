package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener, MouseListener
{
	//Attributes
	//private JFileChooser chooser;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	//private JTextField field1;
	//private JLabel label2;
	//public String sentence;
	//FileNameExtensionFilter filter;
	//File selectedFile;
	
	//Constructor
	public GUI(/*String title*/)
	{
		super(/*title*/);
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		
		//chooser = new JFileChooser();
		button1 = new JButton("Choose File");
		button2 = new JButton("Enter Text");
		button3 = new JButton("EXIT");
		//label1 =  new JLabel("<html><br>Welcome to the Language Analyser!<br>This program can analyse a string of text of a file based on a few factors.<br>These factors are:<br>1. Sentence Length<br>2. Correct punctuation<br>3. Correct Grammar</html>");
		label1 =  new JLabel("<html><center>Welcome to the Language Analyser!</center><br>This program can analyse a string of text of a file based on a few factors.<br>These factors are:</html>");
		label2 = new JLabel("1. Sentence Structure");
		label3 = new JLabel("2. Correct Punctuation");
		label4 = new JLabel("3. Correct Grammar");
		
		//Give the labels a border
		Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
		label2.setBorder(border);
		label3.setBorder(border);
		label4.setBorder(border);
		
		//Set font size of buttons and label
		button1.setFont (button1.getFont ().deriveFont (14.0f));
		button2.setFont (button2.getFont ().deriveFont (14.0f));
		label1.setFont (label1.getFont ().deriveFont (19.0f));
		label2.setFont (label2.getFont ().deriveFont (19.0f));
		label3.setFont (label3.getFont ().deriveFont (19.0f));
		label4.setFont (label4.getFont ().deriveFont (19.0f));
		
		//Set button sizes
		button1.setPreferredSize(new Dimension(120, 40));
		button2.setPreferredSize(new Dimension(130, 40));
		
		//Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel2.setLayout(null);
		
		//Adding the panels
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		
		//Adding attributes to the panel
		panel1.add(button1);
		panel1.add(button2);
		panel3.add(button3);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		
		//Set location of labels
		label1.setBounds(100,20,700,100);
		label2.setBounds(100,130,250,40);
		label3.setBounds(100,180,250,40);
		label4.setBounds(100,230,250,40);
		
		
		//Set screen size
		setSize(900,600);
		
		//Makes the screen visible
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Set the colour of the screen
		//setBackground(Color.blue);
		
		//Link the listener to the button you want to monitor
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		label2.addMouseListener(this);
		label3.addMouseListener(this);
		label4.addMouseListener(this);
	}
		
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			this.dispose();
			GUI3 gui3 = new GUI3();
			gui3.setVisible(true);
		}
		
		if(event.getSource() == button2)
		{
			this.dispose();
			GUI2 gui2 = new GUI2();
			gui2.setVisible(true);
		}
		
		if(event.getSource() == button3)
		{
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) 
	{
		// TODO Auto-generated method stub	
		
		if(event.getSource() == label2)
		{
			JOptionPane.showMessageDialog(this,"If sentence length is too long with no form of a break then this informal.");
		}
		
		if(event.getSource() == label3)
		{
			JOptionPane.showMessageDialog(this,"If a sentence does not start with a capital letter or end in a\n sentence-ender e.g. fullstop then this is informal.");
		}
		
		if(event.getSource() == label4)
		{
			JOptionPane.showMessageDialog(this,"If a word is spelled incorrectly or it does not exist then this informal.");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	/*
	public static void Passer(String sentence)
	{
		System.out.println(sentence.toLowerCase());
		SentenceReader s1 = new SentenceReader();
		s1.addSentence(sentence);
		//SentenceReader.addSentence(sentence);
		//System.out.println(sentence);
		//SentenceReader reader = new SentenceReader();
		//reader.addSentence(sentence);
		//return sentence;
	}
	
	public static void Passer2(File selectedFile)
	{
		FileReader f1 = new FileReader();
		f1.addFile(selectedFile);
	}*/
}
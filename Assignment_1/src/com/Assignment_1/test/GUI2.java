package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI2 extends JFrame implements ActionListener
{
	//Attributes
	private JTextField field1;
	
	public GUI2(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		field1 = new JTextField(100);
		//field1 = new JTextField();
		field1.setColumns(15);
		
		JPanel panel3 = new JPanel();
		add(panel3, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// TODO Auto-generated method stub
		
	}

}

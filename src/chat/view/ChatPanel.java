package chat.view;

import javax.swing.*;


import chat.controller.ChatController;

import java.awt.event.*;

public class ChatPanel extends JPanel
{
	
	private ChatController baseController;
	private SpringLayout baseLayout;
	
	private JButton chatButton;
	private JTextArea chatTextViewer;
	private JTextField chatTextField;
	private JLabel chatLabel;
	
	private ChatFrame baseFrame; 
	
	public ChatPanel (ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("");
		chatTextViewer = new JTextArea();
		chatTextField = new JTextField();
		chatLabel = new JLabel();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(chatTextViewer);
		this.add(chatTextField);
		this.add(chatLabel);
		chatTextViewer.setEnabled(false);
		chatTextField.setToolTipText("Type here for chatBobt");
		chatLabel.setText("TALK TO ME!");
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 181, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -88, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 206, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -54, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatLabel, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatLabel, -25, SpringLayout.NORTH, chatTextField);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Clicked)
			{
				baseFrame.setSize(500,500);
			}
		});
	}


	public JTextField getTextField()
	{
		return chatTextField;
	}


	
	
	
}


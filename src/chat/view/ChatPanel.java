package chat.view;

import javax.swing.*;


import chat.controller.ChatController;

import java.awt.event.*;

/**
 * The panel class for use in other classes to set up our screen.
 * @author nhay7834
 *
 */

public class ChatPanel extends JPanel
{
	
	private ChatController baseController;
	private SpringLayout baseLayout;
	
	private JScrollPane textPane;
	private JButton chatButton;
	private JButton tweetButton;
	private JButton checkTwitterButton;
	private JButton saveButton;
	private JButton openButton;
	private JTextArea chatTextViewer;
	private JTextField chatTextField;
	
	
	private ChatFrame baseFrame; 
	
	public ChatPanel (ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Submit");
		tweetButton = new JButton("Tweet this!");
		checkTwitterButton = new JButton("Check Twitter");
		saveButton = new JButton(" Save this conversation!");
		chatTextViewer = new JTextArea(10,25);
		openButton = new JButton("Open a previous conversation maybe?");
		chatTextField = new JTextField(30);
		
		
		
		
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	
	
	public void setupChatPane()
	{
		chatTextViewer.setLineWrap(true);
		chatTextViewer.setWrapStyleWord(true);
		chatTextViewer.setEnabled(false);
		chatTextViewer.setEditable(false);
		textPane = new JScrollPane(chatTextViewer);
		
	}
	
	
	/**
	 * adding our GUI components, and setting them up for use. 
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(saveButton);
		this.add(openButton);
		//this.add(chatTextViewer);
		this.add(textPane);
		this.add(chatTextField);
		chatTextField.setToolTipText("Type here for chatBobt");
		chatTextViewer.setEnabled(false);
		
	}
	
	/**
	 * "Junk method for all our layout code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 315, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, checkTwitterButton, -6, SpringLayout.WEST, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, 247, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -18, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 67, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 209, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 53, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -46, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, checkTwitterButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, openButton, 6, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, openButton, 10, SpringLayout.WEST, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextViewer, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextViewer, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextViewer, 160, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextViewer, 360, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Clicked)
			{
				String userText = chatTextField.getText(); //Grab user text
				String response = baseController.fromUserToChatbot(userText); //send the text to the controller.
				
				chatTextViewer.append("\nUser:" + userText); //display user text.
				chatTextViewer.append("\nChatbot:" + response); //display chatbot text.
				chatTextField.setText(""); //clears field.
			}
		});
	}

	
	
	
	
	
	public JTextField getTextField()
	{
		return chatTextField;
	}


	
	
	
}


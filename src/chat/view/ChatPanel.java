package chat.view;

import javax.swing.*;

import chat.controller.ChatController;
import chat.controller.IOController;

import java.awt.event.*;

/**
 * The panel class for use in other classes to set up our screen.
 * 
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
	private JButton loadButton;
	private JButton geoLocationButton;
	private JTextArea chatTextViewer;
	private JTextField chatTextField;
	private JLabel promptLabel;

	private ChatFrame baseFrame;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		geoLocationButton = new JButton("Hot memes in your area");
		chatButton = new JButton("Submit");
		tweetButton = new JButton("Tweet this!");
		checkTwitterButton = new JButton("Check Twitter");
		saveButton = new JButton(" Save this conversation!");
		chatTextViewer = new JTextArea(10, 25);
		loadButton = new JButton("Open a previous conversation maybe?");
		chatTextField = new JTextField(30);
		promptLabel = new JLabel();
		

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
		this.add(geoLocationButton);
		this.add(chatButton);
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(promptLabel);
		// this.add(chatTextViewer);
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
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 122, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 260, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 315, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, checkTwitterButton, -6, SpringLayout.WEST, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, 247, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -18, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 53, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -46, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, checkTwitterButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 10, SpringLayout.WEST, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextViewer, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextViewer, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextViewer, 160, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextViewer, 360, SpringLayout.WEST, this);

	}

	private void setupListeners()
	{
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Clicked)
			{
				baseController.sendTweet("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
			}

		});

		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Clicked)
			{
				String userText = chatTextField.getText(); // Grab user text
				String response = baseController.fromUserToChatbot(userText); // send the text to the controller.

				chatTextViewer.append("\nUser:" + userText); // display user text.
				chatTextViewer.append("\nChatbot:" + response); // display chatbot text.
				chatTextField.setText(""); // clears field.
			}
		});

		checkTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = chatTextField.getText();
				String results = baseController.analyze(user);
				chatTextViewer.setText(results);
			}

		});

	
		
		geoLocationButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String qryResults = baseController.queryAnalyze();
				chatTextViewer.setText(qryResults);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String file = IOController.saveFile(chatTextField.getText());
				promptLabel.setText(file);
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.readTextFromFile(promptLabel.getText());
				chatTextViewer.setText(loadedText);
			}
			
		});
	
	
	
	}

	public JTextField getTextField()
	{
		return chatTextField;
	}

}

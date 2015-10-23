package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Controller for the chatbot project.
 * 
 * @author nhay7834
 * @version 1.2 10/23/15 Updated documentation and added a while loop. 
 */

public class ChatController
{
	private Chatbot nickChatBot;
	private ChatView chatDisplay;

	public ChatController()
	{
		chatDisplay = new ChatView();
		String user = chatDisplay.getGUI("What is your name?");
		nickChatBot = new Chatbot(user);
		
	}

	public void start()
	{
		chatDisplay.displayGUI("Hello " + nickChatBot.getUserName());
		chat();
	}

	
	/**
	 * Will return the latest text from our user.
	 */
	private void chat()
	{
		String textFromUser = chatDisplay.getGUI("Talk to the chatbot");
		while(nickChatBot.lengthChecker(textFromUser))
		{
			chatDisplay.getGUI("wow " + textFromUser);
		}
	}

}

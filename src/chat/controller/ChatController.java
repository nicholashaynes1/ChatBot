package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
/**
 * Controller for the chatbot project.
 * @author nhay7834
 *@version 1.1 10/23/15 Displays the chatbots userName variable 
 */

public class ChatController
{
	private Chatbot myChatBot;
	private ChatView chatDisplay;
	
	public ChatController()
	{
		chatDisplay = new ChatView();
		String user = chatDisplay.getGUI("What is your name?");
		myChatBot = new Chatbot(user);
	}
	
	public void start()
	{
		chatDisplay.displayText("Hello" + myChatBot.getUserName());
	}
	


}

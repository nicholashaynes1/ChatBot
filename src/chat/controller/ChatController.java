package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Controller for the chatbot project.
 * 
 * @author nhay7834
 * @version 1.3 10/23/15 Updated documentation and added a while loop.
 */

public class ChatController
{
	private Chatbot nickChatBot;
	private ChatView chatDisplay;

	public ChatController()
	{
		chatDisplay = new ChatView();
		String user = chatDisplay.getUserText("What is your name?");
		nickChatBot = new Chatbot(user);

	}

	public void start()
	{
		chatDisplay.displayUserText("Hello " + nickChatBot.getUserName());
		chat();
	}

	/**
	 * Will return the latest text from our user.
	 */
	private void chat()
	{
		String textFromUser = chatDisplay.getUserText("Talk to the chatbot");

		while (nickChatBot.lengthChecker(textFromUser))
		{

			if (nickChatBot.contentChecker(textFromUser))
			{
				chatDisplay.displayUserText("wow, I had no idea you loved" + nickChatBot.getContent());
			}

			else if (nickChatBot.memeChecker(textFromUser))
			{
				chatDisplay.displayUserText("Wow what a dank meme");

			}
			textFromUser = chatDisplay.getUserText(textFromUser);

		}
	}

}

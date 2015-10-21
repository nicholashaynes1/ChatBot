package chat.controller;

/**
 * Starts our Chatbot program.
 * @author nhay7834
 *@version 1.0 10/21/15
 */


public class ChatRunner
{
	public static void main (String [] args)
	{
		ChatController myChatController = new ChatController();
		myChatController.start();
	}
}

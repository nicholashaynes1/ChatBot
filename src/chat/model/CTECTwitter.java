package chat.model;

import java.util.*;

import chat.controller.ChatController;
import twitter4j.*;

/**
 * @author nhay7834
 * @version 0.1 Added our twitter method.
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}

	public void sendTweet(String input)
	{
		try
		{
			chatbotTwitter.updateStatus(input);

		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}

	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));

			page++;
		}

		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}

		removeCommonEnglishWords(wordsList);
		removeEmptyText();

	}

	
	
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordsList.size(); spot++)
			if(wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?;:\"(){}^[]<>-";
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
}
package chat.view;

import javax.swing.JOptionPane;

/**
 * 
 * @author nhay7834
 *@version 1.0 10/21/15
 */

public class ChatView
{
	
	/**
	 * This method will get the users 
	 * @param input: Holds the user Input.
	 * @return returns the users answer to show.
	 */
	
	public String getGUI(String wordsShowing)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, wordsShowing);
		
		return answer;
	}
	
	/**
	 * This will show the user their input dialog.
	 * @param displayText What is going to be displayed on the screen
	 */
	
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}

}
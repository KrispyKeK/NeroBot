package chat.view;

import javax.swing.*;

public class PopupDisplay {
	public ImageIcon icon;
	private String windowTitle;
	public ImageIcon prime;
	
	public PopupDisplay() {
		icon = new ImageIcon(getClass().getResource("images/donut.png"));
		windowTitle = "Sample";
	}
	public void displayText(String message) {
		//opens up a java window to display text
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);{
		}	
	}
	//this method gets the user's input and stores it into a variable
	public String collectResponse(String fromQuestion) {
		String response = "";
		response += JOptionPane.showInputDialog(null, fromQuestion, windowTitle, JOptionPane.QUESTION_MESSAGE, icon, null, "");
		return response;
	}
}


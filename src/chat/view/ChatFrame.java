package chat.view;

import javax.swing.*;
import chat.controller.ChatbotController;
import chat.view.ChatPanel;
import sun.audio.*;


public class ChatFrame extends JFrame{
	
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatbotController appController) {
		super();
		this.appController = appController;
		this.appPanel = new ChatPanel(appController);
		
		setupFrame();
	}
	private void setupFrame() {
		this.setContentPane(appPanel);
		this.setTitle("Nero");
		this.setSize(700,500);
		this.setResizable(false);
		this.setVisible(true);
	}	
	public ChatbotController getBaseController() {
		return appController;
	}
}

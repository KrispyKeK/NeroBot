package chat.controller;

import chat.view.*;
import java.util.*;
import chat.model.Chatbot;
import javax.swing.*;

public class ChatbotController {
	private PopupDisplay display;	
	Chatbot chatbot;
	ChatFrame appFrame;
	
	public ChatbotController() {
		display = new PopupDisplay();
		chatbot = new Chatbot("J0AN TR0N2O0O");
		appFrame = new ChatFrame(this);
	}
	public void start() {
		//String response = display.collectResponse("What do you want to talk about: ");
		//while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
		
	}
	
	public String interactWithChatbot(String input) {
		input += "";
		if (input.length() > 5 && input != null) {
			return chatbot.processConversation(input);
		}
		return "You did not type a correct sentence Master.";

	}
	private String popupChat(String chat) {
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		return chatbotSays;
	}
	public PopupDisplay getDisplay() {
		return display;
	}
	public Chatbot getChatbot() {
		return chatbot;
	}
	public ChatFrame getChatFrame() {
		return null;
	}
	//Links to randomButton in chatPanel
	public String randomResponse(String output) {
		output = "";
		return output;
	}
	public String randomOutput() {
		String randOut = "";
		randOut += "Nero: " +  chatbot.randomOutput();
		return randOut;
	}

}

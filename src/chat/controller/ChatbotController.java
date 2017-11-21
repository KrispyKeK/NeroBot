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
		if (chatbot.lengthChecker(input) && !chatbot.quitChecker(input)) {
			return chatbot.processConversation(input);
		}
		else if (chatbot.quitChecker(input)) {
			close();
		}
		return "You did not type a correct sentence Master.";

	}
	private void close() {
		display.displayText("See you later Master");
		System.exit(0);
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
		return appFrame;
	}
	public String randomOutput() {
		String randOut = "";
		randOut += "Nero: " +  chatbot.randomOutput();
		return randOut;
	}

}

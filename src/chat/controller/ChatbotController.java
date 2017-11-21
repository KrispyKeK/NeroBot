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
	public String useCheckers(String text) {
		String response = "";
		boolean movieCount = false;;
		if (chatbot.contentChecker(text)) {
			response += "Nero: This text matches the special content, Master.\n";
		}
		if (chatbot.cuteAnimalMemeChecker(text)) {
			response += "Nero: This animal is awfully cute, Master.\n";
		}
		else if (!text.contains("")){
			response += "Nero: I do not find " + text + " as cute as a kitten Master.\n";
		}
		if (chatbot.shoppingListChecker(text)) {
			response += "Nero: I really want to eat " + text + " now, can you grab me some Master?\n";
		}
		else if (!text.contains("")){
			response += "Nero: I am sorry Master, but I do not like " + text + ".\n";
		}
		if (chatbot.movieTitleChecker(text)) {
			response += "Nero: I love the sound of that movie, perhaps we could watch it together.\n";
			movieCount = true;
		}
		else if (!text.contains("")){
			response += "Nero: That movie will probably bore me Master.\n";
		}
		if (chatbot.movieGenreChecker(text) && movieCount) {
			response += "Nero: I especially love the genre of the movie " + text + " Master.\n";
			movieCount = false;
		}
		else if (!text.contains("")) {
			response += "Nero: Not sure if I heard of that genre Master.\n";
		}
		if (chatbot.keyboardMashChecker(text)) {
			response += "Nero: I hear you crystal clear Master.\n";
		}
		else if (!text.contains("")){
			response += "Nero: Are you okay Master? I don't quite understand that.\n";
		}
		if (chatbot.userNameChecker(text)) {
			response += "Nero: I love your name Master.\n";
		}
		else if (!text.contains("")){
			response += "Nero: That is quite a uniqe name Master.\n";
		}
		if (chatbot.htmlTagChecker(text)) {
			response += "Nero: I do not know much about the internet, but I hope you're righte Master.\n";
		}
		response += "\n";
		return response;
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
	public String sendIntro() {
		return chatbot.setIntro();
	}

}

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
	//a method that is no longer used because they're is no need
	public void start() {
		//String response = display.collectResponse("What do you want to talk about: ");
		//while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
		
	}
	//a method used to call out strings and list so that the chatbot may respond accordingly
	public String interactWithChatbot(String input) {
		input += "";
		if (chatbot.lengthChecker(input) && !chatbot.quitChecker(input) && chatbot.answerChecker(input) != true) {
			return chatbot.processConversation(input);
		}
		else if (chatbot.quitChecker(input)) {
			close();
		}
		else if (chatbot.answerChecker(input)) {
			return chatbot.processAnswer(input);
		}
		return "You did not type a correct sentence Master.";

	}
	//this checker is used for a button in JPanel so that it may correspond to the special checkers in Chatbot
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
			response += "Nero: I do not know much about the internet, but I hope you're right"+ "\n" + "Master.\n";
		}
		response += "\n";
		return response;
	}
	//a closing method for our JFrame
	private void close() {
		display.displayText("See you later Master");
		System.exit(0);
	}
	//a now useless method
	private String popupChat(String chat) {
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		return chatbotSays;
	}
	//return popupdisplay becaues it was required for the tester
	public PopupDisplay getDisplay() {
		return display;
	}
	//returns chatbot because it was required for the test
	public Chatbot getChatbot() {
		return chatbot;
	}
	//returns the frame 
	public ChatFrame getChatFrame() {
		return appFrame;
	}
	//a method that is used in the randomButton to generate a random statement from  the bot without the need of the user response
	public String randomOutput() {
		String randOut = "";
		randOut += "Nero: " +  chatbot.randomOutput();
		return randOut;
	}
	//I don't even know why this is here, I dont need it
	public String sendIntro() {
		return chatbot.setIntro();
	}
	//returns the current time. DOES NOT UPDATE DURING RUN
	public String getTime() {
		return chatbot.getTime();
	}

}

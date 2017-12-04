package chat.model;

import java.util.List;
import java.time.*;
import java.util.ArrayList;
import java.util.*;

//Intializes the variables
public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String [] answers;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	//Stores a default value from the variables above ^ and calling methods from the list below 
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String[10];
		this.username = "Master" + username;
		this.content = "ContentCopMemes";
		this.intro = "Hey what's going on guys, it's Kripparian here";
		this.currentTime = LocalTime.now();
		this.topics = new String[7];
		this.verbs = new String[10];
		this.followUps = new String[5];
		this.answers = new String[4];
		
		buildVerbs();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
		buildTopics();
		buildCuteAnimals();
		buildFollowUps();
		buildAnswers();
	}
	private void buildAnswers() 
	{
		answers[0] = "Yes, Master";
		answers[1] = "No, Master";
		answers[2] = "I don't quite understand your question Master.";
		answers[3] = "I'm sorry Master, but I don't know the answer to that.";
	}
	//Adds to the list Topics, and is called within Chatbot
	public String getTime() {
		String time = "";
		time += currentTime.getHour() + ": " + currentTime.getMinute() + " " + "\n";
		return time;
	}
	private void buildTopics() 
	{
		topics[0] = "Rome";
		topics[1] = "Enemies";
		topics[2] = "Sparta";
		topics[3] = "Theatre";
		topics[4] = "Literature";
		topics[5] = "Singing";
		topics[6] = "The people of Rome";
	}
	//Adds to the list verbs, and is called within Chatbot
	private void buildVerbs() 
	{
		verbs[0] = "like ";
		verbs[1] = "dislike ";
		verbs[2] = "am ambivalent about ";
		verbs[3] = "am thinking about ";
		verbs[4] = "hate ";
		verbs[5] = "love ";
		verbs[6] = "despise ";
		verbs[7] = "am acustommed to ";
		verbs[8] = "weary about ";
		verbs[9] = "disappointed about";			
	}	
	public String setIntro() 
	{
		String intro = "Nero: Hello Master, I am your humble servant, talk to me as much as you \n want to. - umu\n\n";
		return intro;
	}
	private void buildMovieList()
	{
		Movie sparta = new Movie("sparta");
		Movie glad = new Movie("gladiator");
		Movie legend = new Movie("hercules");
		Movie romance = new Movie("romeo and juliett");
		Movie king = new Movie("julius caesar");
		Movie tempest = new Movie("the tempest");
		movieList.add(sparta);
		movieList.add(glad);
		movieList.add(legend);
		movieList.add(romance);
		movieList.add(king);
		movieList.add(tempest);
	}	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("fruits");
		shoppingList.add("milk");
		shoppingList.add("cereal");
		shoppingList.add("jello");
		shoppingList.add("chips");
		shoppingList.add("sugar");
		shoppingList.add("rice");
		shoppingList.add("ice cream");
	}	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "Are you my master?";
		questions[2] = "Am I better than King Author?";
		questions[3] = "Am I the best singer?";
		questions[4] = "Do the people of Rome love me?";
		questions[5] = "Have you summoned me?";
		questions[6] = "What shall we eat?";
		questions[7] = "Shall we sing together?";
		questions[8] = "Do you want me to call you something else?";
		questions[9] = "Do you have anybody you want me to 'take care' of?";

	}
	private void buildFollowUps() 
	{
		followUps[0] = "Nice Weather we're having right Master?";
		followUps[1] = "Perhaps we could fight strong foes today";
		followUps[2] = "";
		followUps[3] = "";
		followUps[4] = "";
	}
	
	public String processAnswer(String input) {
		String response = "";
		int random = (int)(Math.random() * answers.length);
		response += "Nero: " + answers[random] + "\n";
		return response;
	}
	public String processConversation(String input)
	{
		String chatbotResponse = "Nero: ";
		chatbotResponse += buildChatbotResponse();
		if (input != null && input.length() > 5) {
			return chatbotResponse;
		}
		return "Nero: You did not input a correct sentence Master";
	}
	private String buildChatbotResponse() {
		String response= "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		random = (int) (Math.random() * topics.length);
		response += topics[random] + " - umu." + "\n" + "Nero: ";
		random = (int) (Math.random() * questions.length);
		response += questions[random] + " - umu"  + "\n";
		random = (int) (Math.random() * 2);
		if (random%2 == 0) {
			random = (int) (Math.random() * movieList.size());
			response +="Nero: I" + verbs[random] + movieList.get(random).getTitle() + " - umu." + "\n";
		}
		else {
			response += "\n";
		}
		int followup = (int)(Math.random() * followUps.length);
		switch (followup) {
		case 0:
			response += "Nero: " + followUps[0] + "\n";
			break;
		case 1:
			response += "Nero: " + followUps[1] + "\n";
			break;
		case 2:
			response += "Nero: " + followUps[2] + "\n";
			break;
		default:
			response += "Nero: " + followUps[3] + "\n";
			response += "Nero: " + followUps[4] + "\n";
			break;
		}
		return response;
	}
	public String randomOutput() {
		String randomOutput = "I ";
		int random = (int) (Math.random() * verbs.length);
		randomOutput += verbs[random];
		random = (int) (Math.random() * topics.length);
		randomOutput += " " + topics[random] + " - umu." + "\n" + "Nero: ";
		random = (int) (Math.random() * questions.length);
		randomOutput += questions[random] + " - umu" + "\n" + "\n";
		return randomOutput;
	}
	
	public boolean lengthChecker(String input)
	{
		if(input != null && input.length() > 2) {
			return true;
		}
		return false;
	}
	
	public boolean htmlTagChecker(String input)
	{
		boolean partTwo = false;
		boolean pChecker = false;
		int stringCount = 0;
		int prePlace = 1;
		int curPlace = 2;
		String inputTrim = input.trim();
		if (inputTrim.startsWith("<") && partTwo != true) {
			if (!inputTrim.substring(prePlace, curPlace).contains(">" + "what")) {
				if (inputTrim.substring(prePlace, curPlace).contains("P")) {
					stringCount++;
					pChecker = true;
				}
				else {
					stringCount++;
				}
				prePlace++;
				curPlace++;
			}
			else if (inputTrim.substring(prePlace, curPlace).contains(">")) {
				if (pChecker && stringCount == 1) {
					return true;
				}
				else if (stringCount > 0 || stringCount > 7) {
					partTwo = true;
					prePlace = inputTrim.indexOf(">");
					curPlace = prePlace + 1;
					inputTrim.substring(0,inputTrim.indexOf(">"));
					return true;
				}
				else {
					return false;
				}
			}
		}
		else if (partTwo) {
			if (inputTrim.startsWith("<")) {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	public boolean answerChecker(String input) {
		if (input.endsWith("?")) {
			return true;
		}
		return false;
	}
	public boolean userNameChecker(String input)
	{
		boolean isValidName = false;
		if (input != null && input.length() > 1 && input.startsWith("@") && input.contains("@@") != true && input.contains(".com") != true) {
			isValidName = true;
		}	
		return isValidName;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		if (contentCheck.length() > 5 && contentCheck != null) {
			return true;
		}
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		if (input.contains("pepe")) {
			return false;
		}
		else if (input.contains("pupper") || input.contains("kittie") || input.contains("otter")) {
			return true;
		}
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (int i = 0; i < shoppingList.size(); i++) {
			if (shoppingList.get(i).contains(shoppingItem.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if (title.length() > 0 && title != null) {
			for (int currentPlace = 0; currentPlace < movieList.size() - 1; currentPlace++) {
				if (movieList.get(currentPlace).getTitle().contains(title.toLowerCase())) {
					return true;
				}
				else if (title.contains("Spiderman") || title.contains("Hidden Figures")) {
					return true;
				}
			}

		}
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if (genre != null && genre.length() > 0) {
			return true;
		}
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString !=null && exitString.equalsIgnoreCase("quit")){
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		if (sample.contains(".")) {
			int periodCount = 0;
			int currentPlace = 0;
			for (int place = 1; place < sample.length() - 1; place++) {
				if (sample.substring(currentPlace,place).contains(".")) {
					periodCount++;
					currentPlace++;
					if (periodCount > 1) {
						return false;
					}
				}
			}
		}
		else if (sample.contains("derf")) {
			return false;
		}
		return true;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		int ind = questions.length - 1;
		if (questions[ind] != "?") {
			questions[ind] = "?";
		}
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	public String toString() {
		String descr = "";
		descr += "My name is nero";
		return descr;
	}
}

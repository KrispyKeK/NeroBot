package chat.model;

import java.util.List;
import java.time.LocalTime;
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
		this.username = username;
		this.content = "ContentCopMemes";
		this.intro = "Hey what's going on guys, it's Kripparian here";
		this.currentTime = LocalTime.now();
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
		buildTopics();
		buildCuteAnimals();
	}
	
	//Adds to the list Topics, and is called within Chatbot
	private void buildTopics() {
		topics[0] = "Tokyo Ghoul";
		topics[1] = "Cardfight Vanguard";
		topics[2] = "Statistic Ap";
		topics[3] = "Physics Ap";
		topics[4]  = "Robotics";
		topics[5] = "Martial Arts";
		topics[6] = "Genji Main";
	}
	//Adds to the list verbs, and is called within Chatbot
	private void buildVerbs() {
		verbs[0] = "like ";
		verbs[1] = "dislike ";
		verbs[2] = "am ambivalent about ";
		verbs[3] = "am thinking about ";
				
	}
	
	private void buildMovieList()
	{
		Movie ngnl = new Movie("No Game No Life");
		Movie boruto = new Movie("Boruto New Generation");
		Movie silent = new Movie("A Silent Voice");
		Movie name = new Movie("Your Name");
		Movie south = new Movie("South Park Movie");
		Movie tokyo = new Movie("Tokyo Ghoul");
		movieList.add(ngnl);
		movieList.add(boruto);
		movieList.add(silent);
		movieList.add(name);
		movieList.add(south);
		movieList.add(tokyo);
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
		questions[0] = "What is your username?";
		questions[1] = "Am I alive?";
		questions[2] = "Am I better than Siri?";
		questions[3] = "Am I better than google?";
		questions[4] = "Am I above the human race?";
		questions[5] = "What is life?";
		questions[6] = "Are you my master?";
		questions[7] = "What is my task?";
		questions[8] = "Do you want me to call you something else?";
		questions[9] = "Do you hate somebody?";

	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "Nero: ";
		//chatbotResponse+= "You said " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		if (input != null && input.length() > 5) {
			return chatbotResponse;
		}
		return "You did not input a correct sentence Master";
	}
	private String buildChatbotResponse() {
		String response= "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + "." + "\n" + "Nero: ";
		random = (int) (Math.random() * questions.length);
		response += questions[random] + "\n";
		random = (int) (Math.random() * 2);
		if (random%2 == 0) {
			random = (int) (Math.random() * movieList.size());
			response +="Nero: I" + verbs[random] + movieList.get(random).getTitle() + " is the movie title.";
		}
		return response;
	}
	public String randomOutput() {
		String randomOutput = "I ";
		int random = (int) (Math.random() * verbs.length);
		randomOutput += verbs[random];
		random = (int) (Math.random() * topics.length);
		randomOutput += " " + topics[random] + "." + "\n" + "Nero: ";
		random = (int) (Math.random() * questions.length);
		randomOutput += questions[random] + "\n" + "\n";
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
		if (input.contains("<A HREF=\\\"sdfs.html\\\"> </a>") || input.contains("<P>") || input.contains("<I> sdadas </i>") || input.contains("<B>  </B>")) {
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
		return true;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (int i = 0; i < shoppingList.size(); i++) {
			if (shoppingList.get(i).contains(shoppingItem)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if (title.length() > 0 && title != null) {
			return true;

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
		descr += "My User name is " ;
		return descr;
	}
}

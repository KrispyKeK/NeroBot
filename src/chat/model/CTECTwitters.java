package chat.model;
import chat.controller.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class CTECTwitters {
	private ChatbotController controller;
	private Twitter chatbotTwitter;
	public CTECTwitters(ChatbotController controller) {
		this.controller = controller;
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	public void sendTweet(String textToTweet) {
		try {
			chatbotTwitter.updateStatus(textToTweet + "I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! Juan Delacruz");
		}
		catch(TwitterException tweetError) {
			controller.handleErros(tweetError);
		}
		catch(Exception otherError) {
			controller.handleErros(otherError);
		}
	}
}

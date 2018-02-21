package chat.model;
import chat.controller.ChatbotController;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class CTECTwitter {
	private ChatbotController controller;
	private Twitter chatbotTwitter;
	public CTECTwitter(ChatbotController controller) {
		this.controller = controller;
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	public void sendTweet(String textToTweet) {
		try {
			chatbotTwitter.updateStatus(textToTweet + "@ChabotCTEC");
		}
		catch(TwitterException tweetError) {
			controller.handleErros(tweetError);
		}
		catch(Exception otherError) {
			controller.handleErros(otherError);
		}
	}
}

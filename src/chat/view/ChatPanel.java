package chat.view;

import chat.controller.ChatbotController;
import chat.model.Chatbot;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;

public class ChatPanel extends JPanel{
	
	private ChatbotController appController;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JTextField inputField;
	private JButton chatButton;
	private JLabel face;
	private JButton colorButton;
	private JButton randomButton;
	private JButton checkerButton;
	private int inputCounter;
	private AudioInputStream voice;
	
	public ChatPanel(ChatbotController appController) {
		super();
		this.appController = appController;		
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,10);
		inputField = new JTextField(25);
		chatButton = new JButton("Enter");
		colorButton = new JButton("Change Color");
		randomButton = new JButton("Random Answer");
		face = new JLabel(new ImageIcon(getClass().getResource("images/nero.png")));
		try {
			voice = AudioSystem.getAudioInputStream(Chatbot.class.getResourceAsStream("NeroVoice.wav"));
		}
		catch(Exception e) {
		}
		inputCounter = 0;
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel() {		
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(chatButton);
		this.add(randomButton);
		checkerButton = new JButton("Checker");
		this.add(checkerButton);
		this.add(colorButton);
		this.add(inputField);
		this.add(chatArea);
		this.add(face);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 40, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 230, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -180, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 406, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -13, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, face, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, face, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, face, -6, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, face, -16, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, randomButton, 0, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 29, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, colorButton, -6, SpringLayout.WEST, randomButton);
		baseLayout.putConstraint(SpringLayout.NORTH, colorButton, 29, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, colorButton, -19, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, randomButton, 0, SpringLayout.SOUTH, checkerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, checkerButton, 29, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -19, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -8, SpringLayout.WEST, colorButton);
	}
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if (inputCounter == 2) {
					chatArea.setText("");
					inputCounter = 0;
				}
				getInput();
				setTextArea(getInput());
				playVoice(voice);
				inputCounter++;
				inputField.setText("");
			}
		});
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				setRandomColor();
			}
		});
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if (inputCounter == 3) {
					chatArea.setText("");
					inputCounter = 0;
				}
				addRandomText();
				inputCounter++;
			}
		});
		checkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
		
	}
	private String getInput() {
		String userInput = "";
		userInput = inputField.getText();
		return userInput;
	}
	private void setTextArea(String inp) {
		chatArea.append("You: " + getInput() + "\n" + "\n" + appController.interactWithChatbot(inp) + "\n" + "\n");
	}
	private void setRandomColor() {
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		this.setBackground(new Color(red,green,blue));
	}
	private void addRandomText() {
		chatArea.append(appController.randomOutput());
	}
	public void playVoice(AudioInputStream Sound){
		try {
			Clip audio = AudioSystem.getClip();
			audio.open(AudioSystem.getAudioInputStream(Sound));
			audio.start();
			Thread.sleep(2000);
			audio.close();
		}
		catch(Exception e) {
			
		}
	}
	
}

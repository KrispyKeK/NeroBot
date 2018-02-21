package chat.view;

import chat.controller.ChatbotController;
import chat.model.Chatbot;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;

public class ChatPanel extends JPanel{
	
	private JScrollPane scrollPane;
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
	private JButton twitterButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton searchButton;
	
	public ChatPanel(ChatbotController appController) {
		super();
		this.appController = appController;		
		baseLayout = new SpringLayout();
		inputField = new JTextField(25);
		chatButton = new JButton("Chat",new ImageIcon(getClass().getResource("images/chat.png")));
		searchButton = new JButton("Search",new ImageIcon(getClass().getResource("images/Search.png")));
		baseLayout.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, chatButton);
		loadButton = new JButton("Load",new ImageIcon(getClass().getResource("images/load.png")));
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, searchButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.SOUTH, searchButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -6, SpringLayout.WEST, searchButton);
		saveButton = new JButton("Save",new ImageIcon(getClass().getResource("images/save.png")));
		baseLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, saveButton);
		twitterButton = new JButton("Twitter",new ImageIcon(getClass().getResource("images/twitt.png")));
		baseLayout.putConstraint(SpringLayout.EAST, twitterButton, -274, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 4, SpringLayout.EAST, twitterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, twitterButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, twitterButton, -6, SpringLayout.NORTH, inputField);
		colorButton = new JButton("Change Color");
		randomButton = new JButton("Random Answer");	
		checkerButton = new JButton("Checker");
		baseLayout.putConstraint(SpringLayout.WEST, checkerButton, 6, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -10, SpringLayout.EAST, this);
		face = new JLabel(new ImageIcon(getClass().getResource("images/nero.png")));
		baseLayout.putConstraint(SpringLayout.NORTH, face, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, face, 0, SpringLayout.WEST, inputField);
		inputCounter = 0;
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	private void setupScrollPane() {
		scrollPane.setViewportView(chatArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	private void setupPanel() {		
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		scrollPane = new JScrollPane();
		baseLayout.putConstraint(SpringLayout.SOUTH, face, 0, SpringLayout.SOUTH, scrollPane);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, scrollPane, 230, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, searchButton);
		baseLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, searchButton);
		chatArea = new JTextArea(10,10);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setText(appController.sendIntro());
		//this.add(scrollPane);
		this.add(searchButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(twitterButton);
		this.add(chatButton);
		//this.add(randomButton);
		this.add(checkerButton);
		//this.add(colorButton);
		this.add(inputField);
		//this.add(chatArea);
		this.add(face);
		this.add(scrollPane);
	}
	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.NORTH, checkerButton, 6, SpringLayout.SOUTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -32, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 1, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 406, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -13, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, randomButton, 0, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 29, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, colorButton, -6, SpringLayout.WEST, randomButton);
		baseLayout.putConstraint(SpringLayout.NORTH, colorButton, 29, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, colorButton, -19, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, randomButton, 0, SpringLayout.SOUTH, checkerButton);
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
				inputCounter++;
				inputField.setText("");
			}
		});
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				setRandomColor();
			}
		});
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (inputCounter == 2) {
						chatArea.setText("");
						inputCounter = 0;
					}
					getInput();
					setTextArea(getInput());
					inputCounter++;
					inputField.setText("");
				}
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
				if (inputCounter > 2) {
					chatArea.setText("");
				}
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
				inputCounter++;
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
}

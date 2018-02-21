package chat.view;

import chat.controller.ChatbotController;
import chat.model.Chatbot;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChatPanel extends JPanel{
	//intializes the componenets
	private ChatbotController appController;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JTextField inputField;
	private JButton chatButton;
	private JLabel face;
	private JButton colorButton;
	private JButton randomButton;
	private JButton checkerButton;
	private JScrollPane scrollPane;
	private JButton saveButton;
	private JButton loadButton;
	private JButton searchButton;
	
	public ChatPanel(ChatbotController appController) {
		super();
		this.appController = appController;		
		baseLayout = new SpringLayout();
		inputField = new JTextField(25);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 408, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 7, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -103, SpringLayout.EAST, this);
		searchButton = new JButton("Search",new ImageIcon(getClass().getResource("images/search.png")));
		chatButton = new JButton("Enter", new ImageIcon(getClass().getResource("images/chat.png")));
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -46, SpringLayout.SOUTH, this);
		saveButton = new JButton("Save",new ImageIcon(getClass().getResource("images/save.png")));
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -22, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -93, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, searchButton, -6, SpringLayout.WEST, saveButton);
		loadButton = new JButton("Load",new ImageIcon(getClass().getResource("images/load.png")));
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, -22, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, chatButton);
		//colorButton = new JButton("Change Color", new ImageIcon(getClass().getResource("search/donut.png")));
		randomButton = new JButton("Tweet", new ImageIcon(getClass().getResource("images/twitt.png")));
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, randomButton, 336, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, randomButton, -6, SpringLayout.WEST, searchButton);
		checkerButton = new JButton("Checker");
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, 0, SpringLayout.SOUTH, checkerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, checkerButton, 6, SpringLayout.SOUTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -13, SpringLayout.EAST, this);
		scrollPane = new JScrollPane();
		face = new JLabel(new ImageIcon(getClass().getResource("images/donut.png")));
		baseLayout.putConstraint(SpringLayout.NORTH, face, 129, SpringLayout.NORTH, this);
	
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	private void setupPanel() {		
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		
		this.add(chatButton);
		this.add(scrollPane);
		this.add(randomButton);
		this.add(checkerButton);
		//this.add(colorButton);
		this.add(inputField);
		this.add(face);
		this.add(saveButton);
		this.add(loadButton);
		this.add(searchButton);
		
		chatArea = new JTextArea(10,10);
		baseLayout.putConstraint(SpringLayout.EAST, face, -62, SpringLayout.WEST, scrollPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 232, SpringLayout.WEST, scrollPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -6, SpringLayout.NORTH, scrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, chatButton);
		//add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setText(appController.sendIntro());
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
	}
	private void setupLayout() {

	}
	//adds a JScrollPane so that it may scroll down the chatArea
	private void setupScrollPane() {
		scrollPane.setViewportView(chatArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	//buttons and the enter key is used here
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				getInput();
				setTextArea(getInput());
				inputField.setText("");
			}
		});
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getInput();
					setTextArea(getInput());
					inputField.setText("");
				}
			}
		});
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				addRandomText();
			}
		});
		checkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
	}
	//a method to grab the user input probably not needed
	private String getInput() {
		String userInput = "";
		userInput = inputField.getText();
		return userInput;
	}
	//set the text areas
	private void setTextArea(String inp) {
		chatArea.append("You: " + getInput() + "\n" + "\n" + appController.interactWithChatbot(inp) + "Time: " + appController.getTime() + "\n");
	}
	private void setRandomColor() {
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		this.setBackground(new Color(red,green,blue));
	}
	private void addRandomText() {
		chatArea.append(appController.randomOutput() + "Time: " + appController.getTime() + "\n");
	}
}

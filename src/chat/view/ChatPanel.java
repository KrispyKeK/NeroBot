package chat.view;

import chat.controller.ChatbotController;
import chat.model.Chatbot;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
	private JScrollPane scrollPane;
	
	public ChatPanel(ChatbotController appController) {
		super();
		this.appController = appController;		
		baseLayout = new SpringLayout();
		inputField = new JTextField(25);
		chatButton = new JButton("Enter");
		colorButton = new JButton("Change Color");
		randomButton = new JButton("Random Answer");	
		checkerButton = new JButton("Checker");
		scrollPane = new JScrollPane();
		face = new JLabel(new ImageIcon(getClass().getResource("images/nero.png")));
	
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	private void setupPanel() {		
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		
		chatArea = new JTextArea(10,10);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setText(appController.sendIntro());
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		this.add(chatButton);
		this.add(scrollPane);
		this.add(randomButton);
		this.add(checkerButton);
		this.add(colorButton);
		this.add(inputField);
		this.add(face);
		
	}
	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.WEST, face, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, colorButton, 349, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, colorButton, -19, SpringLayout.NORTH, inputField);		
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 349, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, randomButton, -19, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -19, SpringLayout.NORTH, randomButton);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, face);
		baseLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, face, -93, SpringLayout.WEST, checkerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, checkerButton, 349, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -19, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 406, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -13, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, face, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, face, -6, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, randomButton, 0, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, colorButton, -6, SpringLayout.WEST, randomButton);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -8, SpringLayout.WEST, colorButton);
	}
	private void setupScrollPane() {
		scrollPane.setViewportView(chatArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				getInput();
				setTextArea(getInput());
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
	private String getInput() {
		String userInput = "";
		userInput = inputField.getText();
		return userInput;
	}
	private void setTextArea(String inp) {
		chatArea.append("You: " + getInput() + "\n" + "\n" + appController.interactWithChatbot(inp) + "\n" + "\n" + "\n" + appController.getTime());
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

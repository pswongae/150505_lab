package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.*;

import base.Post;
import base.User;

public class BlogGUI{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame mainFrame;
	private JLabel inputCharLabel;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	
	private Blog myBlog;
	private User user;
	
	private int maxTextLen = 140;
	
	public BlogGUI(){
		
		user = new User(1, "User", "user@email.com");
		myBlog = new Blog(user);
		
		myBlog.load("D:/"+user.getUserName()+".blog");
	}
	
	public void setWindow(int width, int height){
		
		mainFrame = new JFrame("Micro Blog Demo");
		mainFrame.setSize(width, height);
		mainFrame.setLayout(new GridLayout(0, 1));
		mainFrame.setLocationByPlatform(true);
		
		Container contentPane;
		contentPane = mainFrame.getContentPane();
		
		int borderWidth = 8;
		
		JPanel top = new JPanel();
		top.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, 0, borderWidth));
		top.setLayout(new BorderLayout());
		
		inputCharLabel = new JLabel("You can still input " + maxTextLen + " Characters");
		top.add(inputCharLabel, BorderLayout.NORTH);
		
		postTextArea = new JTextArea(1, 140);
		postTextArea.setBackground(new Color(255, 255, 204));
		postTextArea.setLineWrap(true);	
		postTextArea.setDocument(new lengthListener());
		postTextArea.addKeyListener(new lengthListener());
		JScrollPane scrollPane1 = new JScrollPane(postTextArea);
		top.add(scrollPane1, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2));
		refresh = new JButton("refresh");
		refresh.addActionListener(new refreshListener());
		refresh.setBackground(new Color(153, 153, 255));
		buttonPanel.add(refresh);
		post = new JButton("post");
		post.addActionListener(new postListener());
		post.setBackground(new Color(153, 204, 255));
		buttonPanel.add(post);
		top.add(buttonPanel, BorderLayout.SOUTH);
		
		contentPane.add(top);
		
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createEmptyBorder(0, borderWidth, borderWidth, borderWidth));
		bottom.setLayout(new BorderLayout());
		postContent = new JTextArea("Here is my Blog");
		postContent.setEditable(false);
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);
		JScrollPane scrollPane2 = new JScrollPane(postContent);
		bottom.add(scrollPane2);
		
		contentPane.add(bottom);
		
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
	}

	public static void main(String[] args){
		
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow(400, 400);
		
	}
	
	private class postListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String content = postTextArea.getText();
			
			// TODO whether the post is empty
			if (content.isEmpty()){
				return;
			}
			
			// TODO whether the length of the post has exceeded 140
			if (content.length() > maxTextLen){
				return;
			}
			
			// TODO add the post to the file
			Date date = new Date();
			Post post = new Post(date, content);
			myBlog.post(post);
			myBlog.save("D:/"+user.getUserName()+".blog");
			
			// TODO display the post in the display area and clear the edit area
			postContent.setText("Post: " + date + "\n" + content + "\n");
			postTextArea.setText("");
			
		}
		
	}
	
	private class refreshListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			myBlog.load("D:/"+user.getUserName()+".blog");
			
			int i = 1;
			postContent.setText("");
			for (Post p : myBlog.getPosts()){
				postContent.append("Post [" + i + "] : " + p.getDate() + "\n" + p.getContent() + "\n");
				i++;
			}
			
		}
		
	}
	
	private class lengthListener extends PlainDocument implements KeyListener{

		private void updateTextArea(){
			int remTextLen = maxTextLen - postTextArea.getText().length();
			if (remTextLen >= 0){
				inputCharLabel.setText("You can still input " + remTextLen + " Characters");
			} else{
				inputCharLabel.setText("Your post length has exceeded " + maxTextLen +"!");
			}
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			updateTextArea();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			updateTextArea();
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			updateTextArea();
		}
/*
		@Override
		public void insertString(int offs, String str, AttributeSet attr) throws BadLocationException {
			if(getLength() + str.length() <= maxTextLen){
				super.insertString(offs, str, attr);
			}
		}
*/
	}
	
}

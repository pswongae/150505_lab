package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import base.*;
import blog.Blog;

public class TestBlog {

	private String getInput() {
		// TODO Auto-generated method stub
		String line = "";
		System.out.print("Enter the prompt:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			if (prompt.startsWith("list")){
				myblog.list();
			} else if (prompt.startsWith("post")){
				Date date = new Date();
				String content = prompt.substring(5);
				Post post = new Post(date, content);
				myblog.post(post);
			} else if (prompt.startsWith("delete")){
				int index = Integer.parseInt(prompt.substring(7));
				myblog.delete(index);
			}
		}
	}
}

	

package blog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import base.*;

public class Blog implements Serializable{
	
	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user) {
		super();
		this.user = user;
		allPosts = new ArrayList<Post>();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void post(Post p){
		if (allPosts.add(p)){
			System.out.println("A new Post:");
			System.out.println(p.getDate());
			System.out.println(p.getContent());
		}
		
	}
	
	public void list(){
		System.out.println("Current posts:");
		int i=1;
		for (Post p : allPosts){
			System.out.println("Post[" + i + "]:" + p.getDate());
			System.out.println(p.getContent());
			i++;
		}
		
	}
	
	public void delete(int index){
		if (index>=1 && index<=allPosts.size()){
			allPosts.remove(index-1);
		} else{
			System.out.println("Illegal deletion.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Blog [user=" + user + ", allPosts=" + allPosts + "]";
	}
	
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		for (Post p : allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if (postMonth+1 == month && p.getContent().contains("@"+someone))
				System.out.println(p);
		}
	}

	public void setPosts(ArrayList<Post> allposts2) {
		// TODO Auto-generated method stub
		allPosts = allposts2;
	}

	public ArrayList<Post> getPosts() {
		return allPosts;
	}

	public void save(String filepath) {
		try {
			FileOutputStream fs = new FileOutputStream(filepath);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load(String filepath){
		try {
			FileInputStream is = new FileInputStream(filepath);
			ObjectInputStream os = new ObjectInputStream(is);
			Blog blog = (Blog) os.readObject();
			setUser(blog.getUser());
			setPosts(blog.getPosts());
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e.getClass().isInstance(new FileNotFoundException())){
				System.out.println("Wait! There is something wrong. I cannot find the file.");
			}
			//e.printStackTrace();
		}
	}
	
}

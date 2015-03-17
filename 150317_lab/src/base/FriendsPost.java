package base;

import java.util.Date;

public class FriendsPost extends Post{

	private User friend;
	
	public FriendsPost(Date date, String content) {
		super(date, content);
		// TODO Auto-generated constructor stub
	}

	public FriendsPost(Date date, String content, User user) {
		// TODO Auto-generated constructor stub
		super(date, content);
		friend = user;
	}

}

package base;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable{
	
	private int userId;
	private String userName;
	private String userEmail;
	/**
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String name, String email) {
		super();
		this.userId = id;
		this.userName = name;
		this.userEmail = email;
		//System.out.println(this);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return userId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.userId = id;
	}
	/**
	 * @return the name
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.userName = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return userEmail;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.userEmail = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + "]";
	}
	@Override
	public int compareTo(User u) {
		// TODO Auto-generated method stub
		if (this.getId() > u.getId())
			return 1;
		else if (this.getId() < u.getId())
			return -1;
		else 
			return 0;
	}
	
	
}

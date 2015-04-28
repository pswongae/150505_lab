package base;
import java.io.Serializable;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable{
	
	private Date date;
	private String content;
	
	/**
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content) {
		super();
		this.date = date;
		this.content = content;
		//System.out.println(date);
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return getDate() + "\n" + getContent();
	}
	/**
	 * @param arg0
	 * @return boolean
	 */
//	public boolean equals(Object arg0) {
//		boolean ans = true;
//		if (this==arg0){
//			return ans;
//		}
//		if (arg0!=null && this.getClass()==arg0.getClass()){
//			Post post = (Post) arg0;
//			if (post.content!=null && !this.content.equals(post.getContent()))
//				ans = false;
//			if (post.date!=null && !this.date.equals(post.date))
//				ans = false;
//		} else{
//			ans = false;
//		}
//		return ans;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	/**
	 * @param s
	 * @return
	 * @see java.lang.String#contains(java.lang.CharSequence)
	 */
	public boolean contains(String keyword) {
		return content.contains(keyword);
	}

	@Override
	public int compareTo(Post p) {
		// TODO Auto-generated method stub
		return this.getDate().compareTo(p.getDate());
	}

}

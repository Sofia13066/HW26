package telran.forum.model;

import java.time.LocalDateTime;

public class Post implements Comparable<Post> {
    String author;
    int postId;
    String title;
    String content;
    LocalDateTime date;
    int likes;

    public Post(String author, int postId, String title, String content, LocalDateTime date, int likes) {
        this.author = author;
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
        this.likes = 0;
      }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + postId;
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
        Post other = (Post) obj;
        if (postId != other.postId)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Post [author=" + author + ", content=" + content + ", date=" + date + ", likes=" + likes + ", postId="
                + postId + ", title=" + title + "]";
    }

    public int addLike() {
        return 0;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getAuthor() {
        return author;
    }
    public int getPostId() {
        return postId;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public int getLikes() {
        return likes;
    }
    
    @Override
  public int compareTo(Post o) {
    return date.compareTo(o.getDate());
  }
}

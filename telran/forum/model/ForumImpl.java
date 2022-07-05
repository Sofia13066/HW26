package telran.forum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class ForumImpl implements Forum{
    private Post[] posts;
    private int size;

    public ForumImpl(int size) {
        this.posts = new Post[size];
      }


    @Override
    public boolean addPost(Post post) {
        if (size == posts.length || post == null
				|| getPostById(post.getPostId()) != null) {
			return false;
		}
		posts[size++] = post;
		return true;
    }
    @Override
    public Post[] getPostByAuthor(String author) {
        Post[] postsByAuthor = new Post[size];
        Post pattern = new Post(author, 0, null, null, null, 0);
        int j = 0;
		for (int i = 0; i < size; i++) {
			if (posts[i].getAuthor().equals(pattern.getAuthor())) {
				// posts[i] = posts[++size];
				// posts[size] = posts[i];
                postsByAuthor[j++] = posts[i];
			}

            
		}
        return Arrays.copyOf(postsByAuthor, j);
	}
    
    @Override
    public Post[] getPostByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post[] postsByAuthor = new Post[size];
        Post pattern = new Post(author, 0, null, null, null, 0);
        int j = 0;
		for (int i = 0; i < size; i++) {
			if (posts[i].getAuthor().equals(pattern.getAuthor()) && posts[i].getDate().isAfter(dateFrom.atStartOfDay()) 
            && posts[i].getDate().isBefore(LocalDateTime.of(dateTo, LocalTime.MAX))) {
                postsByAuthor[j++] = posts[i];
			}
            
		}
		return Arrays.copyOf(postsByAuthor, j);
    }
    @Override
    public Post getPostById(int postId) {
        Post pattern = new Post(null, postId, null, null, null, 0);
		for (int i = 0; i < size; i++) {
			if (pattern.equals(posts[i])){
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public boolean removePost(int postId) {
        Post pattern = new Post(null, postId, null, null, null, 0);
		for (int i = 0; i < size; i++) {
			if (pattern.equals(posts[i])) {
				posts[i] = posts[size];
                size--;
				posts[size] = null;
				return true;
			}
		}
		return false;
    }
    @Override
    public int size() {

        return size;
    }
    @Override
    public boolean updatePost(int postId, String newContent) {
        Post pattern = new Post(null, postId, null, null, null, 0);
		for (int i = 0; i < size; i++) {
			if (pattern.equals(posts[i])) {
				
                posts[i].setContent(newContent);
                return true;
			}
		}
		return false;
    }

    
}

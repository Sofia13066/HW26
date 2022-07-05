package telran.forum.model;

import java.time.LocalDate;

public interface Forum {
    boolean addPost(Post post);
    boolean removePost(int postId);
    boolean updatePost(int postId, String newContent);
    Post getPostById(int postId);
    Post[] getPostByAuthor(String author);
    Post[] getPostByAuthor(String author, LocalDate dateFrom, LocalDate dateTo);
    int size();
}
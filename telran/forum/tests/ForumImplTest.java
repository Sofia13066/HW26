package telran.forum.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.forum.model.ForumImpl;
import telran.forum.model.Post;

public class ForumImplTest {
    ForumImpl forum = new ForumImpl(5);
    LocalDateTime now = LocalDateTime.now();
    Comparator<Post> comp = (p1, p2) -> Integer.compare(p1.getPostId(), p2.getPostId());
    Post[] posts = new Post[5];

    @BeforeEach 
    void setup() throws Exception {
        LocalDateTime time1 = LocalDateTime.of(2016, 4, 4, 18, 20, 01);
        LocalDateTime time2 = LocalDateTime.of(2021, 2, 20, 11, 12, 29);
        LocalDateTime time3 = LocalDateTime.of(2022, 3, 2, 18, 20, 03);
        LocalDateTime time4 = LocalDateTime.of(2017, 3, 2, 18, 20, 03);
        LocalDateTime time5 = LocalDateTime.of(2018, 7, 25, 12, 15, 03);
        
        posts[0] = new Post("Add", 01, "jem1", "asdfghjk", time1, 0);
        posts[1] = new Post("Addi", 02, "jem2", "asdfghjk", time2, 1);
        posts[2] = new Post("Adda", 03, "jem3", "asdfghjk", time3, 2);
        posts[3] = new Post("Addi", 04, "jem4", "asdfghjk", time4, 3);
        // posts[4] = new Post("Add", 05, "jem5", "asdfghjk", time5, 4);
        // posts[5] = new Post("Addo", 06, "jem6", "asdfghjk", time1, 5);
        for (int i = 0; i < 4; i++) {
            forum.addPost(posts[i]);
          }
    }

    @Test
    void testAddPost() {
        assertFalse(forum.addPost(posts[1]));
        assertFalse(forum.addPost(posts[0]));
        assertFalse(forum.addPost(posts[3]));
    }

    @Test
    void testGetPostByAuthor() {
        Post[] expected = { posts[1], posts[3] };
    forum.addPost(posts[3]);
    Post[] actual = forum.getPostByAuthor("Addi");
    for (int i = 0; i < actual.length; i++){System.out.println(actual[i]);}
    assertArrayEquals(expected, actual);
    
    }

    @Test
    void testGetPostByAuthor2() {

    }

    @Test
    void testGetPostById() {
        assertEquals(posts[0], forum.getPostById(01));
    }

    @Test
    void testRemovePost() {
        forum.removePost(3);
        assertEquals(3, forum.size());
    }

    @Test
    void testSize() {
        assertEquals(4, forum.size());
    }

    @Test
    void testUpdatePost() {

    }
}

package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class User {
    private String id;
    private Blog blog;

    public User(String id) {
        this.id = id;
        this.blog = null;
    }

    public Blog createBlog() {
        this.blog = new Blog(this);
        return this.blog;
    }

    /*
    public Post createPost(String title, String content) {
        Post post = new Post(this, title, content);
        return post;
    }

    public void setTagFilterToBlog(Blog blog, HashSet<String> tags) {
        blog.setTagFilter(tags);
    }

    public void setAuthorFilterToBlog(Blog blog, String author) {
        blog.setAuthorFilter(author);
    }

    public void setSortingTypeToBlog(Blog blog, Blog.SortingType sortingType) {
        blog.setSortingType(sortingType);
    }

    public boolean addTagToPost(Post post, HashSet<String> tags) {
        boolean ret;

        ret = post.addTag(this, tags);
        return ret;
    }

    public Comment createComment(String content) {
        Comment comment = new Comment(this, content);
        return comment;
    }

    public Comment createSubComment(String content) {
        Comment subComment = new Comment(this, content);
        return subComment;
    }

    public void addCommentToPost(Post post, Comment comment) {
        post.addComment(comment);
    }

    public void addSubCommentToComment(Comment comment, Comment subcomment) {
        comment.addSubComment(subcomment);
    }

    public void upVoteToComment(Comment comment) {
        comment.upVote(this);
    }

    public void downVoteToComment(Comment comment) {
        comment.downVote(this);
    }

    public void addReactionToPost(Post post, Post.EmojiType emojiType) {
        post.addReaction(this, emojiType);
    }

    public void removeReactionToPost(Post post, Post.EmojiType emojiType) {
        post.removeReaction(this, emojiType);
    }

    public ArrayList<Reaction> getReactionFromPost(Post post) {
        return post.getReactions();
    }

    public ArrayList<Post> getPostsFromBlog(Blog blog) {
        return blog.getPosts();
    }

    public ArrayList<Comment> getCommentsFromPost(Post post) {
        return post.getComments();
    }

    public ArrayList<Comment> getSubCommentsFromComment(Comment comment) {
        return comment.getSubComments();
    }

    public void modifyPostTitle(Post post, String title) {
        post.modifyTitle(this, title);
    }

    public void modifyPostContent(Post post, String content) {
        post.modifyContent(this, content);
    }

    public void modifyCommentContent(Comment comment, String content) {
        comment.modifyCommentContent(this, content);
    }

    public void modifySubCommentContent(Comment subcomment, String content) {
        subcomment.modifyCommentContent(this, content);
    }
    */

    public String getId() {
        return this.id;
    }
}

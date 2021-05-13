package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private User user;
    private String content;
    private int popularity;

    private ArrayList<Comment> subComments;
    private ArrayList<User> upVoteUsers;
    private ArrayList<User> downVoteUsers;

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
        this.subComments = new ArrayList<Comment>();
        this.upVoteUsers = new ArrayList<User>();
        this.downVoteUsers = new ArrayList<User>();
    }

    public boolean addSubComment(Comment comment) {
        if (this.subComments.contains(comment)) {
            return false;
        }

        this.subComments.add(comment);
        return true;
    }

    public ArrayList<Comment> getSubComments() {
        sortSubComments();
        return this.subComments;
    }

    public boolean upVote(User user) {
        if (this.upVoteUsers.contains(user)) {
            return false;
        }

        this.upVoteUsers.add(user);
        ++(this.popularity);
        return true;
    }

    public boolean downVote(User user) {
        if (this.downVoteUsers.contains(user)) {
            return false;
        }

        this.downVoteUsers.add(user);
        --(this.popularity);
        return true;
    }

    public User getUser() {
        return this.user;
    }

    public String getContent() {
        return this.content;
    }

    public boolean modifyCommentContent(User user, String content) {
        if (!user.getId().equals(this.user.getId())) {
            return false;
        }

        this.content = content;
        return true;
    }

    public int getPopularity() {
        return this.popularity;
    }

    private void sortSubComments() {
        for (int i = this.subComments.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Comment curSubComment = this.subComments.get(j);
                Comment afterSubComment = this.subComments.get(j + 1);
                if (curSubComment.getPopularity() < afterSubComment.getPopularity()) {
                    this.subComments.set(j, afterSubComment);
                    this.subComments.set(j + 1, curSubComment);
                }
            }
        }
    }
}
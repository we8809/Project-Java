package academy.pocu.comp2500.assignment1;

public class Reaction {
    private User user;
    private Post.EmojiType emojiType;

    public Reaction(User user, Post.EmojiType emojiType) {
        this.user = user;
        this.emojiType = emojiType;
    }

    public User getUser() {
        return this.user;
    }

    public Post.EmojiType getEmojiType() {
        return this.emojiType;
    }
}

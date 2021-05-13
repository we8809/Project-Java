package academy.pocu.comp2500.assignment1;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;

public class Post {
    public enum EmojiType {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    private User user;
    private String title;
    private String content;

    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    private HashSet<String> tags;
    private ArrayList<Comment> comments;
    private ArrayList<Reaction> reactions;

    public Post(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<Comment>();
        this.tags = new HashSet<String>();
        this.createdAt = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        this.modifiedAt = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        this.reactions = new ArrayList<Reaction>();
    }

    public String getTitle() {
        return this.title;
    }

    public boolean modifyTitle(User user, String title) {
        if (!user.getId().equals(this.user.getId())) {
            return false;
        }

        this.title = title;
        this.modifiedAt = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        return true;
    }

    public String getContent() {
        return this.content;
    }

    public boolean modifyContent(User user, String content) {
        if (!user.getId().equals(this.user.getId())) {
            return false;
        }

        this.content = content;
        this.modifiedAt = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        return true;
    }

    public HashSet<String> getTags() {
        return this.tags;
    }

    public boolean addTag(User user, HashSet<String> tags) {
        if (!user.getId().equals(this.user.getId())) {
            return false;
        }

        this.tags.addAll(tags);
        return true;
    }

    public User getUser() {
        return this.user;
    }

    public boolean addComment(Comment comment) {
        if (this.comments.contains(comment)) {
            return false;
        }

        this.comments.add(comment);
        return true;
    }

    public ArrayList<Comment> getComments() {
        sortComments();
        return this.comments;
    }

    public boolean addReaction(User user, EmojiType emojiType) {
        if (containsReactionOrNull(user, emojiType) != null) {
            return false;
        }

        Reaction reaction = new Reaction(user, emojiType);
        this.reactions.add(reaction);

        return true;
    }

    public boolean removeReaction(User user, EmojiType emojiType) {
        Reaction reaction = containsReactionOrNull(user, emojiType);

        if (reaction == null) {
            return false;
        }

        this.reactions.remove(reaction);
        return true;
    }

    public ArrayList<Reaction> getReactions() {
        return this.reactions;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    private void sortComments() {
        for (int i = this.comments.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Comment curComment = this.comments.get(j);
                Comment afterComment = this.comments.get(j + 1);
                if (curComment.getPopularity() < afterComment.getPopularity()) {
                    this.comments.set(j, afterComment);
                    this.comments.set(j + 1, curComment);
                }
            }
        }
    }

    private Reaction containsReactionOrNull(User user, EmojiType emojiType) {
        String userId = user.getId();

        for (Reaction comparedReaction : this.reactions) {
            if (comparedReaction.getUser().getId().equals(userId)) {
                if (comparedReaction.getEmojiType().equals(emojiType)) {
                    return comparedReaction;
                }
            }
        }

        return null;
    }
}

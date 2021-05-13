package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setTagFilter");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilter");
        registry.registerPostOrderSetter("Blog", "setSortingType");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "modifyTitle");
        registry.registerPostBodyUpdater("Post", "modifyContent");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubComment");
        registry.registerCommentUpdater("Comment", "modifyCommentContent");
        registry.registerSubcommentUpdater("Comment", "modifyCommentContent");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "upVote");
        registry.registerCommentDownvoter("Comment", "downVote");
        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubComments");
        registry.registerSubcommentUpvoter("Comment", "upVote");
        registry.registerSubcommentDownvoter("Comment", "downVote");
    }
}

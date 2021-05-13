package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;
import academy.pocu.comp2500.assignment1.registry.Registry;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

public class Program {

    public static void main(String[] args) {
	    // write your code here


        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();


        //AddBlogPostTest();
        //BlogGetPostsTest();
        //BlogPostsFilterWithTagTest();
        //BlogPostsFilterWithAuthorTest();
        //BlogPostsReduplicationFilterTest();
        //BlogPostsSortingTest();
        //BlogPostAddCommentTest();
        //BlogPostModifyTitleOrContentTest();
        //SubCommentTest();
        CommentUpdaterTest();
        //BlogPostAddReactionTest();
    }

    public static void AddBlogPostTest() {
        User user1 = new User("we456123");
        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        blog.addPost(post1);

        ArrayList<Post> posts = user1.getPostsFromBlog(blog);
        for (Post post : posts) {
            System.out.println(String.format("author => [%s]", post.getUser().getId()));
            System.out.println(String.format("title => [%s]", post.getTitle()));
        }
    }

    public static void BlogGetPostsTest() {
        User user1 = new User("we456123");
        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        sleep(1000);
        Post post2 = user1.createPost("Computer Architecture", "ALU is compute formula");
        sleep(1000);
        Post post3 = user1.createPost("Spanish", "Ola bomboncita!");

        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);

        ArrayList<Post> posts = user1.getPostsFromBlog(blog);

        System.out.println(String.format("생성 일시 순으로 정렬돼있나요?"));
        for (Post post : posts) {
            System.out.println(String.format("author: [%s] / title: [%s]", post.getUser().getId(), post.getTitle()));
        }
    }

    public static void BlogPostsFilterWithTagTest() {
        User user1 = new User("we456123");
        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        sleep(100);
        Post post2 = user1.createPost("Computer Architecture", "ALU is compute formula");
        sleep(100);
        Post post3 = user1.createPost("Spanish", "Ola bomboncita!");
        sleep(100);
        Post post4 = user1.createPost("Balenciaga", "tote");

        HashSet<String> tags = new HashSet<String>();
        tags.add("Computer");
        user1.addTagToPost(post1, tags);
        user1.addTagToPost(post2, tags);

        tags.clear();
        tags.add("Language");
        user1.addTagToPost(post3, tags);

        tags.clear();
        tags.add("Clothes");
        user1.addTagToPost(post4, tags);

        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);
        blog.addPost(post4);

        System.out.println(String.format("리스트 출력"));
        ArrayList<Post> posts = user1.getPostsFromBlog(blog);
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s], tag: [%s]", post.getUser().getId(), post.getTitle(), post.getTags()));
        }
        System.out.println();

        System.out.println(String.format("태그 필터 적용 => [Computer]"));
        tags.clear();
        tags.add("Computer");
        blog.setTagFilter(tags);
        posts = user1.getPostsFromBlog(blog);
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s], tag: [%s]", post.getUser().getId(), post.getTitle(), post.getTags()));
        }
        System.out.println();

        System.out.println(String.format("태그 필터 적용 => [Computer, Language]"));
        tags.add("Language");
        blog.setTagFilter(tags);
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s], tag: [%s]", post.getUser().getId(), post.getTitle(), post.getTags()));
        }
        System.out.println();

        System.out.println(String.format("태그 필터 적용 => [Clothes]"));
        tags.clear();
        tags.add("Clothes");
        blog.setTagFilter(tags);
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s], tag: [%s]", post.getUser().getId(), post.getTitle(), post.getTags()));
        }
        System.out.println();

        System.out.println(String.format("태그 필터 초기화 및 출력"));
        tags.clear();
        blog.setTagFilter(tags);
        posts = user1.getPostsFromBlog(blog);
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s], tag: [%s]", post.getUser().getId(), post.getTitle(), post.getTags()));
        }
    }

    public static void BlogPostsFilterWithAuthorTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jong-gyung");
        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        sleep(100);
        Post post2 = user1.createPost("Computer Architecture", "ALU is compute formula");
        sleep(100);
        Post post3 = user2.createPost("Spanish", "Ola bomboncita!");
        sleep(100);
        Post post4 = user2.createPost("Love", "Love is fantastic");
        sleep(100);
        Post post5 = user3.createPost("Dolce-Gavana", "Cloth is fantastic");
        sleep(100);

        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);
        blog.addPost(post4);
        blog.addPost(post5);

        System.out.println(String.format("작성자 필터 적용 => [we456123]"));
        blog.setAuthorFilter(user1.getId());
        ArrayList<Post> posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("작성자 필터 적용 => [gusdldi300]"));
        blog.setAuthorFilter(user2.getId());
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("작성자 필터 적용 => [jong-gyung]"));
        blog.setAuthorFilter(user3.getId());
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("작성자 필터 초기화 및 리스트 출력"));
        blog.setAuthorFilter("");
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();
    }

    public static void BlogPostsReduplicationFilterTest() {
        HashSet<String> tagFilters = new HashSet<String>();
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jong-gyung");
        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        Post post2 = user2.createPost("Computer Architecture", "ALU is compute formula");
        Post post3 = user1.createPost("Spanish", "Ola bomboncita!");
        Post post4 = user2.createPost("Love", "Love is fantastic");
        Post post5 = user3.createPost("Dolce-Gavana", "Cloth is fantastic");
        Post post6 = user1.createPost("Sad", "Sad is blue");

        HashSet<String> tags = new HashSet<String>();
        tags.add("Computer");
        user1.addTagToPost(post1, tags);
        user2.addTagToPost(post2, tags);

        tags.clear();
        tags.add("Language");
        user1.addTagToPost(post3, tags);

        tags.clear();
        tags.add("Human");
        user2.addTagToPost(post4, tags);
        user1.addTagToPost(post6, tags);

        tags.clear();
        tags.add("Clothes");
        user3.addTagToPost(post5, tags);


        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);
        blog.addPost(post4);
        blog.addPost(post5);
        blog.addPost(post6);

        System.out.println(String.format("작성자 필터 적용 => [we456123], 태그 필터 적용 => [Computer]"));
        blog.setAuthorFilter(user1.getId());
        tagFilters.add("Computer");
        blog.setTagFilter(tagFilters);

        ArrayList<Post> posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("작성자 필터 적용 => [we456123], 태그 필터 적용 => [Language]"));
        blog.setAuthorFilter(user1.getId());
        tagFilters.clear();
        tagFilters.add("Language");
        blog.setTagFilter(tagFilters);

        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("작성자 필터 적용 => [we456123], 태그 필터 적용 => [Language, Human]"));
        blog.setAuthorFilter(user1.getId());
        tagFilters.add("Human");
        blog.setTagFilter(tagFilters);

        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();
    }

    public static void BlogPostsSortingTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jong-gyung");
        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        sleep(100);
        Post post2 = user2.createPost("Computer Architecture", "ALU is compute formula");sleep(100);
        sleep(100);
        Post post3 = user1.createPost("Spanish", "Ola bomboncita!");
        sleep(100);
        Post post4 = user2.createPost("Love", "Love is fantastic");
        sleep(100);
        Post post5 = user3.createPost("Dolce-Gavana", "Cloth is fantastic");
        sleep(100);
        Post post6 = user1.createPost("Sad", "Sad is blue");
        sleep(100);

        HashSet<String> tags = new HashSet<String>();
        tags.add("Computer");
        user1.addTagToPost(post1, tags);
        user2.addTagToPost(post2, tags);

        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);
        blog.addPost(post4);
        blog.addPost(post5);
        blog.addPost(post6);

        System.out.println(String.format("CREATED_ASCENDING sort"));
        blog.setSortingType(Blog.SortingType.CREATED_ASCENDING);
        ArrayList<Post> posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("CREATED_DESCENDING sort"));
        blog.setSortingType(Blog.SortingType.CREATED_DESCENDING);
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("TITLE_ASCENDING sort"));
        blog.setSortingType(Blog.SortingType.TITLE_ASCENDING);
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("MODIFIED_DESCENDING sort"));
        blog.setSortingType(Blog.SortingType.MODIFIED_DESCENDING);

        user1.modifyPostTitle(post1, "Embedded Linux");
        sleep(100);
        user1.modifyPostTitle(post2, "Linux Driver Development");
        sleep(100);

        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();

        System.out.println(String.format("MODIFIED_DESCENDING sort"));
        blog.setSortingType(Blog.SortingType.MODIFIED_DESCENDING);

        sleep(100);
        user2.modifyPostTitle(post2, "Linux Driver Development");

        tags.clear();
        tags.add("Computer");
        blog.setTagFilter(tags);

        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("author: [%s], title: [%s]", post.getUser().getId(), post.getTitle()));
        }
        System.out.println();
    }

    public static void BlogPostAddCommentTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jonggyung");

        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        blog.addPost(post1);

        Comment comment1 = user2.createComment("Good!");
        Comment comment2 = user2.createComment("So so?");
        Comment comment3 = user3.createComment("Bad..");

        post1.addComment(comment1);
        post1.addComment(comment2);
        post1.addComment(comment3);

        user3.upVoteToComment(comment3);
        user3.upVoteToComment(comment3);
        user2.upVoteToComment(comment3);
        user1.upVoteToComment(comment2);
        user2.upVoteToComment(comment2);
        user1.downVoteToComment(comment2);
        user1.upVoteToComment(comment1);
        user2.upVoteToComment(comment1);
        user3.upVoteToComment(comment1);

        ArrayList<Comment> comments = post1.getComments();
        System.out.println(String.format("3.7 블로그 글에 댓글 달기 / 3.10: 댓글을 추천, 비추천하기"));
        for (Comment comment : comments) {
            System.out.println(String.format("content: [%s]", comment.getContent()));
        }
    }

    public static void BlogPostModifyTitleOrContentTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");

        Blog blog = user1.createBlog();

        System.out.println(String.format("3.10 블로그 글 업데이트하기"));
        Post post1 = user1.createPost("Computer Science", "computer is good!");
        sleep(100);
        Post post2 = user1.createPost("Computer Architecture", "ALU is compute formula");
        sleep(100);
        Post post3 = user1.createPost("Spanish", "Ola bomboncita!");
        sleep(100);
        Post post4 = user1.createPost("Love", "Love is fantastic");
        sleep(100);

        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);
        blog.addPost(post4);

        System.out.println(String.format("1. 어떤 글의 제목을 바꾼다"));
        user1.modifyPostTitle(post1, "Linux Programming");
        blog.setSortingType(Blog.SortingType.MODIFIED_DESCENDING);
        ArrayList<Post> posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("title: [%s], content: [%s]", post.getTitle(), post.getContent()));
        }
        System.out.println();

        System.out.println(String.format("2. 어떤 글의 본문을 바꾼다"));
        sleep(100);
        user2.modifyPostContent(post4, "Love is so Sad");
        posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(String.format("title: [%s], content: [%s]", post.getTitle(), post.getContent()));
        }
    }

    public static void SubCommentTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jonggyung");

        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        blog.addPost(post1);

        Comment comment1 = user1.createComment("Good!");
        Comment subComment1 = user2.createComment("I think too!");
        Comment subComment2 = user3.createComment("No I don't think so..");

        post1.addComment(comment1);
        comment1.addSubComment(subComment1);
        comment1.addSubComment(subComment2);

        subComment2.upVote(user1);
        subComment2.upVote(user2);


        System.out.println(String.format("subComment2's popularity => %d", subComment2.getPopularity()));

        System.out.println("SubComment test!");
        ArrayList<Comment> subComments = comment1.getSubComments();
        for (Comment subComment : subComments) {
            System.out.println(String.format("SubComment: id = [%s], content = [%s]", subComment.getUser().getId(), subComment.getContent()));
        }
        System.out.println();
    }

    public static void CommentUpdaterTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jonggyung");

        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        blog.addPost(post1);

        Comment comment1 = user1.createComment("Good!");

        Comment subComment1 = user2.createComment("I think too!");
        Comment subComment2 = user3.createComment("No I don't think so..");

        post1.addComment(comment1);

        comment1.addSubComment(subComment1);
        comment1.addSubComment(subComment2);

        subComment1.modifyCommentContent(user1, "Ansan City!");

        System.out.println("CommentUpdater Test!");
        ArrayList<Comment> subComments = comment1.getSubComments();
        for (Comment subComment : subComments) {
            System.out.println(String.format("SubComment: id = [%s], content = [%s]", subComment.getUser().getId(), subComment.getContent()));
        }
        System.out.println();

        subComment1.modifyCommentContent(user2, "Ansan City!");

        System.out.println("CommentUpdater Test!");
        subComments = comment1.getSubComments();
        for (Comment subComment : subComments) {
            System.out.println(String.format("SubComment: id = [%s], content = [%s]", subComment.getUser().getId(), subComment.getContent()));
        }
        System.out.println();
    }

    public static void BlogPostAddReactionTest() {
        User user1 = new User("we456123");
        User user2 = new User("gusdldi300");
        User user3 = new User("jonggyung");

        Blog blog = user1.createBlog();

        Post post1 = user1.createPost("Computer Science", "computer is good!");
        blog.addPost(post1);

        user1.removeReactionToPost(post1, Post.EmojiType.ANGRY);
        user1.addReactionToPost(post1, Post.EmojiType.GREAT);
        user1.addReactionToPost(post1, Post.EmojiType.GREAT);
        user1.addReactionToPost(post1, Post.EmojiType.GREAT);
        user1.removeReactionToPost(post1, Post.EmojiType.GREAT);

        System.out.println(String.format("3.11: 블로그 글에 리액션 달기"));
    }

    private static void sleep(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
        }
    }
}

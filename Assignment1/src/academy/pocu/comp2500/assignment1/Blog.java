package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Blog {
    public enum SortingType {
        CREATED_ASCENDING,
        CREATED_DESCENDING,
        MODIFIED_ASCENDING,
        MODIFIED_DESCENDING,
        TITLE_ASCENDING
    }

    private User user;
    private ArrayList<Post> posts;
    private ArrayList<Post> postsWithTag;
    private ArrayList<Post> postsWithAuthor;
    private SortingType sortingType;

    private HashSet<String> tagFilters;
    private String authorFilter;
    private boolean isTagFilterSet;
    private boolean isAuthorFilterSet;

    public Blog(User user) {
        this.user = user;
        this.posts = new ArrayList<Post>();
        this.postsWithTag = new ArrayList<Post>();
        this.postsWithAuthor = new ArrayList<Post>();
        this.tagFilters = new HashSet<String>();
        this.sortingType = SortingType.CREATED_DESCENDING;
    }

    public boolean addPost(Post post) {
        if (this.posts.contains(post)) {
            return false;
        }

        this.posts.add(post);

        if (this.isTagFilterSet && !this.isAuthorFilterSet) {
            setTagFilter(this.tagFilters);
        } else if (!this.isTagFilterSet && this.isAuthorFilterSet) {
            setAuthorFilter(this.authorFilter);
        } else if (this.isTagFilterSet && this.isAuthorFilterSet) {
            setTagFilter(this.tagFilters);
            setAuthorFilter(this.authorFilter);
        }

        return true;
    }

    public ArrayList<Post> getPosts() {
        if (this.isTagFilterSet && !this.isAuthorFilterSet) {
            return this.postsWithTag;
        } else if (!this.isTagFilterSet && this.isAuthorFilterSet) {
            return this.postsWithAuthor;
        } else if (this.isTagFilterSet && this.isAuthorFilterSet) {
            ArrayList<Post> posts = new ArrayList<Post>();
            for (Post post : this.postsWithTag) {
                if (this.postsWithAuthor.contains(post)) {
                    posts.add(post);
                }
            }
            return posts;
        }

        setPostListSorting(this.posts);
        return this.posts;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public void setTagFilter(HashSet<String> tags) {
        this.tagFilters = tags;
        Iterator<String> tagsIt = tags.iterator();

        if (tags.isEmpty()) {
            this.isTagFilterSet = false;
            this.postsWithTag.clear();
            return;
        }

        this.postsWithTag.clear();
        for (Post post : this.posts) {
            HashSet<String> postTags = post.getTags();
            Iterator<String> postTagsIt = postTags.iterator();

            while (tagsIt.hasNext()) {
                String tag = tagsIt.next();

                for (int i = 0; i < postTags.size(); i++) {
                    if (tag.equals(postTagsIt.next())) {
                        this.postsWithTag.add(post);
                    }
                }

                postTagsIt = postTags.iterator();
            }

            tagsIt = tags.iterator();
        }

        this.isTagFilterSet = true;
    }

    public void setAuthorFilter(String id) {
        this.authorFilter = id;

        if (id == null) {
            this.isAuthorFilterSet = false;
            this.postsWithAuthor.clear();
            return;
        }

        this.postsWithAuthor.clear();
        for (Post post : posts) {
            if (id.equals(post.getUser().getId())) {
                this.postsWithAuthor.add(post);
            }
        }

        this.isAuthorFilterSet = true;
    }

    public User getUser() {
        return this.user;
    }

    private void setPostListSorting(ArrayList<Post> posts) {
        switch (this.sortingType) {
            case CREATED_ASCENDING:
                for (int i = posts.size() - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        Post curPost = posts.get(j);
                        Post afterPost = posts.get(j + 1);
                        if (posts.get(j).getCreatedAt().isAfter(posts.get(j + 1).getCreatedAt())) {
                            posts.set(j, afterPost);
                            posts.set(j + 1, curPost);
                        }
                    }
                }
                break;
            case CREATED_DESCENDING:
                for (int i = posts.size() - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        Post curPost = posts.get(j);
                        Post afterPost = posts.get(j + 1);
                        if (posts.get(j).getCreatedAt().isBefore(posts.get(j + 1).getCreatedAt())) {
                            posts.set(j, afterPost);
                            posts.set(j + 1, curPost);
                        }
                    }
                }
                break;
            case MODIFIED_ASCENDING:
                for (int i = posts.size() - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        Post curPost = posts.get(j);
                        Post afterPost = posts.get(j + 1);
                        if (posts.get(j).getModifiedAt().isAfter(posts.get(j + 1).getModifiedAt())) {
                            posts.set(j, afterPost);
                            posts.set(j + 1, curPost);
                        }
                    }
                }
                break;
            case MODIFIED_DESCENDING:
                for (int i = posts.size() - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        Post curPost = posts.get(j);
                        Post afterPost = posts.get(j + 1);
                        if (posts.get(j).getModifiedAt().isBefore(posts.get(j + 1).getModifiedAt())) {
                            posts.set(j, afterPost);
                            posts.set(j + 1, curPost);
                        }
                    }
                }
                break;
            case TITLE_ASCENDING:
                for (int i = posts.size() - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        Post curPost = posts.get(j);
                        Post afterPost = posts.get(j + 1);
                        int ret = posts.get(j).getTitle().compareTo(posts.get(j + 1).getTitle());
                        if (ret > 0) {
                            posts.set(j, afterPost);
                            posts.set(j + 1, curPost);
                        }
                    }
                }
                break;
            default:
                assert (false) : "Unrecognized Sorting Type";
                break;
        }
    }
}

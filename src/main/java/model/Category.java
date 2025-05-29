package model;

public class Category {

    private Integer category_id;
    private String title;
    private String description;

    public Category() {
    }

    public Category(Integer category_id, String title, String description) {
        this.category_id = category_id;
        this.title = title;
        this.description = description;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package model;

public class Product {

    private Integer product_id;
    private String title;
    private String description;
    private String img_url;
    private Double starting_bid;
    private Double current_bid;
    private Double closing_bid;
    private Category category_id;
    private Auction auction_id;

    public Product() {
    }

    public Product(Auction auction_id, Category category_id, Double closing_bid, Double current_bid, Double starting_bid, String img_url, String description, String title, Integer product_id) {
        this.auction_id = auction_id;
        this.category_id = category_id;
        this.closing_bid = closing_bid;
        this.current_bid = current_bid;
        this.starting_bid = starting_bid;
        this.img_url = img_url;
        this.description = description;
        this.title = title;
        this.product_id = product_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Double getStarting_bid() {
        return starting_bid;
    }

    public void setStarting_bid(Double starting_bid) {
        this.starting_bid = starting_bid;
    }

    public Double getCurrent_bid() {
        return current_bid;
    }

    public void setCurrent_bid(Double current_bid) {
        this.current_bid = current_bid;
    }

    public Double getClosing_bid() {
        return closing_bid;
    }

    public void setClosing_bid(Double closing_bid) {
        this.closing_bid = closing_bid;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Auction getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Auction auction_id) {
        this.auction_id = auction_id;
    }
}

package model;

import java.time.LocalDate;

public class Auction {

    private Integer auction_id;
    private User user;
    private String title;
    private Integer status;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;

    public Auction() {
    }

    public Auction(Integer auction_id, User user, String title, Integer status, String description, LocalDate start_date, LocalDate end_date) {
        this.auction_id = auction_id;
        this.user = user;
        this.title = title;
        this.status = status;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Integer getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Integer auction_id) {
        this.auction_id = auction_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auction_id=" + auction_id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }


}

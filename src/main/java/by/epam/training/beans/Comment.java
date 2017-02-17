package by.epam.training.beans;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Package: by.epam.training.beans
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    @Basic(optional = false)
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    @Column(name = "message")
    private String message;

    public Comment(User user, Date datetime, String message) {
        this.user = user;
        this.datetime = datetime;
        this.message = message;
    }

    public Comment() {
        this(new User(),new Date(),"");
    }

    public int getId() {
        return id;
    }

    public Comment setId(int id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Comment setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDatetime() {
        return datetime;
    }

    public Comment setDatetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Comment setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(user, comment.user) &&
                Objects.equals(datetime, comment.datetime) &&
                Objects.equals(message, comment.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, datetime, message);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", datetime=").append(datetime);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

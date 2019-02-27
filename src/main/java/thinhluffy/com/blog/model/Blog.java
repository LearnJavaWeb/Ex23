package thinhluffy.com.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String context;
    private String author;

    public Blog(){

    }

    public Blog(String name, String context, String author) {
        this.name = name;
        this.context = context;
        this.author = author;
    }
    @Override
    public String toString(){
        return String.format("Blog[id=%d,name='%s',context='%s',author='%s']",id,name,context,author);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

package models;

import jakarta.persistence.*;

@Entity
@Table(name = "Product", schema = "dbo", catalog = "db_a93859_java")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int Id;
    protected String Name;
    public Product(){}
    public Product(String name){
        this.Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

}

package models;
import jakarta.persistence.*;
@Entity
@Table(name = "Users", schema = "dbo", catalog = "vbu011")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String Name;
    public String Password;
    public User(){}
    public User(String name, String password){
        this.Name = name;
        this.Password = password;
    }
    public String getName() {
        return Name;
    }
    public int getId() {
        return Id;
    }
    public String getPassword() {
        return Password;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPassword(String password) {
        Password = password;
    }
    @Override
    public String toString() {
        return "{'id':" + Id
                + ", 'name':\"" + Name + "\""
                + ", 'password':\"" + Password + "\"" + "}";
    }
}

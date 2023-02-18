package Models;

public class Category {
    protected int Id;
    protected String Name;
    protected int Rating;
    public Category(int id, String name, int rating){
        Id = id;
        Name = name;
        Rating = rating;
    }

    public int getId() {
        return Id;
    }

    public int getRating() {
        return Rating;
    }

    @Override
    public String toString() {
        return "{'id':" + Id
                + ", 'name':\"" + Name + "\""
                + ", 'rating':" + Rating + "}";
    }
}

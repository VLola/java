package Models;

public class Product {
    protected int Id;
    protected String Name;
    protected double Price;
    protected double Weight;
    protected Category Category;
    protected Manufacturer Manufacturer;
    public Product(int id, String name, double price, double weight, Category category, Manufacturer manufacturer){
        Id = id;
        Name = name;
        Price = price;
        Weight = weight;
        Category = category;
        Manufacturer = manufacturer;
    }

    public double getPrice() {
        return Price;
    }

    public double getWeight() {
        return Weight;
    }

    public Manufacturer getManufacturer() {
        return Manufacturer;
    }

    public Category getCategory() {
        return Category;
    }

    @Override
    public String toString() {
        return "{'id':" + Id
                + ", 'name':\"" + Name + "\""
                + ", 'price':" + Price
                + ", 'weight':" + Weight
                + ", 'category':" + Category
                + ", 'manufacturer':" + Manufacturer + "}";
    }
}

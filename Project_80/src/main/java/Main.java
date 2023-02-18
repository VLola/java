import Models.Category;
import Models.Manufacturer;
import Models.Product;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static ArrayList<Manufacturer> Manufacturers = new ArrayList<Manufacturer>();
    public static ArrayList<Category> Categories = new ArrayList<Category>();
    public static ArrayList<Product> Products = new ArrayList<Product>();
    public static void WriteResultToFile(){
        JSONArray json = new JSONArray();

        json.putAll(Task1());
        json.putAll(Task2());
        json.putAll(Task3(0));
        json.putAll(Task4());
        json.putAll(Task5());
        json.putAll(Task6());
        json.putAll(Task7());
        Product[] products = { Task8() };
        json.putAll(products);
        json.putAll(Task9());
        try(FileWriter writer = new FileWriter("res.json", false))
        {
            writer.write(json.toString(4));
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void WriteToFile(){
        JSONArray json = new JSONArray();

        json.putAll(Task1());
        try(FileWriter writer = new FileWriter("mydb.json", false))
        {
            writer.write(json.toString(4));
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static double getAveragePrice(){
        double average = Products.stream().map(Product::getPrice).mapToDouble(a -> a).average().orElse(0.0);
        System.out.println("average: " + average);
        return average;
    }
    public static Manufacturer getManufacturerMinRating(){
        Manufacturer manufacturer = Manufacturers.stream().min(Comparator.comparing(Manufacturer::getRating)).orElse(null);
        System.out.println("manufacturer min rating: " + manufacturer);
        return manufacturer;
    }
    public static Category getCategoryMinRating(){
        Category category = Categories.stream().min(Comparator.comparing(Category::getRating)).orElse(null);
        System.out.println("category min rating: " + category);
        return category;
    }
    public static Category getCategoryMaxRating(){
        Category category = Categories.stream().max(Comparator.comparing(Category::getRating)).orElse(null);
        System.out.println("category max rating: " + category);
        return category;
    }
    public static Category getCategory(int id){
        return Categories.stream().filter(c->c.getId() == id).findFirst().orElse(null);
    }
    public static Manufacturer getManufacturer(int id){
        return Manufacturers.stream().filter(c->c.getId() == id).findFirst().orElse(null);
    }
    public static void main(String[] args) {
        Manufacturers.add(new Manufacturer(0, "Ukraine", 8));
        Manufacturers.add(new Manufacturer(1, "Germany", 3));
        Manufacturers.add(new Manufacturer(2, "Poland", 5));

        Categories.add(new Category(0, "Fruit", 3));
        Categories.add(new Category(1, "Fish", 6));
        Categories.add(new Category(2, "Meat", 4));
        Categories.add(new Category(3, "Sweet", 7));
        Categories.add(new Category(4, "Dairy", 5));

        Products.add(new Product(0, "Apple", 4, 300, getCategory(0), getManufacturer(0) ));
        Products.add(new Product(0, "Apple", 3.5, 300, getCategory(0), getManufacturer(1) ));
        Products.add(new Product(0, "Apple", 6, 300, getCategory(0), getManufacturer(2) ));
        Products.add(new Product(0, "Carp", 110, 400, getCategory(1), getManufacturer(0) ));
        Products.add(new Product(0, "Carp", 125, 400, getCategory(1), getManufacturer(1) ));
        Products.add(new Product(0, "Carp", 130, 400, getCategory(1), getManufacturer(2) ));
        Products.add(new Product(0, "Pork", 180, 1000, getCategory(2), getManufacturer(0) ));
        Products.add(new Product(0, "Pork", 190, 1000, getCategory(2), getManufacturer(1) ));
        Products.add(new Product(0, "Pork", 210, 1000, getCategory(2), getManufacturer(2) ));
        Products.add(new Product(0, "Candy", 150, 300, getCategory(3), getManufacturer(0) ));
        Products.add(new Product(0, "Candy", 165, 300, getCategory(3), getManufacturer(1) ));
        Products.add(new Product(0, "Candy", 185, 300, getCategory(3), getManufacturer(2) ));
        Products.add(new Product(0, "Milk", 25, 1000, getCategory(4), getManufacturer(0) ));
        Products.add(new Product(0, "Milk", 30, 1000, getCategory(4), getManufacturer(1) ));
        Products.add(new Product(0, "Milk", 35, 1000, getCategory(4), getManufacturer(2) ));

        Scanner console = new Scanner(System.in);
        while(true){
            System.out.println("1 - Print all products");
            System.out.println("2 - Print all categories");
            System.out.println("3 - Products from selected manufacturers");
            System.out.println("4 - Products under $100");
            System.out.println("5 - Продукты ниже средней цены в списке среди всех категорий");
            System.out.println("6 - Продукты ниже средней цены в списке среди самой НЕ популярной категорий");
            System.out.println("7 - Продукты самого не популярного производителя в самой популярной категорий");
            System.out.println("8 - Продукт весом до 1кг (случайный)");
            System.out.println("9 - Продукты ценой от 1$ до 5$ и весом до 500 грамм");
            System.out.println("10 - Записать все в файл формате json (имя файла - mydb.json)");
            System.out.println("11 - Записать результаты работы 3-го блока в отдельный файл (имя файла - res.json)");
            int number = console.nextInt();
            if(number == 1) Task1().forEach(product -> System.out.println(product.toString()));
            else if(number == 2) Task2().forEach(category -> System.out.println(category.toString()));
            else if(number == 3) {
                console = new Scanner(System.in);
                Manufacturers.forEach(m->System.out.println(m.getId() + " - " + m.getName()));
                System.out.println("select number manufacturer:");
                number = console.nextInt();
                Task3(number).forEach(product -> System.out.println(product.toString()));
            }
            else if(number == 4) Task4().forEach(product -> System.out.println(product.toString()));
            else if(number == 5) Task5().forEach(product -> System.out.println(product.toString()));
            else if(number == 6) Task6().forEach(product -> System.out.println(product.toString()));
            else if(number == 7) Task7().forEach(product -> System.out.println(product.toString()));
            else if(number == 8) System.out.println(Task8());
            else if(number == 9) Task9().forEach(product -> System.out.println(product.toString()));
            else if(number == 10) WriteToFile();
            else if(number == 11) WriteResultToFile();
        }
    }
    static ArrayList<Product> Task1(){
        return Products;
    }
    static ArrayList<Category> Task2(){
        return Categories;
    }
    static List<Product> Task3(int number){
        return Products.stream().filter(p->p.getManufacturer().getId() == number).toList();
    }
    static List<Product> Task4(){
        return Products.stream().filter(p->p.getPrice() < 100).toList();
    }
    static List<Product> Task5(){
        double average = getAveragePrice();
        return Products.stream().filter(p->p.getPrice() < average).toList();
    }
    static List<Product> Task6(){
        Category category = getCategoryMinRating();
        double average = getAveragePrice();
        return Products.stream().filter(p->p.getPrice() < average && p.getCategory() == category).toList();
    }
    static List<Product> Task7(){
        Category category = getCategoryMaxRating();
        Manufacturer manufacturer = getManufacturerMinRating();
        return Products.stream().filter(p->p.getManufacturer() == manufacturer && p.getCategory() == category).toList();
    }
    static Product Task8(){
        List<Product> list = Products.stream().filter(p->p.getWeight() < 1000).toList();
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
    static List<Product> Task9(){
        return Products.stream().filter(p->p.getPrice() > 1 && p.getPrice() < 5 && p.getWeight() < 500).toList();
    }
}
package controllers;

import models.Product;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private ProductController productController = new ProductController();
    public void getAll(){
        List<Product> products = productController.getAll();
        for (var product: products) {
            System.out.println(product.getName());
        }
    }
    public void getName(){
        List<Product> products = Get();
        if(products != null){
            for (var product: products) {
                System.out.println(product.getName());
            }
        }
    }
    public void save(){
        System.out.println("enter name");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        productController.save(new Product(name));
    }
    public void delete(){
        List<Product> products = Get();
        if(products != null && products.stream().count() > 0){
            productController.delete(products.get(0));
        }
    }
    private List<Product> Get(){
        System.out.println("enter name");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        return productController.getName(name);
    }
}

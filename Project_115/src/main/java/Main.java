import controllers.MainController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MainController mainController = new MainController();

        while (true){
            System.out.println("1 - all products");
            System.out.println("2 - search products");
            System.out.println("3 - save product");
            System.out.println("4 - delete product");
            Scanner console = new Scanner(System.in);
            int number = console.nextInt();
            if (number == 1) mainController.getAll();
            else if(number == 2) mainController.getName();
            else if(number == 3) mainController.save();
            else if(number == 4) mainController.delete();
        }
    }
}
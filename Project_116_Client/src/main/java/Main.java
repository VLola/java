import controllers.MainController;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true) {
            MainController.Load();
        }
    }
}
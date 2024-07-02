import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.factory.Factory;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.ui.Menu;
import com.trainingmug.foodiecli.util.CsvReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DishAlreadyExistsException {

        Menu menu = new Menu();
        menu.displayMainMenu();


    }
}
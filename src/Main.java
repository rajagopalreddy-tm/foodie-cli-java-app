import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.ui.Dashboard;

public class Main {
    public static void main(String[] args) throws RestaurantNotFoundException, DishNotFoundException {

        Dashboard  dashboard = new Dashboard();
        dashboard .displayDashboard();

    }
}
import com.trainingmug.foodiecli.util.CsvReader;

public class Main {
    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader();

        System.out.println(csvReader.readDishListFromCsv());
        System.out.println(csvReader.readCustomerListFromCsv());
        System.out.println(csvReader.readRestaurantListFromCsv());

    }
}
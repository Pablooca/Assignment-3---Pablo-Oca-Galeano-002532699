/* 
    Thanks to Alejandro, Pilar and Gonzalo from Group 4 of Pablo de Olavide,
    for contributing the proyect.
 */
import Database.Database;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class main {

    private static final String filePathCentralDatabase = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Universidad\\Erasmus\\Data Intensive Systems\\Assignment 3 BBDD1.sql";
    private static final String filePathPortugalDatabase = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Universidad\\Erasmus\\Data Intensive Systems\\Assignment 3 BBDD2.sql";
    private static final String filePathSpainDatabase = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Universidad\\Erasmus\\Data Intensive Systems\\Assignment 3 BBDD3.sql";

    public static void menu() {
        System.out.println("Select an option:\n\t1. Print all the data for a place\n\t2. Execute a query\n\t0. Exit");
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Database.dropDatabase("upofitnesscentral");
        Database.dropDatabase("upofitnessspain");
        Database.dropDatabase("upofitnessportugal");
        Database.createDatabase(filePathCentralDatabase);
        Database.createDatabase(filePathPortugalDatabase);
        Database.createDatabase(filePathSpainDatabase);

        int option;

        do {
            menu();

            option = read.nextInt();

            if (option == 1) {
                System.out.println("Select the place: \n\t\t1. Central Database\n\t\t2. Spain Database\n\t\t3. Portugal Database");
                int place = read.nextInt();
                List lista = Database.obtainData(place);

                Iterator iter = lista.iterator();
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            }
            if (option == 2) {
                String query;
                String database_to_execute;

                read.nextLine();

                System.out.println("Introduce the query");
                query = read.nextLine();

                read.reset();

                System.out.println("Introduce the database");
                database_to_execute = read.nextLine();

                List result = Database.executeQuery(query, database_to_execute);

                if (result != null) {
                    Iterator iter = result.iterator();
                    while (iter.hasNext()) {
                        System.out.println(iter.next());
                    }
                }

            }
        } while (option != 0);

    }

}

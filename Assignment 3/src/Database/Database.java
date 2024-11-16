package Database;

import Entities.centralDatabase.Product;
import Entities.centralDatabase.Product_category;
import Entities.centralDatabase.Shipment;
import Entities.centralDatabase.Supplier;
import Entities.centralDatabase.Warehouse;
import Entities.countriesDatabase.Appointment;
import Entities.countriesDatabase.Client;
import Entities.countriesDatabase.Employee;
import Entities.countriesDatabase.Gym;
import Entities.countriesDatabase.Payment;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Database {

    private static String urlCentral = "jdbc:mysql://localhost:3308/upofitnesscentral?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static String urlPortugal = "jdbc:mysql://localhost:3308/upofitnessportugal?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static String urlSpain = "jdbc:mysql://localhost:3308/upofitnessspain?zeroDateTimeBehavior=CONVERT_TO_NULL";

    private static String login = "root";
    private static String password = "";

    private static Connection connection = null;
    private static ResultSet res = null;
    private static Statement stmt = null;

    public static Connection createConnection(String url) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (java.lang.InstantiationException e) {
            System.out.println(e);
        } catch (java.lang.IllegalAccessException e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void createDatabase(String filePath) {
        String url = "jdbc:mysql://localhost:3308";

        try {
            Path path = Paths.get(filePath);

            List<String> lines = Files.readAllLines(path);
            StringBuilder sql = new StringBuilder();
            for (String line : lines) {
                sql.append(line).append("\n");
            }

            connection = createConnection(url);

            Statement statement = connection.createStatement();

            String[] sqlStatements = sql.toString().split(";");

            for (String sqlStatement : sqlStatements) {
                if (!sqlStatement.trim().isEmpty()) {
                    statement.execute(sqlStatement);
                }
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List obtainData(int option) {
        String query = "SELECT * FROM gym";
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        List<Gym> gyms = new ArrayList<Gym>();
        try {
            switch (option) {
                case 1:
                    connection = createConnection(urlCentral);
                    stmt = connection.createStatement();
                    query = "SELECT * FROM warehouse";
                    break;
                case 2:
                    connection = createConnection(urlSpain);
                    stmt = connection.createStatement();
                    break;
                case 3:
                    connection = createConnection(urlPortugal);
                    stmt = connection.createStatement();
                    break;
                default:
                    break;
            }

            res = stmt.executeQuery(query);

            while (res.next()) {
                if (option == 1) {
                    int id = res.getInt("id");
                    String location = res.getString("location");
                    Warehouse warehouse = new Warehouse(id, location);
                    warehouses.add(warehouse);
                }
                if (option == 2 || option == 3) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String address = res.getString("address");
                    String city = res.getString("city");
                    String phoneNumber = res.getString("phone_number");
                    String email = res.getString("email");
                    String schedule = res.getString("Schedule");
                    int maxCapacity = res.getInt("max_capacity");

                    Gym gym = new Gym(id, name, address, city, phoneNumber, email, schedule, maxCapacity);

                    gyms.add(gym);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                stmt.close();
                connection.close();
                if (option == 1) {
                    return warehouses;
                } else {
                    return gyms;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public static void dropDatabase(String databaseName) {
        String query = "DROP DATABASE " + databaseName + ";";
        connection = createConnection("jdbc:mysql://localhost:3308");
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static List executeQuery(String query, String database) {
        List res = null;
        connection = null;
        stmt = null;
        switch (database) {
            case "upofitnesscentral":
                connection = createConnection(urlCentral);
                break;
            case "upofitnessspain":
                connection = createConnection(urlSpain);
                break;
            case "upofitnessportugal":
                connection = createConnection(urlPortugal);
                break;
            default:
                break;
        }

        if (query.contains("SELECT")) {
            try {
                stmt = connection.createStatement();
                stmt.executeQuery(query);
                if (query.contains("warehouse")) {
                    ResultSet result = stmt.getResultSet();
                    List<Warehouse> list = warehouses(result);
                    return list;
                } else if (query.contains("product_category")) {
                    ResultSet result = stmt.getResultSet();
                    List<Product_category> list = productCategories(result);
                    return list;
                } else if (query.contains("supplier")) {
                    ResultSet result = stmt.getResultSet();
                    List<Supplier> list = suppliers(result);
                    return list;
                } else if (query.contains("product")) {
                    ResultSet result = stmt.getResultSet();
                    List<Product> list = products(result);
                    return list;
                } else if(query.contains("shipment")){
                    ResultSet result = stmt.getResultSet();
                    List<Shipment> list = shipments(result);
                    return list;
                } else if (query.contains("gym")) {
                    ResultSet result = stmt.getResultSet();
                    List<Gym> list = gyms(result, database);
                    return list;
                } else if (query.contains("client")) {
                    ResultSet result = stmt.getResultSet();
                    List<Client> list = clients(result);
                    return list;
                } else if (query.contains("employee")) {
                    ResultSet result = stmt.getResultSet();
                    List<Employee> list = employees(result, database);
                    return list;
                } else if (query.contains("appointment")) {
                    ResultSet result = stmt.getResultSet();
                    List<Appointment> list = appointments(result, database);
                    return list;
                } else if (query.contains("payment")) {
                    ResultSet result = stmt.getResultSet();
                    List<Payment> list = payments(result, database);
                    return list;
                }
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (query.contains("UPDATE")) {
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (query.contains("DELETE")) {
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (query.contains("INSERT")) {
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return res;
    }

    public static List suppliers(ResultSet res) {
        List<Supplier> result = new ArrayList();
        try {
            while (res.next()) {
                try {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String country = res.getString("country");
                    String phoneNumber = res.getString("phone_number");
                    String email = res.getString("email");
                    String payment_method = res.getString("payment_method");
                    Supplier supp = new Supplier(id, name, country, phoneNumber, email, payment_method);
                    result.add(supp);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            return result;
        }
    }

    public static List products(ResultSet res) {
        List<Product> result = new ArrayList();
        Warehouse warehouse = null;
        Product_category category = null;
        Supplier supplier = null;
        try {
            while (res.next()) {
                try {
                    int id = res.getInt("id");
                    float price = res.getFloat("price");
                    String description = res.getString("description");
                    int warehouseId = res.getInt("warehouse_id");
                    int categoryId = res.getInt("category_id");
                    int supplierId = res.getInt("supplier_id");
                    Connection connection1 = createConnection(urlCentral);
                    Connection connection2 = createConnection(urlCentral);
                    Connection connection3 = createConnection(urlCentral);
                    Statement stmt1 = connection1.createStatement();
                    Statement stmt2 = connection2.createStatement();
                    Statement stmt3 = connection3.createStatement();
                    String query1 = "SELECT * FROM warehouse WHERE id=" + warehouseId + ";";
                    String query2 = "SELECT * FROM product_category WHERE id=" + categoryId + ";";
                    String query3 = "SELECT * FROM supplier WHERE id=" + supplierId + ";";
                    ResultSet resul1 = stmt1.executeQuery(query1);
                    ResultSet resul2 = stmt2.executeQuery(query2);
                    ResultSet resul3 = stmt3.executeQuery(query3);
                    while (resul1.next()) {
                        String location = resul1.getString("location");
                        warehouse = new Warehouse(warehouseId, location);
                    }
                    while (resul2.next()) {
                        String name = resul2.getString("name");
                        String descriptionCategory = resul2.getString("description");
                        category = new Product_category(categoryId, name, descriptionCategory);
                    }
                    while (resul3.next()) {
                        String name = resul3.getString("name");
                        String country = resul3.getString("country");
                        String phone_number = resul3.getString("phone_number");
                        String email = resul3.getString("email");
                        String paymentMethod = resul3.getString("payment_method");
                        supplier = new Supplier(supplierId, name, country, phone_number, email, paymentMethod);
                    }
                    Product product = new Product(id, price, description, warehouse, category, supplier);
                    result.add(product);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static List warehouses(ResultSet res) {
        List<Warehouse> result = new ArrayList();

        try {
            while (res.next()) {
                int id = res.getInt("id");
                String location = res.getString("location");
                Warehouse warehouse = new Warehouse(id, location);
                result.add(warehouse);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static List productCategories(ResultSet res) {
        List<Product_category> result = new ArrayList();

        try {
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String description = res.getString("description");
                Product_category category = new Product_category(id, name, description);
                result.add(category);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public static List shipments(ResultSet res){
        List<Shipment> result = new ArrayList();
        
        try {
            while(res.next()){
                int id = res.getInt("id");
                String address = res.getString("shipping_address");
                Date date = res.getDate("shipping_date");
                String trackingNumber = res.getString("tracking_number");
                Date deliveryDate = res.getDate("delivery_date");
                Shipment shipment = new Shipment(id, address, date, trackingNumber, deliveryDate);
                result.add(shipment);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return result;
    }

    public static List gyms(ResultSet res, String database) {
        List<Gym> result = new ArrayList();

        try {
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String address = res.getString("address");
                String city = res.getString("city");
                String phoneNumber = res.getString("phone_number");
                String email = res.getString("email");
                String schedule = res.getString("schedule");
                int maxCapacity = res.getInt("max_capacity");
                Gym gym = new Gym(id, name, address, city, phoneNumber, email, schedule, maxCapacity);
                result.add(gym);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static List clients(ResultSet res) {
        List<Client> result = new ArrayList();

        try {
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String surname = res.getString("surname");
                Date birth_date = res.getDate("birth_date");
                String city = res.getString("city");
                String phoneNumber = res.getString("phone_number");
                String email = res.getString("email");
                Date inscriptionDate = res.getDate("inscription_date");
                String membershipType = res.getString("membership_type");
                String paymentMethod = res.getString("payment_method");
                Client client = new Client(id, name, surname, birth_date, city, phoneNumber, email, inscriptionDate, membershipType, paymentMethod);
                result.add(client);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static List employees(ResultSet res, String database) {
        List<Employee> result = new ArrayList();
        Gym gym = null;
        try {
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String surname = res.getString("surname");
                int gymId = res.getInt("gym_id");
                gym = obtainGym(gymId, database);
                Employee employee = new Employee(id, name, surname, gym);
                result.add(employee);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static List appointments(ResultSet res, String database) {
        List<Appointment> result = new ArrayList();
        Client client = null;
        Employee employee = null;
        try {
            while (res.next()) {
                int id = res.getInt("id");
                int clientId = res.getInt("client_id");
                int employeeId = res.getInt("employee_id");
                Date dateHour = res.getDate("date_hour");
                int length = res.getInt("length");
                String type = res.getString("type");
                client = obtainClient(clientId, database);
                employee = obtainEmployee(employeeId, database);
                Appointment appointment = new Appointment(id, client, employee, dateHour, length, type);
                result.add(appointment);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static List payments(ResultSet res, String database) {
        List<Payment> result = new ArrayList();
        Client client = null;
        try {
            while (res.next()) {
                int id = res.getInt("id");
                int clientId = res.getInt("client_id");
                Date paymentDay = res.getDate("payment_day");
                float amount = res.getFloat("amount");
                String method = res.getString("method");
                client = obtainClient(clientId, database);
                Payment payment = new Payment(id, client, paymentDay, amount, method);
                result.add(payment);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static Gym obtainGym(int gymId, String database) {
        Gym gym = null;
        try {
            String query = "SELECT * FROM gym WHERE id=" + gymId + ";";
            if (database.equals("upofitnessspain")) {
                connection = createConnection(urlSpain);
            } else if (database.equals("upofitnessportugal")) {
                connection = createConnection(urlPortugal);
            }
            stmt = connection.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                String name = res.getString("name");
                String address = res.getString("address");
                String city = res.getString("city");
                String phoneNumber = res.getString("phone_number");
                String email = res.getString("email");
                String schedule = res.getString("schedule");
                int maxCapacity = res.getInt("max_capacity");
                gym = new Gym(gymId, name, address, city, phoneNumber, email, schedule, maxCapacity);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return gym;
    }

    public static Employee obtainEmployee(int employeeId, String database) {
        Employee employee = null;
        try {

            String query = "SELECT * FROM employee WHERE id=" + employeeId + ";";

            if (database.equals("upofitnessspain")) {
                connection = createConnection(urlSpain);
            } else if (database.equals("upofitnessportugal")) {
                connection = createConnection(urlPortugal);
            }

            stmt = connection.createStatement();
            res = stmt.executeQuery(query);

            while(res.next()){
                String name = res.getString("name");
                String surname = res.getString("surname");
                int gymId = res.getInt("gym_id");
                Gym gym = obtainGym(gymId, database);
                employee = new Employee(employeeId, name, surname, gym);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return employee;
    }
    
    public static Client obtainClient(int clientId, String database){
        Client client = null;
        try {
            if (database.equals("upofitnessspain")){
                connection = createConnection(urlSpain);
            } else if(database.equals("upofitnessportugal")){
                connection = createConnection(urlPortugal);
            }
            String query = "SELECT * FROM client WHERE id=" + clientId + ";";
            stmt = connection.createStatement();
            res = stmt.executeQuery(query);
            
            while(res.next()){
                String name = res.getString("name");
                String surname = res.getString("surname");
                Date birthDate = res.getDate("birth_date");
                String city = res.getString("city");
                String phoneNumber = res.getString("phone_number");
                String email = res.getString("email");
                Date inscriptionDate = res.getDate("inscription_date");
                String membershipType = res.getString("membership_type");
                String paymentMethod = res.getString("payment_method");
                client = new Client(clientId, name, surname, birthDate, city, phoneNumber, email, inscriptionDate, membershipType, paymentMethod);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return client;
    }

}

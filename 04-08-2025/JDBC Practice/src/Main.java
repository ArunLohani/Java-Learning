import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/Employee";
        String user = "postgres";
        String pass = "argusadmin";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Scanner sc = new Scanner(System.in)
        ) {

            System.out.println("Connected to the database!");

            conn.setAutoCommit(false);
            // 1. DATABASE METADATA
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("UserName: " + dbmd.getUserName());
            // 2. FETCH DATA with Statement
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");
            System.out.println("Employee Table:");
            System.out.println("ID\tNAME\tEMAIL\tSALARY\tDEPARTMENT");
            // 3. RESULT SET METADATA
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Column Count: " + rsmd.getColumnCount());
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println("Column Name " + i + ": " + rsmd.getColumnName(i));
                System.out.println("Column Type " + i + ": " + rsmd.getColumnTypeName(i));
            }
            while (rs.next()) {
                System.out.println(
                        rs.getInt("empid") + "\t" +
                                rs.getString("empName") + "\t" +
                                rs.getString("email") + "\t" +
                                rs.getFloat("salary") + "\t" +
                                rs.getString("department")
                );
            }
            // 4. INSERTING DATA USING PREPARED STATEMENT
            String insertSQL = "INSERT INTO Employee(empName, email, salary, department) VALUES(?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(insertSQL)) {
                System.out.println("\nInsert a new employee:");
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Email: ");
                String email = sc.nextLine();
                System.out.print("Enter Salary: ");
                float salary = Float.parseFloat(sc.nextLine());
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setFloat(3, salary);
                pst.setString(4, dept);
                int rowsInserted = pst.executeUpdate();
                System.out.println(rowsInserted + " row inserted.");
                // 5. BATCH INSERT USING PREPARED STATEMENT
                while (true) {
//
                    System.out.println("\nEnter employee for batch insert:");
                    System.out.print("Enter Name: ");
                    String bName = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String bEmail = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    float bSalary = Float.parseFloat(sc.nextLine());
                    System.out.print("Enter Department: ");
                    String bDept = sc.nextLine();
                    pst.setString(1, bName);
                    pst.setString(2, bEmail);
                    pst.setFloat(3, bSalary);
                    pst.setString(4, bDept);
                    pst.addBatch();
                    System.out.print("Add another? (yes/no): ");
                    String choice = sc.nextLine();
                    if (!choice.equals("yes")) break;
                }
                int[] batchResults = pst.executeBatch();
                System.out.println("Batch insert completed. Rows inserted: " + batchResults.length);
            }

            conn.commit();

            //REVERSE DISPLAY
            rs.beforeFirst();  // move cursor before first
            System.out.println("\nPrinting in reverse:");
            rs.afterLast(); // move cursor after last
            while (rs.previous()) {
                System.out.println(
                        rs.getInt("empid") + "\t" +
                                rs.getString("empName") + "\t" +
                                rs.getString("email") + "\t" +
                                rs.getFloat("salary") + "\t" +
                                rs.getString("department")
                );
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}






















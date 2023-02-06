package chapter34;

import java.sql.*;

public class TestCallableStatement {
  /** Creates new form TestTableEditor */
  public static void main(String[] args) throws Exception {
//    Class.forName("oracle.jdbc.driver.OracleDriver");
    Class.forName("com.mysql.jdbc.Driver");
//    Connection connection = DriverManager.getConnection(
//      "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//      "scott", "tiger");
    Connection connection = DriverManager.getConnection(
      "jdbc:mysql://localhost/javabook",
      "scott", "tiger");

    // Create a callable statement
    CallableStatement callableStatement = connection.prepareCall(
      "{? = call studentFound(?, ?)}");

    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter student's first name: ");
    String firstName = input.nextLine();
    System.out.print("Enter student's last name: ");
    String lastName = input.nextLine();

    callableStatement.setString(2, firstName);
    callableStatement.setString(3, lastName);
    callableStatement.registerOutParameter(1, Types.INTEGER);
    callableStatement.execute();

    if (callableStatement.getInt(1) >= 1)
      System.out.println(firstName + " " + lastName +
        " is in the database");
    else
      System.out.println(firstName + " " + lastName +
        " is not in the database");
  }
}

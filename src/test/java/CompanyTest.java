import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;


public class CompanyTest {
    Connection connection;

    @BeforeClass
    public void init() throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/company";
        String username = "technostudy";
        String password = "zhTPis0l9#$&";
        connection = DriverManager.getConnection(url, username, password);
    }

    @Test
    public void printAllCountries() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from countries;");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("COUNTRY_ID") + "\t");
            System.out.print(resultSet.getString("COUNTRY_NAME") + "\t\t");
            System.out.print(resultSet.getString("REGION_ID") + "\t");
            System.out.println();
        }
    }

    @AfterClass
    public void cleanUp() throws SQLException {
        connection.close();
    }
}
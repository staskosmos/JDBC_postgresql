import java.sql.*;

public class JDBC_postgresql {

    public static void main (String []args) {
        String url = "jdbc:postgresql://127.0.0.1:5432/Computer firm";
        String user = "postgres";
        String pass = "admin";
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Соединение установлено");

            Statement stat = conn.createStatement();
            //Выполним запрос
            ResultSet result = stat.executeQuery("SELECT * FROM product");
            int i = 1;
            //Выводим данные
            while (result.next()) {
                System.out.println("#"+i+"-" + result.getString("Type")+" "+ result.getString(2)+" "+result.getString("Model"));
                i++;
            }
            //Вставим запись
            stat.executeUpdate("insert into product values ('PC','MAC','1993')");
            //Обновим запись
            stat.executeUpdate("UPDATE product set Maker = 'HP' where id=7");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ( conn != null ) {
                try {
                    conn.close();
                }catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }


    }
}

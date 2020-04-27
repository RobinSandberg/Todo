package se.lexicon.robincarl.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionOpener {

    public static Connection getConnection() throws SQLException {
        String host = null;
        String login = null;
        String password = null;
        File DBConfig = new File("src/main/resources/DBConfig.dat");
        try(FileInputStream DBStream = new FileInputStream(DBConfig)){
            Properties dbProperties = new Properties();
            dbProperties.load(DBStream);
            host = dbProperties.getProperty("db.host");
            login = dbProperties.getProperty("db.login");
            password = dbProperties.getProperty("db.password");
        }catch(IOException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(host, login, password);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.common;

import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author S2026987
 */
public class DatasourceUtility {
    
    public static DataSource getDatasource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        //dataSource.addDataSourceProperty("url", "jdbc:sqlserver://LPTAUS09\\SQLEXPRESS;user=sa;password=P@ssw0rd;databaseName=school_DB");
        //dataSource.addDataSourceProperty("url", "jdbc:sqlserver://LPTAUS09\\SQLEXPRESS;databaseName=school_DB");
        dataSource.addDataSourceProperty("url", "jdbc:sqlserver://ptadvsql18;databaseName=school_DB");
        dataSource.addDataSourceProperty("user", "sa");
        dataSource.addDataSourceProperty("password", "P@ssw0rd");
        return dataSource;
    }

    public static DataSource getDatasourceLookup() {
        try {
            InitialContext initialContext = new InitialContext();
            //DataSource dataSource = (DataSource) initialContext.lookup("jdbc/schoolDS");
            DataSource dataSource = (DataSource) initialContext.lookup("java:/schoolDS");
            return dataSource;      
        } catch (NamingException ex) {
            Logger.getLogger(DatasourceUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

package stepDefinition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tools.ant.taskdefs.SQLExec.Transaction;
 
public class DataBaseValidation {

private Connection getConnection() throws ClassNotFoundException, SQLException {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exec_summary", "root", "root");
             return con;
       }
 
       public List<Transaction> getResultSet(String query) throws ClassNotFoundException, SQLException {
             Connection con = getConnection();
             try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    List<Transaction> transactions = new ArrayList<>();
                    while(rs.next()){
                          Transaction trx = new Transaction();
                           trx.setTransactionDate(rs.getString("transaction_date"));
                           trx.setDescription(rs.getString("description"));
                       trx.setTransactionAmount(rs.getDouble("transaction_amount"));
                           trx.setTransactionType(rs.getString("transaction_type"));
                          transactions.add(trx);
                    }
                    return transactions;
             } catch (Exception e) {
                    System.out.println(e);
             }finally{
                    con.close();
             }
             return null;
       }
 
public Statement getMiniStatement(int numberOfTransactions) throws ClassNotFoundException, SQLException {
             String query = "select * from transactions order by transaction_date desc limit "
                          + numberOfTransactions;
             List<Transaction> transactions = getResultSet(query);
             Statement stmt = new Statement();
             if (transactions != null && transactions.size() > 0) {
                 stmt.setStartDate(transactions.get(0).getTransactionDate());
                    stmt.setEndDate(transactions.get(transactions.size() - 1).getTransactionDate());
             }
             stmt.setStatementDate(new Date());
             stmt.setTransactions(transactions);
             return stmt;
       }
 
       @Override
       public Statement getDetailedStatement(String from, String to) throws ClassNotFoundException, SQLException {
             DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
      
             String query = "select * from transactions where transaction_date>= '" + from
                          + "' and transaction_date <= '" + to+"' order by transaction_date desc";
             List<Transaction> transactions = getResultSet(query);
             Statement stmt = new Statement();
             stmt.setStartDate(from);
             stmt.setEndDate(to);
             stmt.setStatementDate(new Date());
             stmt.setTransactions(transactions);
             return stmt;
       }
     
}
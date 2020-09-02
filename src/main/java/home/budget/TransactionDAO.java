package home.budget;

import home.budget.modell.Transaction;

import java.sql.*;

public class TransactionDAO {

    private final String URL = "jdbc:mysql://localhost:3306/TransactionsIO?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private Connection connection;

    public TransactionDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Ups! Nie znaleziono drivera!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void save (Transaction transaction){
        final String SQL = "insert into Transactions(transactionType, transactionDescription, amount, transactionDate) values(?,?,?,?)";
        try {
            createOrUpdate(transaction, SQL);
        } catch (SQLException e) {
            System.out.println("Niestety próba zapisu zakończyła się niepowodzeniem!");
            e.printStackTrace();
        }
    }
    public Transaction read(long id){
        final String SQL = "select ID, transactionType, transactionDescription, amount, transactionDate from Transactions where id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setID(resultSet.getLong("ID"));
                transaction.setTransactionType(resultSet.getString("transactionType"));
                transaction.setTransactionDescription(resultSet.getString("transactionDescription"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTransactionDate(resultSet.getDate("transactionDate"));
                return transaction;
            }
        }catch (SQLException e){
            System.out.println("Niestety nie udało się znaleźć oczekiwanego pracownika!");
        }
        return null;
    }
    public void update (Transaction transaction){
        final String SQL = "update Transactions set transactionType=?, transactionDescription=?, amount=?, transactionDate=? where id = ?";
        try {
            createOrUpdate(transaction, SQL);
        }catch (SQLException e){
            System.out.println("Próba aktualizacji rekordu zakończyła się niepowodzeniem!");
            e.printStackTrace();
        }
    }
    public void delete (long id){
        final String SQL = "delete from Transactions where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niestety próba usunięcia rekordu niepowiodła się!");
        }
    }

    public void createOrUpdate(Transaction transaction, String SQL) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, transaction.getTransactionType());
        preparedStatement.setString(2, transaction.getTransactionDescription());
        preparedStatement.setDouble(3, transaction.getAmount());
        preparedStatement.setDate(4, (Date) transaction.getTransactionDate());
        preparedStatement.executeUpdate();
    }
}

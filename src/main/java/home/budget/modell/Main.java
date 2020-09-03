package home.budget.modell;

import home.budget.TransactionDAO;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        java.sql.Date dateOne = Date.valueOf("2020-04-09");
        Transaction transactionOne = new Transaction("wydatek", "zakup laptopa F-RAM", 3599.00, dateOne);
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.save(transactionOne);
        transactionDAO.read(1L);
        System.out.println(transactionOne);
//        transactionOne.setAmount(3200.00);
//        transactionDAO.update(transactionOne);
        transactionDAO.delete(1L);
        transactionDAO.close();
    }
}

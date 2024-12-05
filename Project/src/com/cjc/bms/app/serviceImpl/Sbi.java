package com.cjc.bms.app.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.bms.app.config.HibernateUtil;
import com.cjc.bms.app.model.Account;
import com.cjc.bms.app.service.Rbi;

public class Sbi implements Rbi {

    private Scanner sc = new Scanner(System.in);
    	
    	@Override
    	public void createAccount() throws Exception {
    	    Session session = HibernateUtil.getSessionFactory().openSession();
    	    Transaction tx = session.beginTransaction();

    	    try {
    	        Account account = new Account();

    	        System.out.println("Enter a 12-digit Account Number: ");
    	        account.setAccountNo(sc.nextLong());

    	        System.out.println("Enter Account Holder's Name: ");
    	        account.setAcName(sc.next());

    	        System.out.println("Enter Gender: ");
    	        account.setGender(sc.next());

    	        System.out.println("Enter Age: ");
    	        account.setAge(sc.nextByte());

    	        System.out.println("Enter Aadhaar Number: ");
    	        account.setAdharNo(sc.nextLong());

    	        System.out.println("Enter PAN Number: ");
    	        account.setPanNo(sc.next());

    	        System.out.println("Enter Mobile Number: ");
    	        account.setPhoneNo(sc.nextLong());

    	        System.out.println("Enter Email: ");
    	        account.setMail(sc.next());

    	        System.out.println("Enter Opening Balance: ");
    	        account.setBalance(sc.nextDouble());

    	        session.persist(account);
    	        tx.commit();
    	        System.out.println("Account created successfully.");
    	    } catch (Exception e) {
    	        tx.rollback();
    	        System.out.println("Failed to create account: " + e.getMessage());
    	    } finally {
    	        session.close();
    	    }
    	}
	@Override
	public void displayAllDetails() throws Exception {
		    // Create session and transaction
		    Session session = HibernateUtil.getSessionFactory().openSession();

		        System.out.print("Enter Account Number to search: ");
		        long accountNo = sc.nextLong();

		        Account account = session.get(Account.class, accountNo);

		        // Check if account exists
		        if (account != null) {
		            // Display account details
		            System.out.println("\n======= Account Details =======");
		            System.out.println("Account Number: " + account.getAccountNo());
		            System.out.println("Account Holder's Name: " + account.getAcName());
		            System.out.println("Gender: " + account.getGender());
		            System.out.println("Age: " + account.getAge());
		            System.out.println("Aadhaar Number: " + account.getAdharNo());
		            System.out.println("PAN Number: " + account.getPanNo());
		            System.out.println("Mobile Number: " + account.getPhoneNo());
		            System.out.println("Email: " + account.getMail());
		            System.out.println("Balance: " + account.getBalance());
		            System.out.println("-------------------------------");
		        } else {
		            System.out.println("Account with Account Number " + accountNo + " not found.");
		        }

		    } 
	@Override
	public void depositeMoney() throws Exception {
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    Transaction tx = session.beginTransaction();

		        System.out.print("Enter Account Number to deposit money: ");
		        long accountNo = sc.nextLong();

		        Account account = session.get(Account.class, accountNo);

		        if (account != null) {

		            System.out.print("Enter deposit amount: ");
		            double depositAmount = sc.nextDouble();

		            if (depositAmount > 0) {
		                double newBalance = account.getBalance() + depositAmount;
		                account.setBalance(newBalance);

		                session.update(account);
		                tx.commit();

		                System.out.println("Deposit successful! Updated balance: " + newBalance);
		            } else {
		                System.out.println("Invalid deposit amount. Please enter a positive value.");
		            }
		        } else {
		            System.out.println("Account not found with Account Number: " + accountNo);
		        }
		    }

	public void withdrawal() throws Exception {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	        System.out.print("Enter Account Number to withdraw money: ");
	        long accountNo = sc.nextLong();

	        Account account = session.get(Account.class, accountNo);

	        if (account != null) {

	            System.out.print("Enter withdrawal amount: ");
	            double withdrawalAmount = sc.nextDouble();

	            if (withdrawalAmount > 0) {
	                if (withdrawalAmount <= account.getBalance()) {

	                    double newBalance = account.getBalance() - withdrawalAmount;
	                    account.setBalance(newBalance);

	                    session.update(account);
	                    tx.commit();

	                    System.out.println("Withdrawal successful! Updated balance: " + newBalance);
	                } else {
	                    System.out.println("Insufficient balance. Withdrawal denied.");
	                }
	            } else {
	                System.out.println("Invalid withdrawal amount. Please enter a positive value.");
	            }
	        } else {
	            System.out.println("Account not found with Account Number: " + accountNo);
	        }
	    } 

	public void balanceCheck() throws Exception {
	    Session session = HibernateUtil.getSessionFactory().openSession();

	        System.out.print("Enter Account Number to check balance: ");
	        long accountNo = sc.nextLong();

	        Account account = session.get(Account.class, accountNo);

	        if (account != null) {

	            System.out.println("Current balance for Account Number " + accountNo + ": " + account.getBalance());
	        } else {
	            System.out.println("Account not found with Account Number: " + accountNo);
	        }
	    }
	}


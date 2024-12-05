package com.uni.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.uni.model.Department;
import com.uni.model.Employee;

public class Test {

    public static void main(String[] args) {
        // Create Department instance
        Department dep = new Department();
        dep.setdId(101);
        dep.setdName("QA");

        // Create Employee instances
        Employee e1 = new Employee();
        e1.seteId(201);
        e1.seteName("AAA");

        Employee e2 = new Employee();
        e2.seteId(202);
        e2.seteName("BBB");

        // Add Employees to Department
        Set<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);
        dep.setE(employees);

        // Hibernate session setup
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.persist(dep);
        
        session.beginTransaction().commit();
        
        System.out.println("Hello World");
    }
}

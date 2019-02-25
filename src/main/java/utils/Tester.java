package utils;

import Facade.ClassicFacade;
import entity.Customer;
import entity.Employee;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;
import mappers.CustomerSimple;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        ClassicFacade facade = new ClassicFacade(emf);
        //        AddEmployee(facade);
        //        allEmployees(facade);
        //        costumerFromCountry(facade);
        //        Få salgs medarbejer max salg MANGLER!
        //        orderOnHold(facade);
        //        orderOnHoldWithCustomerId(facade);
        //        customerNamesSorted(facade);
        //        customerSimpleNames(facade);
        //        customerSimpleName(facade);
        
    }

    private static void customerSimpleName(ClassicFacade facade) {
        CustomerSimple cso = facade.getCustomerSimple(144);
        System.out.println("FirstName: " + cso.getFirstName() + ". LastName: "
                + cso.getLastName() + ". CustomerName: " + cso.getCustomerName() + ". orderCount: " + cso.getOrderCount());
    }

    private static void customerSimpleNames(ClassicFacade facade) {
        List<CustomerSimple> cs = facade.getCustomersSimple();
        for (int i = 0; i < cs.size(); i++) {
            System.out.println("FirstName: " + cs.get(i).getFirstName() + ". LastName: "
                    + cs.get(i).getLastName() + ". CustomerName: " + cs.get(i).getCustomerName() + ". orderCount: " + cs.get(i).getOrderCount());
        }
    }

    private static void customerNamesSorted(ClassicFacade facade) {
        List<String> cn = facade.getCustomerNamesSorted();
        System.out.println(cn);
    }

    private static void orderOnHoldWithCustomerId(ClassicFacade facade) {
        List<Order> oo = facade.getOrdersOnHoldByCustomerId(144);
        System.out.println(oo);
    }

    private static void orderOnHold(ClassicFacade facade) {
        List<Order> ooh = facade.getOrdersOnHold();
        System.out.println(ooh);
    }

    private static void costumerFromCountry(ClassicFacade facade) {
        List<Customer> cu = facade.getAllCustomerFromCountry();
        System.out.println(cu);
    }

    private static void allEmployees(ClassicFacade facade) {
        List<Employee> emp = facade.getAllEmployees();
        System.out.println(emp);
    }

    private static void AddEmployee(ClassicFacade facade) {
        Employee emp = facade.createEmployee("aa", "aa", "ext", "mail", "master", "1");
        System.out.println(emp.getFirstName() + "," + emp.getEmployeeNumber());
    }

}

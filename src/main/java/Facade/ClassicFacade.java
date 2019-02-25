package Facade;

import entity.Customer;
import entity.Employee;
import entity.Office;
import entity.OrderClassic;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import mappers.CustomerSimple;

public class ClassicFacade {

    EntityManagerFactory emf;

    public ClassicFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public long employeeCountBAD() {
        EntityManager em = emf.createEntityManager();
        try {
            //allways do this #bad
            return (long) em.createNamedQuery("Employee.findAll").getSingleResult();
        } finally {
            em.close();
        }
    }

    public long employeeCountGOOD() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT count(e) FROM Employee e");
            return (long) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT e FROM Employee e");
            return (List<Employee>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomerFromCountry() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT c FROM Customer c WHERE c.city = :city");
            q.setParameter("city", "Barcelona");
            return (List<Customer>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Order> getOrdersOnHold() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM OrderClassic o WHERE o.status = :status");
            q.setParameter("status", "On Hold");
            return (List<Order>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Order> getOrdersOnHoldByCustomerId(int customerNumber) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM OrderClassic o WHERE o.customer.customerNumber = " + customerNumber + " AND o.status = 'On Hold'");
            return (List<Order>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<String> getCustomerNamesSorted() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT c.customerName FROM Customer c");
            List<String> qs = (List<String>) q.getResultList();
            Collections.sort(qs);
            return qs;
        } finally {
            em.close();
        }
    }

    public List<CustomerSimple> getCustomersSimple() {
        EntityManager em = emf.createEntityManager();
        try {
            String queryStr
                    = "SELECT NEW mappers.CustomerSimple(c.contactFirstName, c.contactLastName, c.customerName,COUNT(o.customer.customerNumber)) "
                    + "FROM Customer AS c, OrderClassic AS o WHERE c.customerNumber = o.customer.customerNumber GROUP BY o.customer.customerNumber";
            TypedQuery<CustomerSimple> query
                    = em.createQuery(queryStr, CustomerSimple.class);
            List<CustomerSimple> results = query.getResultList();
            return results;
        } finally {
            em.close();
        }
    }

    public CustomerSimple getCustomerSimple(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            String queryStr
                    = "SELECT NEW mappers.CustomerSimple(c.contactFirstName, c.contactLastName, c.customerName, COUNT(o)) "
                    + "FROM Customer AS c, OrderClassic AS o WHERE c.customerNumber = " + id + " AND o.customer.customerNumber = " + id;
            TypedQuery<CustomerSimple> query
                    = em.createQuery(queryStr, CustomerSimple.class);
            CustomerSimple results = query.getSingleResult();
            return results;
        } finally {
            em.close();
        }
    }

    public Employee createEmployee(String lastName, String firstName, String extension, String email, String jobTitle, String officeCode) {
        Employee emp = new Employee(lastName, firstName, extension, email, jobTitle);
        EntityManager em = emf.createEntityManager();
        Office of = em.find(Office.class,
                officeCode);
        emp.setOffice(of);
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
            return emp;
        } finally {
            em.close();
        }
    }

    //"SELECT c FROM Customer c WHERE c.customerNumber = :customerNumber"
     public Integer findCustomer(int id){
                EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT c FROM Customer c WHERE c.customerNumber = :customerNumber");
            q.setParameter("customerNumber", id);
            return (int) q.getSingleResult();
        } finally {
            em.close();
        }
     }
}

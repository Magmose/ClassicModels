package entity;

import entity.Customer;
import entity.Employee;
import entity.Office;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-21T12:15:08")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> extension;
    public static volatile CollectionAttribute<Employee, Customer> customerCollection;
    public static volatile SingularAttribute<Employee, String> jobTitle;
    public static volatile CollectionAttribute<Employee, Employee> employeeCollection;
    public static volatile SingularAttribute<Employee, Office> office;
    public static volatile SingularAttribute<Employee, Employee> employee;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, Integer> employeeNumber;

}
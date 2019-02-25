package entity;

import entity.Employee;
import entity.OrderClassic;
import entity.Payment;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-21T12:15:08")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> country;
    public static volatile SingularAttribute<Customer, String> city;
    public static volatile SingularAttribute<Customer, String> contactFirstName;
    public static volatile SingularAttribute<Customer, String> postalCode;
    public static volatile SingularAttribute<Customer, Integer> customerNumber;
    public static volatile SingularAttribute<Customer, Employee> employee;
    public static volatile CollectionAttribute<Customer, Payment> paymentCollection;
    public static volatile SingularAttribute<Customer, String> customerName;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile CollectionAttribute<Customer, OrderClassic> orderClassicCollection;
    public static volatile SingularAttribute<Customer, String> addressLine1;
    public static volatile SingularAttribute<Customer, BigDecimal> creditLimit;
    public static volatile SingularAttribute<Customer, String> contactLastName;
    public static volatile SingularAttribute<Customer, String> addressLine2;
    public static volatile SingularAttribute<Customer, String> state;

}
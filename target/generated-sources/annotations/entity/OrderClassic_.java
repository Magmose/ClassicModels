package entity;

import entity.Customer;
import entity.Orderdetail;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-21T12:15:08")
@StaticMetamodel(OrderClassic.class)
public class OrderClassic_ { 

    public static volatile SingularAttribute<OrderClassic, Integer> orderNumber;
    public static volatile SingularAttribute<OrderClassic, String> comments;
    public static volatile CollectionAttribute<OrderClassic, Orderdetail> orderdetailCollection;
    public static volatile SingularAttribute<OrderClassic, Date> requiredDate;
    public static volatile SingularAttribute<OrderClassic, Date> orderDate;
    public static volatile SingularAttribute<OrderClassic, Date> shippedDate;
    public static volatile SingularAttribute<OrderClassic, String> status;
    public static volatile SingularAttribute<OrderClassic, Customer> customer;

}
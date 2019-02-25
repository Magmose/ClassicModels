package entity;

import entity.OrderClassic;
import entity.OrderdetailPK;
import entity.Product;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-21T12:15:08")
@StaticMetamodel(Orderdetail.class)
public class Orderdetail_ { 

    public static volatile SingularAttribute<Orderdetail, Product> product;
    public static volatile SingularAttribute<Orderdetail, OrderdetailPK> orderdetailPK;
    public static volatile SingularAttribute<Orderdetail, Integer> quantityOrdered;
    public static volatile SingularAttribute<Orderdetail, OrderClassic> orderClassic;
    public static volatile SingularAttribute<Orderdetail, Short> orderLineNumber;
    public static volatile SingularAttribute<Orderdetail, BigDecimal> priceEach;

}
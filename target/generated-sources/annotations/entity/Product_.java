package entity;

import entity.Orderdetail;
import entity.Productline;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-21T12:15:08")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Short> quantityInStock;
    public static volatile SingularAttribute<Product, BigDecimal> buyPrice;
    public static volatile SingularAttribute<Product, Productline> productline;
    public static volatile SingularAttribute<Product, String> productCode;
    public static volatile SingularAttribute<Product, String> productScale;
    public static volatile SingularAttribute<Product, BigDecimal> msrp;
    public static volatile CollectionAttribute<Product, Orderdetail> orderdetailCollection;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, String> productVendor;
    public static volatile SingularAttribute<Product, String> productDescription;

}
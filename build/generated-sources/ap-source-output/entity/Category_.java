package entity;

import entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-01T10:29:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> categoryName;
    public static volatile SingularAttribute<Category, Integer> categoryID;
    public static volatile ListAttribute<Category, Product> products;

}
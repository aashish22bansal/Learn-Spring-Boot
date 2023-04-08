/**
 * 
 */
package com.aashish22bansal.developer.learning.springboot.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Aashish Bansal
 * We would have used the @Component Annotation which would tell the Spring that PaymentDAOImple
 * is a Spring Bean and an Object of this should be created and injected wherever required.
 * 
 * Or we can mark this with Specialised Annotations, for example, @Repository, which is used
 * for classes that handle the database code.
 */
@Repository
public class PaymentDAOImpl implements PaymentDAO {

}

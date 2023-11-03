/**
 * 
 */
package profiles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import profiles.entities.Product;
import profiles.repositories.ProductRepository;

/**
 * @author Aashish Bansal
 * 
 * We will implement the RESTful API by creating the ProductController Class and the first API
 * which we are going to expose is the findAll() method which will return all the methods. It
 * will return the details from the database and it will return all the products. It will fetch
 * the details from the database and send them to the client using the URI called '/products' 
 * and the HTTP GET method to get all the products. 
 * 
 * Now, to make the class ProductTESTController a RESTful Controller, we will need to mark it
 * with @RestController Annotation.
 *
 */
@RestController
public class ProductRESTController {
	
	// Injecting the Repository
	@Autowired
	ProductRepository productRepository;
	/**
	 * We will create a List which will return a List of Products back to the client.
	 * We can implement the method getProducts() but we also need to map this to the "/products"
	 * URI and the HTTP GET method as:
	 * @RequestMapping(value = "/products/", method = RequestMethod.GET)
	 * But now we can use the specific method as:
	 * @GetMapping("/products/")
	 */
	@GetMapping("/products/")
	public List<Product> getProducts(){
		return productRepository.findAll(); 
	}
	
	/**
	 * We will implement the findProduct() method which will return a single product when 
	 * provided with the ID of the Product. In this, the ID will come as a part of the URL,
	 * which is known as Path Parameter, where the ID is being passed in the URL through which
	 * it will be retrieved and we will bind it as a parameter being passed to the findProduct()
	 * method and we will bind it with the HTTP GET Method.
	 * 
	 * The getProduct() method returns Optional<Product> because of Spring Reactive Programming.
	 * So, we will have to invoke the get() method to obtain the value.
	 * 
	 * We also need to map this to the "/products" URI and the HTTP GET method along with the 
	 * product ID that we will receive in the parameter as:
	 * @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	 * But now we can use the specific method as:
	 * @GetMapping("/products/{id}")
	 * 
	 * We will map the {id} using the @PathVariable() Annotation and with parenthesis, we will
	 * mention to what we are mapping it.
	 */
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return productRepository.findById(id).get();
	}
	
	/**
	 * Next, we will implement the createProduct() method which take a single Product and it
	 * will insert a row into the database.
	 * 
	 * The URI in this case is "/products" because we are adding a Product to the database (
	 * which has the current collection of Products) and the HTTP Method is POST.
	 * 
	 * The data which is being saved would be returned back to the client.
	 * 
	 * We also need to map this to the "/products" URI and the HTTP POST method along with the 
	 * product that we will receive in the parameter as:
	 * @RequestMapping(value = "/products", method = RequestMethod.POST)
	 * But now we can use the specific method as:
	 * @PostMapping("/products")
	 * 
	 * The @RequestBody Annotation will tell Spring that it should Deserialize the incoming
	 * request into objects, take the fields that come in the request and place them into
	 * the Product Object being passed as a parameter.
	 */
	@PostMapping("/products/")
	public Product creatProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	/**
	 * Next, we will implement the updateProduct() method which take a single Product and it
	 * will update the information stored in a row for that product into the database. 
	 * 
	 * The URI in this case is "/products" because we are updating a Product in the database (
	 * which has the current collection of Products) and the HTTP Method is PUT.
	 * 
	 * The data which is being saved would be returned back to the client.
	 * 
	 * We also need to map this to the "/products" URI and the HTTP PUT method along with the 
	 * product that we will receive in the parameter as:
	 * @RequestMapping(value = "/products", method = RequestMethod.PUT)
	 * But now we can use the specific method as:
	 * @PutMapping("/products")
	 * 
	 * So, when we invoke the save() method, then Spring will check if the Product has an Id
	 * or Primary Key in it. If the Id or Primary Key exists, then it will only update the 
	 * existing row in the database otherwise it will insert a row into the database.  
	 */
	@PutMapping("/products/")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	/**
	 * Next, we will implement the deleteProduct() method which take the existing collection
	 * of products and delete the specific product from it. For this, we will pass the "id"
	 * as the Path Parameter and the method will be mapped to HTTP DELETE.  
	 * 
	 * The URI in this case is "/products/{id}" because we are deleting a Product in the 
	 * database (which has the current collection of Products) and the HTTP Method is DELETE.
	 * 
	 * The data which is being saved would be returned back to the client.
	 * 
	 * We also need to map this to the "/products/{id}" URI and the HTTP DELETE method along 
	 * with the product that we will receive in the parameter as:
	 * @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	 * But now we can use the specific method as:
	 * @DeleteMapping("/products/{id}")
	 */
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}
}

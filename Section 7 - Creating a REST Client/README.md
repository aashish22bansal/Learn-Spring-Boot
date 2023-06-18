# Creating a REST Client

## REST Template
 We can create a RESTful client using REST Template provided by spring-web Module. Here, RestTemplate is a class that uses various methods to perform varius HTTP Operations as:
 
 - GET: If we are invoking a RESTful end-point that is mapped to GET, then we will use RestTemplate.getForObject(). This method expects a URL and a type of Object that we are expecting back. It will hit that URL, get the response, convert that response into a Java Object and hand it over to the application.
 - POST: If we are invoking a RESTful end-point that is mapped to POST, then we will use RestTemplate.postForObject(). This method expects a URL and give it the Object that will be Serialized on the wire to the required format, then it sends it to the server from which we get the response, convert that response by Deserializing into the required format and hand it over to the application.
 - PUT: If we are invoking a RESTful end-point that is mapped to PUT, then we will use RestTemplate.put().
 - DELETE: If we are invoking a RESTful end-point that is mapped to DELETE, then we will use RestTemplate.delete().


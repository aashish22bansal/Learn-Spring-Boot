# Health Checks and Metrics
## Introduction
<div>
    <p>To claim that our application is production-ready, we should have health checks and metrics which would allow us to monitor and manage the application (even when it is running in production). </p>
    <p>
        <p>There are 4 key things which we look for:</p>
        <ul>
            <li><b>Health Checks</b>: This indicates whether our application is up and running. If the application is down, then why is it down?</li>
            <li><b>Application Configuration</b>: We should have complete access to the configuration information that our application is using at runtime.</li>
            <li><b>Application Metrics</b>: This represents the exact health of our application, i.e., what kind of memory it is using, etc.</li>
            <li><b>Key Application Events</b>: This represents the key events happening in the application, for example, is the application sending a message, is the message received, is it saving the data in the database and so on.</li>
        </ul>
    </p>
    <p>We can ensure all of these health checks and metrics by enabling the <b>Spring Boot Actuators</b> for our project. After this, Spring Boot will expose several endpoints using which we can access the health and metrics for our application.</p>
    <p>Some of the endpoints exposed are:</p>
    <ul>
        <li><b>http://localhost:8080/.../actuator/beans</b>: This endpoint will show the complete list of Spring Beans which Spring Boot would have configured for our application to work.</li>
        <li><b>http://localhost:8080/.../actuator/health</b>: This endpoint will provide the complete information about whether the application is up and running, whether the database is up and running, whether the ques are up and running or not, etc.</li>
        <li><b>http://localhost:8080/.../actuator/info</b>: This endpoint will provide us the arbitrary information about the application, the build information, etc.</li>
        <li><b>http://localhost:8080/.../actuator/loggers</b>: This endpoint will provide us access to the configured log files directly.</li>
        <li><b>http://localhost:8080/.../actuator/headdump</b>: This endpoint will provide us the complete information about head dump.</li>
        <li><b>http://localhost:8080/.../actuator/threaddump</b>: This endpoint will provide us the complete information about thread dump information from RESTing Tool, for example, Postman or any other RESTful client.</li>
        <li><b>http://localhost:8080/.../actuator/metric</b>: This endpoint wil provide us access to all the metrics of the application.</li>
    </ul>
    <p>By default, only the <code>health</code> endpoint will be exposed and, to expose te remaining information, we will need to include the <code>management.endpoints.web.exposure.include=*</code> property into the <code>application.properties</code> file.</p>
    <p>Now, to expose all the actuator-related endpoints, we will add the property <code>management.endpoints.web.exposure.include=*</code> to our <code>application.properties</code> file. With this property, we will be able to see a lot of the information for all the other endpoints.</p>
</div>

## Dependency
<div>
    <p>The dependency which we can use to implement these Health Checks and Metrics is using the Actuator Dependency. We can import the artifactId <code>spring-boot-starter-actuator</code> dependency from the <code>org.springframework.boot</code> groupId. So, when we run the application, then Spring will gather all the information from the application and then expose the information under several endpoints automatically.</p>
</div>

## Execution
<div>
    <p>After we execute our application, we can head to the <code>http://localhost:8080/APPLICATION_URL/actuator</code> and this will provide us the exposed endpoints in the form of HyperText which will provide us with the links which could be used to access the further endpoints. Here, we will be able to see that the <code>health</code> and the <code>info</code> endpoints would be exposed by default.</p>
</div>

### Endpoint - Health
<div>
    <p>This endpoint will show the <code>status</code> as <code>UP</code> if the application is up and running otherwise it will provide the status as <code>DOWN</code>. Since, we can see that there is very less information available about the health of our application, so we will configure the endpoint to obtain some more information by adding certain properties to the <code>application.properties</code> file. We can access those properties using <code>management.endpoint.health</code> property as:</p>
    <ul>
        <li>management.endpoint.health.<b>cache.time-to-live</b>: </li>
        <li>management.endpoint.health.<b>enabled</b>: </li>
        <li>management.endpoint.health.<b>roles</b>: </li>
        <li><span>management.endpoint.health.<b>show-details</b></span>: 
            This property provides us with the following options:
            <ul>
                <li><b>always</b>: This option will always provide us with the health checks and metrics.</li>
                <li><b>never</b>: By default, the <code>health</code> endpoint is set to <code>never</code> which is the reason we do not see much information with the endpoint exposed under <code>http://localhost:8080/APPLICATION_URL/actuator/health</code> URI.</li>
                <li><b>when-authorised</b>: When we use this option, the health check and metric details would be provided only after the user authenticates.</li>
            </ul>
            With this, we can control the information that we want to display, for example, the Database details and the Disk Space details.
        </li>
    </ul>
    <p>Now, we can even create our custom health indicators as well. Spring Boot even allows to customize the information that we want to send back by implementing the Custom Health Indicators. For this, we will need to create our custom class which would implement the <code>HealthIndicator</code> interface in Spring. So, whatever we implement using the <code>health()</code> methods would be appended to the information that we see at the endpoint and whatever the status we sent back would be the overall status of the application. This custom class will also need to be annotated with <code>@Component</code> annotation so that Spring will scan through it and create an instance of it at runtime. Now, to return a response, we will need to return a <code>Health</code> Object. This object will provide us access to several static methods which we can use to process and return the required information. For example, with the <code>Health.up().build()</code>, we will return the status as <code>UP</code> when there are no issues with the application. We can even check for issues as:</p>
    <pre><code>
        boolean error = true;
        if(error){
            return Health.down().withDetail("Error Key", 123).build();
        }
        return Health.up().build();
    </code></pre>
</div>

### Endpoint - Info
<div>
    <p>By default, it will not display any information, so we will need to implement the configuration regarding the information which we want it to display. Suppose we want the <b>build</b> related information to included in the <code>info</code> (like the version, etc.), so we can go to the <code>pom.xml</code> file and under the <code>spring-boot-maven-plugin</code>, we will add the <code>executions</code> section in XML. Within this, we would like to execute a particular goal that will generate a file which will have all the build related information. So, we will create a new <code>goal</code> with the value <code>build-info</code>. So, with this, Maven will generate a <code>build.properties</code> file. Once we have that file on the <code>CLASSPATH</code>, Spring Boot will automatically use the information in that file and it will send that output as a result/response of the <code>http://localhost:8080/APPLICATION_URL/actuator/info</code> endpoint. Upon execution, it will automatically have this file as a goal.</p>
    <p>Now, we can even create our custom <code>info</code> indicators as well. Spring Boot even allows us to customize the information that we want to send back by implementing the Custom Info Indicators. For this, we will need to create our custom class which would implement the <code>InfoContributor</code> interface in Spring.</p>
</div>



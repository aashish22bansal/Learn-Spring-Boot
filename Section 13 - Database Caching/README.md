# Database Caching

## Introduction to Caching
<div>
    <p>We know that, when the clients access our application which uses an ORM Tool, like, Hibernate, to load/read the data, then the ORM Tool will execute a SELECT Query internally against the Database Table to get the data and then convert the data into, then hand over the data to our application so that we can send it back to the client as required. Everytime the client reads some data from our application, then our application or the ORM Tool will execute that SELECT Statement which either be a simple SELECT Query or a SELECT Query with multiple tables (with JOINs). So, instead of repeating the same read operation multiple times, we tend to use the concept of Caching using Cache Memory. </p>
    <p>Caching is storing the data or an object in a temporary location. So, when the request comes in for the very first time, then these ORM Tools or Caching Frameworks will read the data, convert them into object and store that object into a temporary memory location or even to the disk. This process is called Caching, so next time when the request comes in, then these ORM Tools or Caching Frameworks will check if the data for that particular request exists in the cache or not. If it is there, then there no database query will be executed or database communication because simply the data from the cache object would be taken, processed and sent back to the client. This helps in improving the performance of the application. This cache will be refreshed everytime the database is updated. If the database is deleted, then the cache memory related to it will also be deleted.</p>
</div>

## Steps to Enable Caching
<div>
    <p>To enable Caching, Spring Boot uses third-party cache providers, like Hazelcast or EH Cache or JBoss Cache.</p>
</div>

### Hazelcast
<div>
    <p>Once we configure Hazelcast, it will maintain a cache of objects that are retrieved from the database. i.e., the very first time the records are fetched from the database and the next time the application makes a call or price to retrieve the same data, Hazelcast will check if the data is available in Cache and it will give back to the application, if it is not there, then it will go into the database, fetch that data using the usual ORM workflow and then store it in Cache.</p>
    <p>If we are working a clustered environment, then the objects might need to be serialized from one machine to another on the cluster. So, all the models should implement the Serializable interface.</p>
    <p>Steps to use Hazelcast:</p>
    <ol>
        <li>Add Dependencies required for the project, i.e., Spring Boot Cache Support and Hazelcast.</li>
        <li>Create the Cache Configuration for creating cache in which we will give:
            <ul>
                <li>Name of the Cache</li>
                <li>Size of the Cache</li>
                <li>Number of Objects that can go into the cache</li>
            </ul>
            So, this will be Java Configuration Class which will return a Spring Bean which is of type <code>HazelcastConfig</code>.
        </li>
        <li>Enable and use caching in the application using the <code>@EnableCaching</code> in our starter class. We will use the <code>@Cacheable</code> annotation on the REST Controller or Service classes.</li>
        <li>Provide the Cache Evict information which would tell when the cache should be cleaned because over time the cache size will increase and our application will crash if we do not clear the cache. There are different Cache Evict Policies which we can use, for example:
            <ul>
                <li><b>Least Recently Used (LRU):</b> With LRU, Hazelcast will check which is the object that is least recently used in the cache and it will remove that cache object after sometime.</li>
                <li><b>Least Frequently Used (LFU):</b> With LFU, Hazelcast will check the object which is least frequently used and it will remove that object from the cache.</li>
                <li><b>NONE:</b> If we specify NONE, then Hazelcast will not do anything and our cache size will keep growing.</li>
                <li><b>RANDOM:</b> If we specify RANDOM, then Hazelcast will randomly pick an object from the cache and it will remove that.</li>
            </ul>
            We will mostly use these Cache Evict Policies in DELETE Method somewhere in the application code.
        </li>
    </ol>
</div>

## Add Maven Dependencies
<div>
    <p>We will add the <code>spring-boot-starter-cache</code> dependency to the <code>pom.xml</code> file. Now, we will also need to add the <b>Hazelcast Dependency</b> to the file. So, we will add <code>com.hazelcast</code> as <code>groupId</code>, and <code>hazelcast</code> and <code>hazelcast-spring</code> as <code>artifactId</code>. The <code>hazelcast</code> artifact brings in the Hazelcast JAR File and the <code>hazelcast-spring</code> brings in the Spring support for Hazelcast.</p>    
</div>
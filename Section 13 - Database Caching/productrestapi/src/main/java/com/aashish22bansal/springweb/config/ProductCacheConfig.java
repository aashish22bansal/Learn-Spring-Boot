package com.aashish22bansal.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

/**
 * @author Aashish Bansal
 * Using the @Configuration annotation, we will mark this class as a Configuration Class.
 * 
 * This will return a HazelcastConfig object. 
 */
@Configuration
public class ProductCacheConfig {
	
	/**
	 * @return Hazelcast Config Object.
	 * 
	 *  Once the object is created (using the Constructor), we will call the following methods:
	 *  - setInstanceName("NAME"): For this instance, we will need to provide a unique name, for example
	 *    "hazel-instance".
	 *  - addMapConfig(): This method is used to add the configuration. Since this takes a MapConfig Object,
	 *    we will need to create a new MapConfig() instance. On this, we will need to set some properties:
	 *    -- Name of the Cache: We will set this using the setName("NAME") method, for example, product-cache.
	 *    -- Time To Live: We will set this using the setTimeToLiveSeconds(timeToLiveSecondsValue) to which we
	 *       we will pass the amount of time in seconds. This represents the amount of time the object will 
	 *       live in the cache before it is evicted. If we were to provide '-1', then the object will live
	 *       forever.
	 */
	@Bean
	public Config cacheConfig() {
		return new Config().setInstanceName("hazel-instance").addMapConfig(new MapConfig().setName("product-cache").setTimeToLiveSeconds(3000));
	}
}

package com.cb.config;

import java.util.Collections;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

import com.cb.model.User;

import lombok.SneakyThrows;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration{
	
	@Autowired
	private ApplicationContext context;

	@Override
	public String getConnectionString() {
		// TODO Auto-generated method stub
		return "couchbase://127.0.0.1";
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return "test";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "test123";
	}

	@Override
	public String getBucketName() {
		// TODO Auto-generated method stub
		return "customer";
	}
	
	@Override
	public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping)
	{
		try {
			mapping.mapEntity(User.class, getCouchbaseTemplate("user"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private CouchbaseTemplate getCouchbaseTemplate(String bucketName) throws Exception
	{
		CouchbaseTemplate template =new CouchbaseTemplate(couchbaseClientFactory(bucketName),
				mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
						new CouchbaseCustomConversions(Collections.emptyList())));
		template.setApplicationContext(context);
		return template;
	}
	
	private CouchbaseClientFactory couchbaseClientFactory(String bucketname)
	{
		return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()), bucketname, this.getScopeName());
		
	}
	
	
	

}

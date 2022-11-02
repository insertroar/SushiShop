
1. import a maven project into Eclipse
	a. right click on blank space in "Project Explorer"
	b. Import... >> Maven >> Existing Maven Projects, next
	c. Browse and find the folder that contains the Maven project, select
	d. Finish
	
2. For H2 in-memory db:
	in application.properties, make the following changes:
	
		spring.h2.console.enabled=true
		
		spring.h2.console.path=/h2
		
		spring.datasource.url=jdbc:h2:mem:testdb
		spring.datasource.driverClassName=org.h2.Driver
		spring.datasource.username=sa
		spring.datasource.password=
		
		#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
		
		spring.jpa.hibernate.ddl-auto=none
		spring.jpa.defer-datasource-initialization=true
		spring.datasource.data=classpath:data.sql
		spring.datasource.schema=classpath:schema.sql	
		
3. For testing:
	a. Tomcat:
		Servers >> Tomcat 9 >> Add and Remove..., add the project. Then Clean, Publish and Start Tomcat.
		http://localhost:8080/SushiShop/h2
		
	b. run Spring Boot App (Spring Boot app also contains a simple Tomcat)
		right click on the project >> Run As >> Spring Boot App
		http://localhost:8080/h2
		
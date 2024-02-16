application.properties file:

```
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.show-sql: true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
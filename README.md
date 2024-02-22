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

Postman API:
https://www.postman.com/farmiot/workspace/expense-tracker/collection/22427122-24cac5c3-bd8a-47a8-8c98-fb3f8137e9ad?action=share&creator=22427122

Note: More features for transactions has to be added
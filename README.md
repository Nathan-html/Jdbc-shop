Don't forget to add this in resources/application.properties
```properties
db.url=jdbc:db_type://localhost:db_port/db_name?serverTimezone=UTC
db.user=user_name
db.password=user_password
```
exemple with mysql default user
```properties
db.url=jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC
db.user=root
db.password=
```
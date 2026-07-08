# Difference Between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

- JPA stands for Java Persistence API.
- It is a specification used for mapping Java objects to database tables.
- JPA provides only interfaces and annotations.
- It does not contain an implementation.
- Hibernate is one of the implementations of JPA.

## Hibernate

- Hibernate is an ORM (Object Relational Mapping) framework.
- It is an implementation of JPA.
- Hibernate converts Java objects into database tables.
- It simplifies database operations like Create, Read, Update and Delete (CRUD).
- It manages transactions and reduces JDBC code.

## Spring Data JPA

- Spring Data JPA is built on top of JPA.
- It does not implement JPA itself.
- It uses Hibernate (or another JPA provider) internally.
- It reduces boilerplate code.
- It automatically provides CRUD methods using JpaRepository.

## Comparison Table

| Feature | JPA | Hibernate | Spring Data JPA |
|---------|-----|-----------|-----------------|
| Type | Specification | Framework | Spring Module |
| Implementation | No | Yes | Uses JPA implementation |
| ORM Support | Defines ORM APIs | Yes | Uses Hibernate |
| CRUD Operations | Manual | Manual | Automatic |
| Boilerplate Code | Medium | Less | Very Less |
| Transaction Management | Through Provider | Yes | Spring Managed |

## Hibernate Example

```java
Session session = factory.openSession();
Transaction tx = session.beginTransaction();
session.save(employee);
tx.commit();
session.close();
```

## Spring Data JPA Example

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

```java
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```

## Conclusion

- JPA is a specification.
- Hibernate is an implementation of JPA.
- Spring Data JPA is a Spring module built on top of JPA that simplifies database access and reduces boilerplate code.
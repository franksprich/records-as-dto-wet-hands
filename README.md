# Use Records as DTO

## Breaching the DTO Convention
**OPINION**:   
It is better to NOT use the DTO postfix for transfer objects e.g.
**~~CustomerDTO~~** will than become **Customer**. The reason for that is that transfer objects are
way more often used in further processing of the program.  
Whereas entity classes are only used to represent the access to the stored data on the DB and 
used only when reading/writing to the DB. Entity naming should be changed from
e.g. **~~Customer~~** to **CustomerEntity** or **CustomerET** with the correct mapping to the table `Customer` 
as shown here: 
```java
@Data
@Entity
@Table(name = "Customer")
public class CustomerET {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   ...
```
**REALLY**:   
It does not make sense to read and write 1000 times `CustomerDto` instead of `Customer` in your 
code only to follow the DTO naming convention. This could be solved easily by shifting 
the postfix naming obligation to the entity by using the `*Entity` or `*ET` postfix with 
the correct mapping like `@Table(name = "Customer")`.

## Use MapStruct with Lombok
MapStruct and Lombok can be used together, but you need to be aware 
of a few things to ensure they work properly:

1. **Annotation Processing Order**: Both Lombok and MapStruct use annotation processing, 
   but Lombok should run first to generate getters, setters, and other elements that 
   MapStruct requires. You can ensure this by specifying the following order in your 
   `maven-compiler-plugin` configuration in your `pom.xml` file:
    ```xml
    <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <excludes>
                            <exclude>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                            </exclude>
                        </excludes>
                    </configuration>
                </plugin>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                        <annotationProcessorPaths>
                            <path>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                                <version>${org.projectlombok.version}</version>
                            </path>
                            <path>
                                <groupId>org.mapstruct</groupId>
                                <artifactId>mapstruct-processor</artifactId>
                                <version>${org.mapstruct.version}</version>
                            </path>
                            <!-- other annotation processors -->
                        </annotationProcessorPaths>
                    </configuration>
                </plugin>
            </plugins>
    ```
2. **Use of Constructors:** If you use Lombok's `@AllArgsConstructor` or `@RequiredArgsConstructor`, 
   you should know that MapStruct by default uses the no-argument constructor and getters/setters 
   for mapping. If you want to use constructors for mapping, you will need to define this in your 
   mapper via `@Mapping` or `@BeanMapping`.
3. **Delombok for Debugging**: MapStruct generates implementation classes during the compile phase, 
   but Lombok's modifications to the code are not visible. If you have trouble debugging, 
   you might want to run the Delombok tool to generate Java source code from the Lombok-annotated 
   source code to see what's happening under the hood.
4. **Avoid using Lombok's `@Data` with MapStruct's `@Mapper`**: This is because the @Data annotation 
   includes `@ToString`, `@EqualsAndHashCode`, `@Getter`, `@Setter`, and `@RequiredArgsConstructor`, 
   and the `@ToString` and `@EqualsAndHashCode` could cause problems when used in a MapStruct mapper.

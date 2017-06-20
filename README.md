# OOAD 
### 2017-18学年春季学期
### FDU.14SS
- 14302010026 王子珩
- 14302010016 廖衍松

## 代码结构

### 整个项目使用了Spring Boot框架，持久化使用采用JPA标准的Hibernate框架，数据库使用Mysql
1.数据层
- 实体类位于`src/main/java/fdu14ss/ooad/entity`目录下，有一个共同的抽象类BaseEntity，其他的实体类都继承这个类。实体类都只有基本的getter
和setter方法和构造函数。部分实体类之间存在多对多或多对一的映射关系，其中CheckTemplate与CheckTemplateItem之间存在多对多的映射且有中间表。该目录下
`/enum`则为一些表示状态的枚举类。
- DAO层位于`src/main/java/fdu14ss/ooad/dao`，是数据库接口。都继承了名为JpaRepository的超级接口，从而做到只需要定义接口，只要遵循spring data的规范，就无需写实现类。

2.业务逻辑层
- 业务逻辑位于`src/main/java/fdu14ss/ooad/service`，主要实现了一些对实体类的业务逻辑。

3.JUnit测试
- 测试都位于`src/test/java/fdu14ss/ooad/serviceTest`，包括了对每一个业务逻辑的测试。每个测试文件都包含@Before的初始化操作和@After的清空操作，
从而使得测试对于数据库不会产生影响

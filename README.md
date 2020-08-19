auto-generate
====
脚手架

## 1. 模块说明
|名称|描述
 ---- | ----- 
commons|通用
dao|数据库
api|接口
biz |业务模块
query|查询模块

## 2. 包说明

|名称|描述
 ---- | ----- 
 util|工具
 constant|常量
 enum|枚举
 exception|异常
 transform|转型
 event|事件
 reflect|反射
 function|函数
 math|运算
 mutable|可变
 concurrent|并发
 builder|创建
 compare|比较
 file|文件
 text|文字
 time|时间
 pattern|模式
 support|支持
 
 ## 3. pom样例
 ``<description>脚手架</description>
   <groupId>com.cy.generate</groupId>
   <artifactId>auto-generate</artifactId>
   <version>1.0.0-SNAPSHOT</version>``
 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <description>脚手架</description>
    <groupId>com.cy.generate</groupId>
	<artifactId>biz</artifactId>
	<version>1.0.0</version>
    <name>${project.artifactId}</name>

    <packaging>pom</packaging>

    <properties>
        <encoding>UTF-8</encoding>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <!--jdk 版本-->
        <jdk.version>1.8</jdk.version>
        <api.version>0.0.1-SNAPSHOT</api.version>
        <commons.version>0.0.1-SNAPSHOT</commons.version>
        <biz.version>1.0.0</biz.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>xx.xx.xx.xx</groupId>
                <artifactId>biz-domain</artifactId>
                <version>${biz.version}</version>
            </dependency>
            <dependency>
                <groupId>xx.xx.xx.xx</groupId>
                <artifactId>biz-dao</artifactId>
                <version>${biz.version}</version>
            </dependency>
            <dependency>
                <groupId>xx.xx.xx.xx</groupId>
                <artifactId>biz-manager</artifactId>
                <version>${biz.version}</version>
            </dependency>
            <dependency>
                <groupId>xx.xx.xx.xx</groupId>
                <artifactId>biz-service</artifactId>
                <version>${biz.version}</version>
            </dependency>
            
            <dependency>
                <groupId>xx.xx.xx.xx</groupId>
                <artifactId>api</artifactId>
                <version>${api.version}</version>
            </dependency>
            <dependency>
                <groupId>xx.xx.xx.xx</groupId>
                <artifactId>commons</artifactId>
                <version>${commons.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>xx.xx.xx.xx</groupId>
            <artifactId>commons</artifactId>
        </dependency>
    </dependencies>

    <build>
        <finalName>${project.artifactId}-${project.version}</finalName>
        <defaultGoal>compile</defaultGoal>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>${jdk.version}</source>
                    <target>${jdk.version}</target>
                    <encoding>${encoding}</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.1.1</version>
                <configuration>
                    <packagingExcludes>WEB-INF/web.xml</packagingExcludes>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.6</version>
                <configuration>
                    <encoding>${encoding}</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.21.0</version>
            </plugin>
        </plugins>
    </build>

    

    <profiles>
        <profile>
            <id>local</id>
            <properties>
                <env>local</env>
            </properties>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
        <profile>
            <id>test</id>
            <properties>
                <env>test</env>
            </properties>
        </profile>
        <profile>
            <id>pre</id>
            <properties>
                <env>pre</env>
            </properties>
        </profile>
        <profile>
            <id>prod</id>
            <properties>
                <env>prod</env>
            </properties>
        </profile>
    </profiles>

    <modules>
        <module>biz-domain</module>
        <module>biz-dao</module>
        <module>biz-manager</module>
        <module>biz-service</module>
        <module>biz-web</module>
    </modules>

</project>
```
 
 ## 4. 组件包
 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.0.M4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <description>脚手架</description>
    <groupId>xxx.xxx.xxx.xxx</groupId>
    <artifactId>dao</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <jdk.version>1.8</jdk.version>
        <skipTests>true</skipTests>
        <mybatis.plus.version>3.2.0</mybatis.plus.version>
        <mysql.version>5.1.47</mysql.version>
    </properties>

    <dependencyManagement>
        <dependencies>

        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
            <exclusions>
                <exclusion>
                    <artifactId>protobuf-java</artifactId>
                    <groupId>com.google.protobuf</groupId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>${jdk.version}</source>
                    <target>${jdk.version}</target>
                    <encoding>${project.build.sourceEncoding}</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.4</version>
                <configuration>
                    <encoding>${project.build.sourceEncoding}</encoding>
                    <resources>
                        <resource>
                            <directory>src/main/resources</directory>
                            <includes>
                                <include>**/*.xml</include>
                            </includes>
                            <filtering>false</filtering>
                        </resource>
                    </resources>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>2.7</version>
                <configuration>
                    <encoding>${project.build.sourceEncoding}</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.8.1</version>
                <configuration>
                    <skipTests>true</skipTests>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-source-plugin</artifactId>
                <version>3.0.0</version>
                <configuration>
                    <attach>true</attach>
                </configuration>
                <executions>
                    <execution>
                        <phase>compile</phase>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
```
 
 ## 5. 开发事项
 1. 抽象结构
 2. 系统流程
 3. 问题点
 4. 技术选型
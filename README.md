# Codecool Shop

***
**A Fishing themed webshop, which is an online eCommerce web-application built with Maven and Eclipse Jetty webserver/servlet container, where users can not only browse products, add them into a Shopping Cart, checkout items, but can also register and log in.**
***

## Requirements
* git (to clone the project)
* PostgreSQL
* Maven

## Installation / How to start
##### clone the project:
```
git clone https://github.com/CodecoolGlobal/codecool-shop-2-java-horvatht9411.git
```

##### create a local PostgreSQL database for this project to use e.g. :
```
createdb webshop
```
##### step into the resources folder
```
cd codecool-shop-2-java-horvatht9411/src/main/resources/
```
##### fill the connection.properties file with the corresponding data
```
url=localhost:8888
database=
user=
password=
dao=db
```
##### start psql in a terminal at the sql folder of the project:
```
$ cd ..
$ cd sql
$ psql
```

##### connect to the new database, e.g.:
```
\connect webshop
```
##### execute the commands in the SQL file:
```
\i init_db.sql
\i initializer.sql
```
##### quit from postgres shell and step back to the project root folder:
```
$ \q
$ cd ~/codecool-shop-2-java-horvatht9411/
```
#### Run the program:
```
mvn jetty:run
```
#### start a web browser and open localhost:8888
```
http://localhost:8888
```

# Billing System
This is an incomplete project on billing system of small businesses. This has been developed with Struts2 along with JPA implementation by Eclipselink. 

###Database Setup###
Currently PostgresSQL DB connection has been configured in persistence.xml. However, below queries to be executed to create a database and database user which would be used by the application to connect the DB:

```
CREATE DATABASE billingsys;

CREATE USER 'billingdbuser'@'localhost' IDENTIFIED BY '<preferred-password>';
CREATE USER 'billingdbuser'@'%' IDENTIFIED BY '<preferred-password>';
GRANT ALL ON billingsys.* TO 'billingdbuser'@'localhost';
GRANT ALL ON billingsys.* TO 'billingdbuser'@'%';
```
Application would generate the required tables (as per the persistence objects defined in the persistence.xml) using JPA
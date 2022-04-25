# Billing System
This is an incomplete project on billing system of small businesses. This has been developed with Struts2 along with JPA implementation by Eclipselink. 

### Database Setup
Currently PostgresSQL DB connection has been configured in persistence.xml. However, below queries to be executed to create a database and database user which would be used by the application to connect the DB:

```
CREATE DATABASE billingsys;
CREATE USER billingdbuser with ENCRYPTED PASSWORD '<preferred-password>';
GRANT ALL PRIVILEGES ON DATABASE billingsys TO billingdbuser;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public to billingdbuser;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public to billingdbuser;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public to billingdbuser;
```
Application would generate the required tables (as per the persistence objects defined in the persistence.xml) using JPA

# **Sqoop Commands**

Sqoop offers commands to import, export, eval and other commands to connect to any database (MySQL) and transfer data to and from HDFS and the database.

## **1. Accessing MySQL databases using Sqoop**

### **a. list all databases**

    sqoop-list-databases --connect jdbc:mysql://<db-hostname>:<db-port> --username retail_dba --password cloudera

    sqoop-list-databases --connect jdbc:mysql://quickstart.cloudera:3306 --username retail_dba --password cloudera

### **Output**

![sqoop-list-databases](./sqoopoutput/sqoop_list_all_databases.png)

**Note:** In the blog post, the databases which are meant to be used internally by different tools like Hive (metastore) and etc. are listed and those are ignored by Sqoop and others are displayed.

### **b. list all tables in a database**

    sqoop-list-tables --connect jdbc:mysql://<db-hostname>:<db-port>/<db-name> --username retail_dba --password cloudera

    sqoop-list-tables --connect jdbc:mysql://quickstart.cloudera:3306/retail_db --username retail_dba --password cloudera

### **Output**

![sqoop-list-tables](./sqoopoutput/sqoop_list_all_tables.png)

### **c. eval- run an adhoc query to check the output from the table**

    sqoop-eval --connect jdbc:mysql://<db-hostname>:<db-port> --username retail_dba --password cloudera --query "<sql-query>"

    sqoop-eval --connect jdbc:mysql://quickstart.cloudera:3306 --username retail_dba --password cloudera --query "select * from retail_db.customers limit 10"

### **Output**

![sqoop-eval](./sqoopoutput/sqoop_eval.png)


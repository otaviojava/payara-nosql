# Payara with NoSQL

![Platform.sh and Payara](https://otaviojava.files.wordpress.com/2020/03/payara-psh-book.jpg?w=189)

The NoSQL DB is a database that provides a mechanism for storage and retrieval of data, which is modeled by means other than the tabular relations used in relational databases. These databases have speed and high scalability. This kind of database is becoming more popular in several applications, which include financial ones. As a result of the increase, the number of users and vendors is increasing too. In the Jakarta EE world, there is the [Jakarta NoSQL](https://projects.eclipse.org/projects/ee4j.nosql).
  
We'll create a similar rest application, but using [MongoDB](https://docs.platform.sh/configuration/services/mongodb.html) instead of relational database.

## Reduce Complexity with Middleware as a Service

As a Platform as a Service, or PaaS, Platform.sh automatically manages everything your application needs in order to run. That means you can, and should, view your infrastructure needs as part of your application, and version-control it as part of your application.

Platform.sh is a PaaS built especially for continuous deployment with the goal of making it easier to move your project to cloud-computing to deploy anywhere and anytime. Using the Maven Archetype, you can create a REST project with Payara Micro and move the project to Platform.sh.

In this guide:

* Hello World with Payara Micro and Platform.sh
* Payara Platform with JPA
* Payara Platform with NoSQL
* Payara Micro, Platform.sh and Microservices

## Using Docker

![Docker](https://www.docker.com/sites/default/files/horizontal_large.png)

1. Install docker: https://www.docker.com/
1. https://store.docker.com/images/mongo
1. Run docker command
1. Run MongoDB: verify MongoDB image name with the command `docker images`, it can be mongodb or mongo, and then execute this command 
   * `docker run -d --name mongodb-instance -p 27017:27017 mongo`

![MongoDB Project](http://www.jnosql.org/img/logos/mongodb.png)


## How to Execute

```shell
mvn clean package payara-micro:bundle
java -jar -Xmx512m target/microprofile-microbundle.jar 
```

## Execute

```shell 
curl --location --request POST 'http://localhost:8080/fishes' \
--header 'Content-Type: application/json' \
--header 'Content-Type: application/javascript' \
--data-raw '{"name": "payara"}'
```

```shell
curl --location --request GET 'http://localhost:8080/fishes'
```

## Reference

[Get your free e-book](https://www.payara.fish/page/payara-platform-and-paas-with-platform-sh/)
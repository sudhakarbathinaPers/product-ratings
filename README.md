# product-ratings

## Introduction
This is a Restful microservice which provide product ratings information as shown below:

[  
{    "product_id": "789",    "rating": "1"  },
{    "product_id": "123",    "rating": "3"  },
{    "product_id": "456",    "rating": "5"  }
]

## Technology Stack
* Java 8
* SpringBoot
* SpringDataCassandra
* Maven
* Docker

## Dependency

### Apache cassandra
It requires the database up and running at node mentioned in application.properties. At present it uses EC2 instance.
If not please create the below keyspace, table info and provide cassandra host info as part of cassandra.contactpoints in application.properties

create KEYSPACE product WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

create table productratings (product_id text, rating text, PRIMARY KEY (product_id) );

sample insert statement: INSERT INTO productprice (product_id, rating) values ('123','3');

## Running app

./mvnw package && java -jar target/product-ratings-0.0.1-SNAPSHOT.jar

## To build docker image

./mvnw package docker:build   - This command builds a docker image with name: sudhakarbathina/product-ratings:latest

## Running docker image

docker run -p 9002:9002 -t sudhakarbathina/product-ratings   

## Routes

[list all routes that this service supports]

| Method | Route | Class | Description
| ------ | ----- | ----- | -----------
| GET | /item/ratings/v1 | ProductRatingsController.products | Lists all ItemIds available along with their rating
| GET | /item/ratings/v1/{id} | ProductRatingsController.productRatingById | Provides requested Itemid and rating
| PUT | /item/ratings/v1 | ProductRatingsController.editProductRating | updates rating for a input Itemid

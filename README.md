# Voting Session Management

This is an application for managing polls.

It is possible to register topics, voting sessions, associates and votes.

## Requirements

- Java 8
- Maven 3.6
- google account

## Setup

First you must set up a Google Cloud Project with billing enabled. For this you can follow [these instructions](https://cloud.google.com/sql/docs/postgres/quickstart)

Create a Google Cloud SQL instance from the Google Cloud Console Cloud SQL page. Choose "Postgres" as your database engine. You will be asked to set a password for the postgres root user; remember this value.

Still within the Google Cloud Console SQL page, create a new database in the instance from the "Databases" section.

Open the application.properties file and set the following properties:

``spring.datasource.password`` - Set this to the password that you chose for the postgres user.

``spring.cloud.gcp.sql.database-name`` - Set this to the name of the database you created.

``spring.cloud.gcp.sql.instance-connection-name`` - Set this to the instance name of your Postgres instance. The instance-connection-name should be in the form:`` [gcp-project-id]:[region]:[instance-name]``.

For example, your instance connection name might look like: ``my-gcp-project:us-central1:postgres-test-instance``

If you would like to use a different user, set the ``spring.datasource.username property appropriately``.

Create a service account from the Google Cloud Console and download its private key. Then, uncomment the ``spring.cloud.gcp.credentials.location`` property in the link:src/main/resources/application.properties file and fill its value with the path to your service account private key on your local file system, prepended with file:.

## How to run

You can run the Application Spring Boot app using the following command:

``$ mvn spring-boot:run``

The database will be created based on the schema.sql.

When the application is up, navigate to:

- `` http://localhost:8080/associate_management/add/name=[name]`` to add a new associate.
- `` http://localhost:8080/associate_management/list`` to list all the associates.
- `` http://localhost:8080//topic/create/title=[title]&description=[description]`` to create a new topic.
- `` http://localhost:8080//topic/edit/add_voting_session/id_topic=[id_topic]&title=[title]&time=[time]`` to create a new voting session. _([time] is optional)_
- `` http://localhost:8080//topic/view_all_voting_session/id_topic=[id_topic]`` to see all the polls on that topic.
- `` http://localhost:8080//topic/view_result_voting_session/id_voting_session=[id_voting_session]`` to see the result of a poll.
- `` http://localhost:8080//topic/vote/id_voting_session=[id_voting_session]&id_associate=[id_associate]&choice=[choice]`` to vote in some poll.
- `` http://localhost:8080//topic/list`` to see all the topics ever made.

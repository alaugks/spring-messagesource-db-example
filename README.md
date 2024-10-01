# Example: Spring MessageSource from Database

This example shows how to use the [spring-messagesource-catalogue](https://github.com/alaugks/spring-messagesource-catalog) to implement a MessageSource from a database.

The database used in this example is SQLite.

## Build and Run Docker Image

```bash
docker compose up -d
```

After a successful build, open the example in your web browser: http://localhost:8080

## Custom Changes

If you want to make changes for testing, you have to restart the Docker image.

```bash
docker compose restart
```

> [!NOTE]  
> When you restart, the JAR file is rebuilt and the Tomcat is started. This can take a few seconds.

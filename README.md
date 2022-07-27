<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-jpa
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start project
## Start project by manual

- Start mysql in docker
```
$ cd database
$ docker build --tag mysqldb .
$ docker run  -p 3306:3306 --name mysqldb -d mysqldb
$ cd ..
```

- Check connect to database

```sql
$ mysql -h 127.0.0.1 -u user --password=password
mysql> use spring_boot_jpa_example;
mysql> select * from user;
+---------+-----------+
| user_id | user_name |
+---------+-----------+
|       1 | Huy       |
|       2 | Hai       |
+---------+-----------+
2 rows in set (0.01 sec)

mysql> exit;
```

- Build & start project

```shell script
$ cd spring-boot-jpa
$ ../mvnw clean package
$ ../mvnw spring-boot:run
```

- Send request

```
$ curl http://localhost:8081/api/user\?username\=Huy
{"userId":1,"userName":"Huy"}%
```

## Start project with docker-compose

- Start project
```console
$ docker-compose up -d
```

- Stop project
```console
$ docker-compose down
```

`
## Contribute

## Reference
- https://github.com/iamdvr/prepopulated-mysql-container-example
- https://www.testcontainers.org
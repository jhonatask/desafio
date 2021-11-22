# supera-quarkus Project


## Running the application in dev mode

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  EndPoints.

```shell script
localhost:8080/login
```
Passar parametros de usuario e senha x-www-form-urlencoded
,alun_cpf
,usu_pwd

Listar as matriculas do aluno logado passado alun_id na query param
```shell script
http://localhost:8080/rematricula?alun_id=
```
ex: http://localhost:8080/rematricula?alun_id=0


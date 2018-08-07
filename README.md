# Market Survey Application

Demo de aplicación de estudios de mercado, para implementarla se ha usado:
  - Java 8
  - Spring Boot 1.5.12.RELEASE
  - Gradle
  - Swagger 2.7.0

# Launch application!
Para ejecutar la aplicación basta con el siguiente comando
```sh
$ java -jar market-api-1.0.0-SNAPSHOT.jar
```
Esto hará que se lance la aplicación en el tomcat que se encuentra embebido en Spring Boot.
La aplicación usa una base de datos en memoria H2, para acceder a la consola de base de datos basta con acceder a http://localhost:8080/console/
Una vez arrancado podemos acceder a la api de swagger, para comprobar la documentación y poder probar la aplicación accediendo a http://localhost:8080/swagger-ui.html#/

Para implementar el envío de información a proveedores se ha simulado un envío simultáneo usando threads, aunque la solución mas óptima sería enviar la información a colas de AWS para su posterior procesado mediante lambdas. 


Ejemplo para probar la API

```
{
   "requester": {
      "id": "CVO",
      "name": "Caravelo"
   },
   "provider": [
    {
      "id": "TGI",
      "name": "Kantar"
    },
    {
      "id": "CAR",
      "name": "Caravelo"
    }
  ],
   "survey": {
      "subject": "8000001",
      "target": {
         "gender": "M",
         "age": [
            30,
            60
         ],
         "income": {
            "currency": "EUR",
            "range": [
               100,
               3000
            ]
         }
      },
      "country": "ES"
   },
   "subscription": {
      "frequency": "weekly",
      "channel": [
         "postal",
         "mail",
         "api",
         "ftp"
      ]
   }
}
```
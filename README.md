# ONLINE STORE

Proyecto para aplicar lecciones aprendidas sobre microservicios

## Tecnologias

- Spring 2.2.5.RELEASE
- Java 11
- JSON
- Microservices
- Eureka
- JPA
- Config server
- Sleuth
- Config Cloud
- Hystrix

## Config Cloud

Para configurar spring cloud se necesita de un repositorio donde va estar almacenado nuestros archivos de configuracion.
Se realizaron pruebas con los siguientes repositorios:

- GitHub: Soporta autenticación mediante SSH `ERROR PRIVATE KEY`
- Bitbucket: Soporta autenticación mediante SSH `ERROR PRIVATE KEY`
- Gitlab: Soporta autenticación mediante SSH y Password `PENDIENTE DE PRUEBAS`

Para efectos del proyecto actual se alojan los archivos de configuracion en GitHub pero como un repositorio público

![](images/config-cloud.png)

## Actualizaciones

- Queda pendiente revisar la actualización de la versión de spring (2.7). En estas versiones hay cambios importantes en
  `H2`, las validaciones ya no forman parte de la depencia web ahora se encuentra separado
  en `spring-boot-starter-validation`.

````yaml
# Adicionalmente en el bootstrap.yml agregar lo siguiente
server:
  error:
    include-message: always
    include-binding-errors: always
````

- Evolucionar hacia una administración con docker y kubernetes

## Enlaces de interés

- https://www.javatpoint.com/connect-spring-cloud-config-server-to-local-git-repository
- [spring cloud config with gitlab repository](https://www.youtube.com/watch?v=VAuhoMDnxbk)
- [Documentación oficial Hystrix](https://spring.getdocs.org/en-US/spring-cloud-docs/spring-cloud-openfeign/spring-cloud-feign/spring-cloud-feign-hystrix-fallback.html)
- [Use cases apply Feign and Hystrix](https://stackoverflow.com/questions/61208796/java-feign-client-fallback-cant-call-fallback)
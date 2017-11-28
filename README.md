# mvn-spring-boot-data-jpa-qdsl-sample

---

application.yml
  spring:
    h2:
      console:
        enabled: true
    datasource:
      url: jdbc:h2:~/db_h2/develop

---

  - h2-console
    - http://localhost:18080/h2-console

  - swagger2
    - http://localhost:18080/swagger-ui.html

---

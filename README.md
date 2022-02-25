# How to Run

1. Start mq and ldap using the following command:

```shell
start-docker.cmd
```
2. Open camunda project in IntellijIdea or Eclipse and start Application.java application.
3. Open mqvaadin project in IntellijIdea or Eclipse and start MqvaadinApplication.java application. Node.js is required (?) to compile Vaadin user interface.
4. Go to localhost:8070 and login using users/passwords defined in docker-compose.yml for ldap service.
5. Start camunda process by clicking on corresponding buttons.

## Workflow

MqVaadin UI sends messages to MQ broker to "command queue",
mq listener in Camunda wait these messages, sends it to camunda engine to start a process.
Processes inside camunda, use "data queue" to send the data between stages.

## Useful links

1. http://localhost:8070/ - vaadin application, user01/password1 or user02/password2.
2. https://localhost:9443/ - IBM MQ Admin application, admin/passw0rd.
3. http://localhost:8080/ - camunda admin application, admin/admin.

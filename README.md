# microservices
# Architecture
![image](https://user-images.githubusercontent.com/55704049/141670416-a01983e6-3bd6-4686-9e80-52f448cddcb1.png)

# How to Run
Once you have Cloend the repo, You can simply follow the below :
1. Change the Logging File Path (However you can get rid of that part from Application.yml file of user-service, departmentService and Api gateway) this is implementated as a part of Kibana Implementation.
2. Now you need to run :  `docker run -d -p 9411:9411 openzipkin/zipkin` or download the Zipkin server https://zipkin.io/pages/quickstart.html and follow the quick start page to run the Zipkin jar file
3. Now you can start the Microservices in below order
    a. Config Server
    b. Eureka Server
    c. user-service
    d. department-service
    e. api-gateway
    f. hystrix-server
    


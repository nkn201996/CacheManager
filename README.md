# CacheManager
A simple Cache manager app

## SETUP
### Prerequisites
Maven
Java17
### Steps to run
Run Command ```mvn clean compile install``` to compile
Run Command ```mvn spring-boot:run``` to start the application (Port : 8080)

### To Set the capacity of cache. Modify file - 'src/main/java/com/licious/cache/service/CacheService.java'

### Sample curl to fetch Data
```curl --location 'http://localhost:8080/api/cache?key=d'```

### Sample curl to set Data
```curl --location --request PUT 'http://localhost:8080/api/cache' \
--header 'Content-Type: application/json' \
--data '{
    "key" : "e",
    "value" : "5"
}'```
# CacheManager
A simple Cache manager app

## SETUP
### Prerequisites
Maven , Java17
### Steps to run
To Compile
```
mvn clean compile install
```
To start Application (Port:8080)
```
mvn spring-boot:run
```

### To Set the capacity of cache. Modify file - 'src/main/java/com/licious/cache/service/CacheService.java'

### Sample curl to fetch Data
```
curl --location 'http://localhost:8080/api/cache?key=d'
```

### Sample curl to set Data
```
curl --location --request PUT 'http://localhost:8080/api/cache' \
--header 'Content-Type: application/json' \
--data '{
    "key" : "e",
    "value" : "5"
}'
```
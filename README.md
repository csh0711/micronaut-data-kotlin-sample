# Micronaut Data with Kotlin sample

__Micronat Data__ (previously known as _Micronaut Predator_) is the new database access toolkit of 
[Micronaut](https://micronaut.io/).
It was inspired by Spring Data and GORM but uses the Ahead of Time (AoT) compilation approach known from Micronaut 
to improve performance.

**This repo contains a simple _Micronat Data_ example written in [Kotlin](https://kotlinlang.org/).**

For further details concerning Micronaut Data please see:
- [Official announcement by OCI](https://objectcomputing.com/news/2019/07/18/unleashing-predator-precomputed-data-repositories)
- [Documentation](https://micronaut-projects.github.io/micronaut-data/snapshot/guide/#sql)
- [Github Project Site](https://github.com/micronaut-projects/micronaut-data)

## Entity–relationship model

![Entities](entities.png)

_Note:_ The example uses an in-memory H2.

## Setup
Start the `Application.kt` in your favourite IDE or build the JAR and launch it via
```
> ./gradlew clean shadowJar  
>  java -jar build/libs/micronaut-data-example-0.1-all.jar
 ```
 
 The application should start on `http://localhost:8080` 

## Call the REST API

A [Postman](https://www.getpostman.com/) Project with exemplary requests can be found under `src/test/resources`.

E.g. to create a new _Club_ you need to do a POST to `http://localhost:8080/clubs` with a payload like this:
```json
{
  "name": "Real Madrid",
  "founded": 1902
}
```
To GET a all _Clubs_ call http://localhost:8080/clubs`, to get a certain _Club_ by its ID call `http://localhost:8080/clubs/1`

To create a _Footballer_ and associate it to a previously created _Club_ you POST this to  `http://localhost:8080/footballers`:
```json
{
  "footballer": {
    "firstName": "Toni",
	"lastName": "Kroos",
	"position": "Midfield"
  },
  "clubId":1
}
```

To GET all _Footballers_ you have to call `http://localhost:8080/footballers`. 

To GET all _Footballers_ for a certain _position_ please add the request parameter `position` (e.g. `http://localhost:8080/footballers?position=Midfield`) 

## Next steps
- Add Flyway support
- Add documented Integration- and Unit-Tests
- Add support for [GraalVM Substrate](https://www.graalvm.org/docs/reference-manual/aot-compilation/) so a Native Image may be generated (right now the H2Driver prevents this)
- Write blog post: https://www.novatec-gmbh.de/blog/
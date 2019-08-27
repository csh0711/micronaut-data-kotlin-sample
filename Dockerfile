#FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
#COPY build/libs/*.jar micronaut-data-example.jar
#EXPOSE 8080
#CMD java  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar micronaut-data-example.jar


FROM oracle/graalvm-ce:1.0.0-rc15 as graalvm
COPY . /home/app/micronaut-data-example
WORKDIR /home/app/micronaut-data-example
RUN native-image --no-server -cp build/libs/micronaut-data-example-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-data-example .
ENTRYPOINT ["./micronaut-data-example"]

FROM oracle/graalvm-ce:20.2.0-java11

ADD . /build
WORKDIR /build

# For SDKMAN to work we need unzip & zip
RUN yum install -y unzip zip

RUN \
    # Install SDKMAN
    curl -s "https://get.sdkman.io" | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    sdk install maven 3.6.3; \
    # Install GraalVM Native Image
    gu install native-image;

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && mvn --version

RUN native-image --version

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && mvn -Pnative clean package

# We use a Docker multi-stage build here in order to only take the compiled native Spring Boot App from the first build container
FROM oraclelinux:7-slim

# Add Spring Boot Native app spring-boot-graal to Container
COPY --from=0 "/build/target/spring-boot-graalvm" spring-boot-graalvm

# Fire up our Spring Boot Native app by default
CMD [ "sh", "-c", "./spring-boot-graalvm", "-XX:PercentTimeInIncrementalCollection=40"]
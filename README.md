# Run and build native image with GraalVM on Mac
## Install GraalVM
```shell
sdk install java 21.0.3-graal
```
## Use GraalVM
It's so important to run this command in the shell
```shell
sdk use java 21.0.3-graal
```

## Build native
```shell
mvn -Pnative native:compile 
```

## Build native image with Docker (it's not tested yet)
Docker Desktop must be running
```shell
sdk use java 21.0.3-graal
mvn -DSkipTest -Pnative spring-boot:build-image
```


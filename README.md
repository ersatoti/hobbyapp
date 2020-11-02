# Hobby app (back)

## Generate jar application

### Require gradle
    * gradle clean build

## Run docker

### Generate image

    * docker build -t hobby/hobby-back .

### Run image

    * docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" hobby/hobby-back

### Run image docker compose

    * docker-compose-up

### Remove image hobby
    * docker image rm hobby/hobby-back  --force

## Access swagger 

    * http://localhost:8080/swagger-ui/index.html
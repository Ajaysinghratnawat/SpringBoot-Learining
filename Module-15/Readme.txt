#Docker

#Install docker
https://docs.docker.com/desktop/setup/install/windows-install/

#In cmd
#Version
docker --version

#docker help to show command
docker --help

#Run docker image
docker run nginx(image name)
docker run -p 8090:80 nginx  now it run on port 8090
docker run -d -p 8090:80 nginx  now it run on port 8090  in detached maode in background
docker run -d -p 8090:80 --name=ajay nginx  now it run on port 8090  in detached maode in background and name the container
docker ps -a  to see all running containers
docker ps -q  to see all id of all containers
docker stop ajay(name of container or id)  to stop the container
docker start ajay(name of container or id)  to start the container
docker stop $(docker ps -q)  to stop all the containers
docker rm name   to delete container

#Ubuntu
docker run -it ubuntu
ls


#In terminal
first build a jar file using maven package run
then run in terminal
->docker build -t docker-service:v0.0.1 .   to create a image
->docker run docker-service:v0.0.1          to run docker image

#create image of project run in terminal
 ./mvnw clean install spring-boot:build-image


#Docker hub
https://hub.docker.com/

#terminal
#login
docker login -u ajay5529

#to see images
docker images

#to tag image
docker tag docker-service:v0.0.1 ajay5529/docker-service:v0.0.1

#to push
docker push ajay5529/docker-service:v0.0.1

#Docker compose
#Build image
docker build -t ajay5529/docker-service .

#Run docker compose
docker compose up

#Stop docker compose
docker compose down




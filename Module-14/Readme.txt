Run cmd as adminstrator
install wsl -> wsl --install

install java in wsl ->  sudo apt update
                        sudo apt install openjdk-21-jdk -y

#Create cluster id
KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
echo $KAFKA_CLUSTER_ID -> to check id like(NnN94rI-TZeLdkMOEzlwJw)

#For cluster id
bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties

#Start kafka-ui at port 8080 then run this command in wsl
java -Dspring.config.additional-location=application-local.yml --add-opens java.rmi/javax.rmi.ssl=ALL-UNNAMED -jar api-v1.5.0.jar

#Start Kafka
bin/kafka-server-start.sh config/server.properties

#Create Event
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

#Describe the event
bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap -server localhost:9092

#Write events
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092

#Read events
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

#Create application.yml file inside kafka folder
logging:
  level:
    root: INFO
    io.kafbat.ui: DEBUG

spring:
  jmx:
    enabled: true

kafka:
  clusters:
    - name: local
      bootstrapServers: localhost:9092

java -Dspring.config.additional-location=<path-to-application-local.yml> --add-opens java.rmi/javax.rmi.ssl=ALL-UNNAMED -jar <path-to-kafbat-ui-jar>

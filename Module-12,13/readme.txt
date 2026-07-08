Api to hit for microservice -> http://localhost:8080/api/v1/inventory/products/fetchOrders

Download zipkin to trace the api
then add four dependencies
<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-observation</artifactId>
</dependency>
<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-brave</artifactId>
</dependency>
<dependency>
			<groupId>io.zipkin.reporter2</groupId>
			<artifactId>zipkin-reporter-brave</artifactId>
</dependency>
<dependency>
			<groupId>io.github.openfeign</groupId>
			<artifactId>feign-micrometer</artifactId>
</dependency>
and add actuator also this all do for all microservice and api gateway also
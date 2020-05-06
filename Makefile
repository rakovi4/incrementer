APP = incrementer

build:
	./gradlew clean war
	docker build -t $(APP):test . --build-arg app=$(APP)

undeploy:
	-docker stop $(APP)
	-docker rm $(APP)

deploy: undeploy
	docker run -d --name $(APP) -p 8080:8080 $(APP):test

clean: undeploy
	./gradlew clean
	-docker rmi $(APP):test

all: clean build test deploy

test:
	./gradlew test

.PHONY: all build clean test



.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.12

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run:
	./gradlew run

run-dist:
	./build/install/app/bin/app

test:
	./gradlew test

report:
	./gradlew jacocoTestReport --rerun-tasks

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build
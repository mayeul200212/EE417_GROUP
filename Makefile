export COMPOSE_PROJECT_NAME=ee417-grp
export UID=$(shell id -u)
export NAME_UID=$(shell id -u -n)
export GUID=$(shell id -g)
export NAME_GUID=$(shell id -g -n)

##### BUILD #####

.PHONY: build
build:
	COMPOSE_DOCKER_CLI_BUILD=0 docker-compose -f docker-compose.dev.yml build --force-rm --parallel

##### DEV #####

.PHONY: dev-all
dev-all:
	docker-compose -f docker-compose.dev.yml up -d --remove-orphans --build db reverse-proxy
	docker-compose -f docker-compose.dev.yml up --remove-orphans --build client server

#### PROD ####

prod:
	COMPOSE_PROJECT_NAME=ee417-grp-prod docker-compose -f docker-compose.prod.yml up -d --remove-orphans --build db ee-reverse-proxy
	COMPOSE_PROJECT_NAME=ee417-grp-prod docker-compose -f docker-compose.prod.yml up -d --remove-orphans --build client server
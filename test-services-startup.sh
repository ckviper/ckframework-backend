#!/bin/bash
set -e

(docker network create iam-network)
echo "keycloak"
(cd keycloak && docker-compose up --build -d)
echo "spring-services"
(cd spring-services && docker-compose up --build -d)
echo "vllm"
(cd vllm && docker-compose up --build -d)

echo "done"

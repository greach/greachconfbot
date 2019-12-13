#!/bin/sh
docker build . -t greachconf-telegrambot
mkdir -p build
docker run --rm --entrypoint cat greachconf-telegrambot  /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000


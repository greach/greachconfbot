#!/bin/bash
docker build . -t greachconf-telegrambot
mkdir -p build
docker run --rm --entrypoint cat greachconf-telegrambot  /home/application/function.zip > build/function.zip
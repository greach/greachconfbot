#!/bin/sh
docker build . -t greachconf-telegrambot
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 greachconf-telegrambot"

#!/bin/bash
docker network create grid	# create grid
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-radium	# run hub
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-radium	# add chrome node
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox:3.141.59-radium	# add firefox node
# DEBUG HUBS
# docker run -d -P -p 5900:5900 --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome-debug:3.11.0-dysprosium
# docker run -d -P -p 5901:5900 --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox-debug:3.11.0-dysprosium
cd ~	# go to main directory
cd GitRepos/ssFirstTask/Task	# go to project directory
docker run -it --rm -v $PWD:$PWD -w $PWD -v /var/run/docker.sock:/var/run/docker.sock maven:3 mvn clean test
# vn clean test	# run maven tests
docker kill $(docker ps -q)	# kill all containers
docker network rm grid	# turn down grid
docker stop selenium-hub	# stop selenium hub
docker rm selenium-hub	#remove selenium hub
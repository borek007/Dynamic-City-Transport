#!/usr/bin/env bash

set -xeoui pipefail

mkdir -p build

find src -name "*.java" > sources.txt
javac -d build -cp jars/jade.jar @sources.txt

java -cp jars/jade.jar:build jade.Boot -gui # -agents "agentName:AgentClass(arg1,arg2);agentName2:AgentClass(arg1,arg2)"

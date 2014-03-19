#!/bin/bash
echo Building target jar files...
mvn clean package

echo Copying jar files to the NAS...
cp -Rvf backup-runner/target/*.jar /Volumes/public/bitrush/
cp -Rvf backup-runner/target/lib/*.jar /Volumes/public/bitrush/lib/

echo Deploying has been done.

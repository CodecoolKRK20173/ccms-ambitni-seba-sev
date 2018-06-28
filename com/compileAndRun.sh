#!/bin/bash
find -name '*.java' > sources.list
mkdir -p out
javac @sources.list -d out && java -cp out:resources com.Main

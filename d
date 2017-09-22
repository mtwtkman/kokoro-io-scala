#! /bin/sh

name="kokoro-io-scala"

case $1 in
  "build") docker build . -t $name;;
  "new") docker run -ti --rm -v `pwd`:/app $name sbt new sbt/scala-seed.g8;;
  "repl") docker run -ti --rm --name $name -v `pwd`:/app -w="/app/kokoro-io-client/" $name sbt;;
  "*") $1;;
esac

FROM ubuntu:latest
LABEL authors="souvik"

ENTRYPOINT ["top", "-b"]
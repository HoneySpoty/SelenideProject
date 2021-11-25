FROM markhobson/maven-chrome:jdk-8

MAINTAINER Vladmir Sivkov <vovasivkov@gmail.com>

ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

COPY ./ /tests
COPY pom.xml /tests
WORKDIR /tests

ADD start.sh /
RUN chmod +x /start.sh

CMD ["/start.sh"]

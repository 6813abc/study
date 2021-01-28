FROM java:alpine
VOLUME /tmp
ADD study.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java","-jar","/app.jar"]
#设置环境变量，yml中读取这些环境变量，读取不到则用默认值
ENV DATASOURCE_DBTYPE mysql
ENV DATASOURCE_HOST mysqldbserver
ENV DATASOURCE_PORT 3306
ENV DATASOURCE_USERNAME root
ENV DATASOURCE_PASSWORD root123
ENV DATASOURCE_DRIVER com.mysql.jdbc.Driver

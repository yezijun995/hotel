@ECHO ON

SET CLASSPATH=%CLASSPATH%;config;hotel-admin.jar;
SET JAVA_OPS="-XX:PermSize=512m -XX:MaxPermSize=512m -Xms1g -Xmx1g"
GOTO RUN

:RUN
echo %CLASSPATH%
java %JAVA_OPS% -cp %CLASSPATH% org.springframework.boot.loader.JarLauncher
pause
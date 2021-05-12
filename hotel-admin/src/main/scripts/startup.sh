#!/bin/sh
COMMAND=$1
Xms=${2:-1g}
Xmx=${3:-1g}
PROCESS_PARM="hotel-admin"
CUR_USER=`whoami`
if [ "$COMMAND" == "stop" ] ;
then

 ps -ef|grep "DappName=${PROCESS_PARM}" |grep ${CUR_USER}  | grep java | grep -v grep | awk '{print $2}' |while read pid
 do
   kill -9 ${pid} 2>&1 >/dev/null
   echo "stopped ${PROCESS_PARM} success PID:${pid} "
 done
elif [ "$COMMAND" == "start" ] ;
then

 if [ ! -x logs ];then
  mkdir logs
 fi
 export EXEC=hotel-admin.jar
 export CLASSPATH=.:./config/:${EXEC}
 export JAVA_OPS="-server -XX:PermSize=128m -XX:MaxPermSize=256m -Xms${Xms} -Xmx${Xmx} -Duser.timezone=GMT+08 -DappName=${PROCESS_PARM}"
 echo ${CLASSPATH}
 nohup java ${JAVA_OPS} -cp ${CLASSPATH} org.springframework.boot.loader.JarLauncher &>logs/stdout 2>logs/err.log &


elif [ "$COMMAND" == "restart" ] ;

then

 ps -ef|grep "DappName=${PROCESS_PARM}" |grep ${CUR_USER}  | grep java | grep -v grep | awk '{print $2}' |while read pid
 do
   kill -9 ${pid} 2>&1 >/dev/null
   echo "stopped ${PROCESS_PARM} success PID:${pid} "
 done

 if [ ! -x logs ];then
  mkdir logs
 fi
 export EXEC=hotel-admin.jar
 export CLASSPATH=.:./config/:${EXEC}
 export JAVA_OPS="-server -XX:PermSize=128m -XX:MaxPermSize=256m -Xms${Xms}  -Duser.timezone=GMT+08 -Xmx${Xmx} -DappName=${PROCESS_PARM}"
 echo ${CLASSPATH}
 nohup java ${JAVA_OPS} -cp ${CLASSPATH} org.springframework.boot.loader.JarLauncher &>logs/stdout 2>logs/err.log &

else

 echo "please send the param  start/stop/restart"

fi

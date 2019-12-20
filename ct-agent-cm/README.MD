java agent JDK1.5引入的也叫java代理
javaAgent是运行在main方法之前的拦截器，内定的方法名叫 premain().


java -javaagent:/opt/myagent.jar=Hello1 -jar myapp.jar
java agent JDK1.5引入的也叫java代理
javaAgent是运行在main方法之前的拦截器，内定的方法名叫 premain().

java -javaagent:/opt/myagent.jar=Hello1 -jar myapp.jar



JDK5中只能通过命令行参数在启动JVM时指定javaagent参数来设置代理类，
JDK6中不仅在启动JVM时通过配置参数来设置代理类，还可以通过 Java Tool API 中的 attach 方式
可以很方便地在运行过程中动态地设置加载代理类，以达到 instrumentation 的目的。 



** 目标jvm进程和agent程序是一起运行
  *使用命令：java -javaagent:jar 文件的位置 [= 传入 premain 的参数 ]

** 如果目标JVM已经运行，可以通过 agentMain函数
    public static void agentmain (String agentArgs, Instrumentation inst); [1] 
    public static void agentmain (String agentArgs); 

manifest文件的key值改为Agent-Class
        Manifest-Version: 1.0
        Premain-Class: com.sun.btrace.agent.Main
        Agent-Class: com.sun.btrace.agent.Main
        
        




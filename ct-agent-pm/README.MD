java agent test program


打包 ct-agent-cm.jar 、ct-agent-pm.jar
执行 java -javaagent:ct-agent-cm.jar=hello1  -jar ct-agent-pm.jar
输出 :
====Agent代理1执行
hello1
执行main方法


执行 java -javaagent:ct-agent-cm.jar=hello1 -javaagent:ct-agent-cm.jar=hello2  -jar ct-agent-pm.jar
输出 :
====Agent代理1执行
hello1
====Agent代理1执行
hello2
执行main方法

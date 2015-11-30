# wechat-dev-framework
微信开发辅助框架

### 用途
减少微信开发的重复工作，故将线上项目中对于微信公众号接入的部分抽取出来，形成此项目。

### 依赖
1.    common-httpclient-3.1.jar
2.    common-io-2.4.jar
3.    gson-2.2.4.jar
4.    guava-18.0.jar
5.    hamcrest-core-1.3.jar
6.    httpclient-4.3.3.jar
7.    httpclient-cache-4.3.3.jar
8.    httpcore-4.3.3.jar
9.    httpmime-4.3.3.jar
10.   junit-4.12.jar
11.   log4j-1.2.16.jar
12.   slf4j-api-1.6.1.jar
13.   slf4j-log4j12-1.6.1.jar
14.   xmlpull-1.1.3.1.jar
15.   xstream-1.4.8.jar

### package
***beans***
所有微信交互过程中所涉及的对象，其中包括提交的xml参数以及接收到响应的xml信息

***capabilities***
微信部分的处理能力，所谓处理能力就是相关功能，包括访问验证，授权，消息，支付等

***commands***
命令接口，在处理能力中，会有回调参数，这些内容是通过客户端实现命令接口来进行回调

***config***
相关的全局设置

***converts***
转换模块，主要是用于xml与bean之间的转换

***exceptions***
异常处理

***utils***
相关工具模块，提供了字符串解析拼接，web访问（get，post），xml转换
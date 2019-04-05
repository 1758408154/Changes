#基于springboot的一个简单的webSocket demo
---
- 运用场景说明:
   
   - 前端需要展示后端实时监控的数据，如果在前端利用定时刷新的话，会造成资源浪费
   - 采用webSocket的方式，前端和后台双向长连接，实时获取数据并展示
---
1. 后台项目：
   springboot+webSocket的整合，在[Springboot系列-集成webSocket实时通信](https://www.xncoding.com/2017/07/15/spring/sb-websocket.html)的学习基础上进行整理
2. 说明
   
   1.  @EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思。
   2. registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL
   3. addEndpoint(“/simple”).withSockJS(); 用来注册STOMP协议节点，同时指定使用SockJS
   4. configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
   5. say方法上添加的@MessageMapping注解和我们之前使用的@RequestMapping类似。@SendTo注解表示当服务器有消息需要推送的时候， 会对订阅了@SendTo中路径的浏览器发送消息。
   6. 我还定义了一个定时推送消息方法，这个方法每隔1秒会主动给订阅了主题/topic/callback的客户端推送消息。
3. 前端:
   
   简单的html例子   

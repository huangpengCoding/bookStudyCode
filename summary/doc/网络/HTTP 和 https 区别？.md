

问题：HTTP 和 https 区别？

> 1. HTTP 明文传输，数据都是未加密的，安全性较差，HTTPS（SSL+HTTP） 数据 传输过程是加密的，安全性较好。 
> 2. 使用 HTTPS 协议需要到 CA（Certificate Authority，数字证书认证机构） 申 请证书，一般免费证书较少，因而需要一定费用。 
> 3. HTTP 页面响应速度比 HTTPS 快，主要是因为 HTTP 使用 TCP 三次握手建立 连接，客户端和服务器需要交换 3 个包，而 HTTPS 除了 TCP 的三个包，还要加 上 ssl 握手需要的 9 个包，所以一共是 12 个包。 
> 4. http 和 https 使用的是完全不同的连接方式，用的端口也不一样，前者是 80， 后者是 443。 5. HTTPS 其实就是建构在 SSL/TLS 之上的 HTTP 协议，所以，要比较 HTTPS 比 HTTP 要更耗费服务器资源。 

参考文章：https://www.runoob.com/w3cnote/http-vs-https.html
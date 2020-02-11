## Zuul

### 生命周期
![请求生命周期](./img/zuul请求生命周期.png)

### 限流
![令牌桶限流](./img/令牌桶限流.png)
- 时机：请求被转发之前调用

### Zuul权限校验
- /order/create 只能买家访问
- /order/finish 只能卖家访问
- /product/list 都可访问

### 跨域问题
- 在被调用的类或方法上增加@CrossOrigin注解
- 在Zuul里增加CorsFilter过滤器
## zuul 实现网关 gateway 功能

### 访问
> http://ZUUL-SERVICE-HOST:ZUUL-SERVICE-PORT/serviceId/path, 如：http://localhost:8100/user-service/user/1
> 也可以通过网关路由进行访问：如：http://localhost:8100/api-user/user/2 ("对外时推荐使用")

> 通过 zuul 网关访问 user-service 服务

### 路由端点
> 访问：http://localhost:8100/routes


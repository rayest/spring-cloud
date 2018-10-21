## 仓库服务中心

### 访问
> 在 application.yml 配置文件中，git 地址指向的仓库应为单独的配置文件中心，否则可能访问不到
> 如：http://localhost:8200/branch/payment-test.yml。默认分支是 master

### 其他说明
> 该项目服务于各个微服务，通过注解 `@EnableConfigServer` 启用配置服务，通过 `application.yml` 设置不同环境配置文件的 git 地址
> 在各个微服务中，需要指定 spring cloud 在 git 中的地址、分支、dev/test/prod 
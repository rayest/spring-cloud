# spring-cloud

### 分布式事务 

* seat 实现

> 1. 下载 alibaba seata 依赖、解压
> 2. 修改 file.conf 配置文件中 db 的配置
> 3. 根据 db_store.sql 中 DDL 新建三个表至数据库中
> 4. 启动 seata：***sh seata-server.sh -p 8091 -h 127.0.0.1 -m db***


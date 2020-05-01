# athena
## redis cache storage framework

# 使用方式  
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
在Application启动类上加上`@EnableCache`


# redis 原生的操作  

**key操作**  
`del [key]`   删除key  
`dump [key]`   序列化key  
`exists [key]`  检查key是否存在  
`expire [key] [seconds]`  key设置过期时间/s  
`pexpire [key] [milliseconds]` key设置过期时间/ms  
`expireat [key] [timestamp]` key设置过期时间戳/s  
`pexpireat [key] [ms-timestamp]` key设置过期时间戳/ms  
`keys [pattern]` 模糊查询key  
`move [key] [db]` 给key移动数据库  
`persist [key]` 移除过期时间  
`pttl [key]` 查询key剩余过期时间/ms  
`ttl [key]` 查询key剩余过期时间/s  
`randomkey` 随机返回一个key  
`rename [key] [new-key]` 修改key名称  
`renamenx [key] [new-key]` 修改key名称,new-key存在报错  
`type [key]` 查询key类型  
**string操作**  
`set [key] [value]` 设定key的值  
`get [key]` 获取key的值  
`strlen [key]` 获取值的长度  
`mget [keys]` 获取多个key的值  
`incr [key]` 值递增  
`incrby [key] [increment]` 值指定增量  
`decr [key]` 值递减
`decrby [key] [decrement]` 值指定减量  
**hash操作**  
`hdel [key] [fields]` 删除hash多个字段  
`hexists [key] [field]` 查看hash字段是否存在  
`hget [key] [field]` 获取hash字段的值  
`hgetall [key]` 获取hash所有字段的值  
`hkeys [key]` 获取hash所有字段  
`hlen [key]` 获取hash字段数量  
`hset [key] [field] [value]` 设置hash字段以及值  
**list操作**  
`lpop [key]` 获取list第一个元素  
`blpop [key] [timeout]` 阻塞获取list第一个元素  
`rpop [key]` 获取list最后一个元素  
`brpop [key] [timeout]` 阻塞获取list最后一个元素  
`llen [key]` 获取list长度  
`lindex [key] [index]` 通过index获取list元素  
`lpush [key] [value]` 设置list头部值  
`rpush [key] [value]` 设置list尾部值  
`lset [key] [index] [value]` 设置list指定index值  
**set操作**  
`sadd [key] [members]` 向set添加元素  
`sinter [key1] [key2]` 获取set交集  
`sdiff [key1] [key2]` 获取set差集  
`sismember [key] [member]` 判断元素是否是集合元素  
`smembers [key]` 获取set所有元素  
`srem [key] [members]` 移除set中元素  
**sort set操作**  
`zadd [key] [score value]` 向sset中添加元素  
`zrem [key] [values]` 移除sset元素  


# @RequestBody と HttpServletRequest の getReader() 検証

## 検証方法

1. ターミナルAで、bootRunをする。

```sh
./gradlew bootRun
```

2. ターミナルBで、POSTリクエストを送る。

```sh
# @RequestBody と HttpServletRequest を併用
$ curl -XPOST -H "Content-Type: application/json" localhost:8080/hello/rb -d '{"body": "hello"}'
{"timestamp":"2020-09-23T15:24:07.633+0000","status":500,"error":"Internal Server Error","message":"getInputStream() has already been called for this request","path":"/hello/rb"}

# @RequestBody は未使用
$ curl -XPOST -H "Content-Type: application/json" localhost:8080/hello/sr -d '{"body": "hello"}'
{"body": "hello"}
```


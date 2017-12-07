## @JsonFormat
此注解用于属性或者方法上（最好是属性上），可以方便的把Date类型直接转化为我们想要的模式，比如@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")

## @JsonSerialize
此注解用于属性或者getter方法上，用于在序列化时嵌入我们自定义的代码，比如序列化一个double时在其后面限制两位小数点。（当然也可以处理日期）

## @JsonDeserialize
此注解用于属性或者setter方法上，用于在反序列化时可以嵌入我们自定义的代码，类似于上面的@JsonSerialize。（当然也可以处理日期）

## 测试结果

| consumer-feign | date-service | 结果 | 猜测 |
|-----------------|-------------|-----| -----|
| default | default | OK | 双方的json格式日期序列化和反序列化一致|
| yyyy-MM-dd HH:mm:ss| default | @RequestBody传参不行,@Requestparam传参可以| body传参用的json格式，涉及日期序列化和反序列化 |
| default | yyyy-MM-dd HH:mm:ss | @RequestBody传参不行,@Requestparam传参可以| body传参用的json格式，涉及日期序列化和反序列化 |
| yyyy-MM-dd HH:mm:ss | yyyy-MM-dd HH:mm:ss | OK | 双方的json格式日期序列化和反序列化一致|


## 结论

feign调用其实一样遵循Controller层postman调用，@RequestParam传参不受json日期格式影响，但是项目中所有@RequestBody传参的json参数中的日期格式
需要遵循相同的解析pattern，如yyyy-MM-dd HH:mm:ss
# spring boot2.0 mybatis pagehelper sqlite3 整合

### 注意

1. 我使用的是jdk 11, 可以改成 jdk8。

2. sqlite 数据库文件在 项目根目录下。

3. 记住要修改[ application.yml ]文件中的 datasource.url 属性

   ```yaml
     # 把 jdbc:sqlite: 改成你本地的地址
     datasource:
       url: jdbc:sqlite:D:/development/SQLite3/test1.db3
   
   ```

   






# ALAPI-SDK
ALAPI 的 Java SDK / Java SDK for ALAPI.

## 环境要求 (Environment)
 - Java 8 / Kotlin
 - Maven / Gradle
 - Language Level 8 or greater

## 安装 (Installation)
(如果想以 jar 包安装) If you want to install with jar file

(下载) Download [`dist/alapi-javasdk.jar`](dist/alapi-javasdk.jar)

### Apache Maven
package manager
```xml
<dependency>
  <groupId>cn.alapi</groupId>
  <artifactId>javasdk</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

Jar
```xml
<dependency>
  <groupId>cn.alapi</groupId>
  <artifactId>javasdk</artifactId>
  <version>1.0.1</version>
  <scope>system</scope>
  <systemPath>path/to/alapi-javasdk.jar</systemPath>
</dependency>
```

### Gradle

package manager
```groovy
implementation 'cn.alapi:javasdk:1.0'
```

Jar
```groovy
compile files('path/to/alapi-javasdk.jar')
```


## 示例 (Example)
```java
// 替换为你自己的包名 / replace it with your own package name
package org.example.sdktest;

import cn.alapi.javasdk.AlapiClient;
import cn.alapi.javasdk.AlapiRequest;
import cn.alapi.javasdk.AlapiResponse;

public class TestClass {
    // 定义为静态属性以更好地重用
    // Defined as a static property for better reuse
    private static final AlapiClient client = new AlapiClient()
            .setToken("your access token / 你的 token");

    public static void main(String[] args) {
        AlapiRequest request = new AlapiRequest();
        // API 地址 / specific API path
        request.setApi("/api/domain/dns");
        request.addTextParam("domain", "alapi.net");
        // 如果想上传文件，使用 "addFileParam" 方法
        // If you want to upload files, use the "addFileParam" method
        try {
            AlapiResponse response = client.execute(request);
            System.out.println(response.getCode()); // status code / 状态码
            System.out.println(response.getMsg()); // status message / 状态消息
            System.out.println(response.getData()); // api data / 请求数据
            System.out.println(response.getTime()); // timestamp / 时间戳
            System.out.println(response.getLogID()); // log id for this request / 本次请求记录 ID
        } catch (Exception ignored) { }
    }
}
```

## 接口文档地址
ALAPI 接口文档地址：[https://www.alapi.cn](https://www.alapi.cn)
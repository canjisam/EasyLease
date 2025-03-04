#  宅易租房屋租赁平台项目 README

---

## 项目简介
**宅易租**是一款基于 Java 开发的公寓租赁管理系统，旨在实现房源管理、租客信息跟踪、合同管理、费用结算等核心功能。项目采用模块化设计，结合企业级开发规范，适用于中小型公寓管理场景。该项目由尚硅谷教育团队开发，注重技术栈的完整性和实用性，涵盖主流框架与工具链。

---

## 技术栈
| 类别         | 技术/工具                | 说明                                                                 |
|--------------|--------------------------|----------------------------------------------------------------------|
| **后端框架** | Spring Boot              | 提供快速构建和配置能力，整合 MyBatis 实现数据持久化                  |
| **数据库**   | MySQL                    | 存储房源、租客、合同等核心数据                                       |
| **前端**     | Vue.js + ElementUI       | 构建响应式管理界面（需根据项目实际确认是否包含前端部分）             |
| **中间件**   | Redis                    | 缓存高频访问数据（如房源状态）                                       |
| **构建工具** | Maven                    | 依赖管理与项目构建                                                   |
| **其他工具** | Swagger2                 | 接口文档生成工具                                                     |
| **部署**     | Tomcat/Nginx             | 支持多环境部署                                                       |

---

## 功能模块
### 1. 房源管理
- **房态管理**：实时展示房源状态（空闲、已租、维护中）。
- **房源录入**：支持批量导入或手动添加房源信息，包括户型、价格、设施等。
- **图片上传**：关联房源图片，支持云存储（如阿里云OSS）。

### 2. 租客管理
- **租客信息**：记录租客身份信息、联系方式及租赁历史。
- **合同管理**：生成电子合同，支持在线签署与到期提醒。

### 3. 支付与财务
- **租金结算**：按月生成账单，对接支付宝/微信支付接口。
- **财务报表**：统计收支情况，导出 Excel 或 PDF 格式报表。

### 4. 系统管理
- **权限控制**：基于 RBAC 模型实现角色权限分配。
- **日志监控**：记录操作日志，集成 Spring AOP 实现行为跟踪。

---

## 项目结构
```plaintext
stgy-apartment/
├── src/main/
│   ├── java/
│   │   ├── com.atguigu.stgy/
│   │   │   ├── controller/      # 控制层（API接口）
│   │   │   ├── service/         # 业务逻辑层（接口与实现分离）
│   │   │   ├── dao/             # 数据访问层（MyBatis Mapper）
│   │   │   ├── entity/          # 实体类（JPA 或 POJO）
│   │   │   ├── config/          # 配置类（Swagger、Redis等）
│   │   │   └── util/            # 工具类（日期处理、加密等）
│   ├── resources/
│   │   ├── application.yml      # 主配置文件（多环境配置）
│   │   ├── mapper/              # MyBatis XML 映射文件
│   │   └── static/              # 静态资源（可选）
├── sql/                         # 数据库初始化脚本
└── pom.xml                      # Maven 依赖管理
```

---

## 部署步骤
1. **环境准备**：
   - JDK 1.8+、MySQL 5.7+、Maven 3.6+。
   - 导入 `sql/init.sql` 初始化数据库表结构。

2. **配置修改**：
   - 修改 `application.yml` 中的数据库连接信息及 Redis 配置。
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/stgy?useSSL=false&serverTimezone=UTC
       username: root
       password: 123456
   ```

3. **构建与运行**：
   ```bash
   mvn clean package
   java -jar target/stgy-apartment-1.0.0.jar
   ```

4. **访问接口**：
   - Swagger 文档：`http://localhost:8080/swagger-ui.html`

---

## 注意事项
1. **依赖冲突**：检查 Spring Boot 与 MyBatis 版本兼容性，避免启动报错。
2. **敏感信息**：切勿将数据库密码或云存储密钥提交至公开仓库。
3. **异常处理**：统一使用全局异常拦截器（如 `@ControllerAdvice`）处理业务异常。
4. **性能优化**：高频查询接口建议增加 Redis 缓存，减少数据库压力。

---

## 参考资源
- **MyBatis 官方文档**：[配置与映射文件详解](http://www.mybatis.org/mybatis-3/) 
- **Spring Boot 教程**：[快速入门指南](https://spring.io/guides/gs/spring-boot/) 

---

# 如何启动

## 1 后台启动
### 1.1 启动后端项目
#### 1.1.1 刷新pom文件
![alt text](image.png)
#### 1.1.2 创建并启动minIO
    配置文件如下
![alt text](image-1.png)
#### 1.1.3 创建并启动redis
    配置文件如下
![alt text](image-2.png)
#### 1.1.4 导入数据库并修改yml
    lease.sql
![alt text](image-5.png)
修改yml文件中的数据库密码

    lease/web/web-admin/src/main/resources/application.yml

![alt text](image-7.png)

    lease/web/web-app/src/main/resources/application.yml

![alt text](image-6.png)
### 1.2 启动应用
#### 1.2.1 启动后台管理系统
    运行AdminWebApplication
![alt text](image-3.png)
#### 1.2.2 启动后台管理系统
    运行AppWebApplication
![alt text](image-4.png)

## 2 后台管理系统前后端联调

### 2.1 启动后端项目

启动后端项目，供前端调用接口。

### 2.2 启动前端项目

#### 2.2.1 安装Node和npm

1. **部署Node和npm**

   Node和npm的部署比较简单，拿到安装包后按照安装向导操作即可。

2. **配置npm国内镜像**

   为加速npm下载依赖，可以为npm配置国内镜像，在终端执行以下命令为npm配置阿里云镜像。

   ```bash
   npm config set registry https://registry.npmmirror.com
   ```

#### 2.2.2 启动前端项目

1. **导入前端项目**

   将后台管理系统的前端项目（**rentHouseAdmin**）导入`vscode`或者`WebStorm`，打开终端，在项目根目录执行以下命令，安装所需依赖

   ```bash
   npm install
   ```

2. **启动前端项目**

   上述配置完成之后，便可执行以下命令启动前端项目了

   ```bash
   npm run dev
   ```
   
![alt text](image-8.png)
4. **访问前端项目**

   在浏览器中访问前端项目，并逐个测试每个页面的相关功能。
   
## 3 移动端前后端联调

### 3.1 启动前端项目

1. **导入前端项目**

   将移动端的前端项目（**rentHouseH5**）导入`vscode`或者`WebStorm`，打开终端，在项目根目录执行以下命令，安装所需依赖

   ```bash
   npm install
   ```

2. **启动前端项目**

   上述配置完成之后，便可执行以下命令启动前端项目了

   ```bash
   npm run dev
   ```

3. **访问前端项目**

   在浏览器中访问前端项目，并逐个测试每个页面的相关功能。
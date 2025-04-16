# 宅易租多项目启动指南

## 🚀 一键启动脚本使用说明

### 前置条件

#### 前端环境
- Node.js (v16+)
- npm

#### 后端环境
- Java JDK (v11+)
- Maven

### 启动步骤

1. 打开PowerShell
2. 导航到项目根目录
3. 执行命令：`.\start_all.ps1`

### 脚本功能

- ✅ 自动检查运行环境
- ✅ 安装前端依赖
- ✅ 编译后端项目
- ✅ 并行启动四个项目
  - rentHouseAdmin (前端)
  - rentHouseH5 (前端)
  - web-admin (后端)
  - web-app (后端)

### 注意事项

- 首次运行可能需要较长时间下载依赖和编译
- 确保网络连接正常
- 以管理员身份运行PowerShell（如遇权限问题）
- 检查每个项目的控制台输出，确认启动成功

### 常见问题排查

1. 端口冲突
   - 检查并关闭占用相同端口的其他进程
   - 修改`start_all.ps1`中的启动命令，调整端口

2. 依赖问题
   - 删除各项目下的`node_modules`文件夹
   - 重新运行脚本

3. 编译失败
   - 检查Maven配置
   - 确保所有依赖已正确下载

## 💡 手动启动备选方案

如脚本启动失败，可以手动启动：

### 前端项目
```bash
cd frontend/rentHouseAdmin
npm install
npm run dev

cd frontend/rentHouseH5
npm install
npm run dev
```

### 后端项目
```bash
cd backend/web-admin
mvn clean package
java -jar target/web-admin.jar

cd backend/web-app
mvn clean package
java -jar target/web-app.jar
```

## 🛠 开发建议

- 保持各项目依赖最新
- 定期执行`mvn clean`和`npm cache clean`
- 使用统一的代码风格和规范
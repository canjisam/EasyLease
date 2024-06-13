
## 7.3 后台管理系统前后端联调

### 7.3.1 启动后端项目

启动后端项目，供前端调用接口。

### 7.3.2 启动前端项目

#### 7.3.2.1 安装Node和npm

1. **部署Node和npm**

   Node和npm的部署比较简单，拿到安装包后按照安装向导操作即可。

2. **配置npm国内镜像**

   为加速npm下载依赖，可以为npm配置国内镜像，在终端执行以下命令为npm配置阿里云镜像。

   ```bash
   npm config set registry https://registry.npmmirror.com
   ```

   若想取消上述配置，可在终端执行以下命令删除镜像，删除后将恢复默认配置。

   ```bash
   npm config delete registry
   ```

#### 7.3.2.2 启动前端项目

1. **导入前端项目**

   将后台管理系统的前端项目（**rentHouseAdmin**）导入`vscode`或者`WebStorm`，打开终端，在项目根目录执行以下命令，安装所需依赖

   ```bash
   npm install
   ```

2. **配置后端接口地址**

   修改项目根目录下的`.env.development`文件中的`VITE_APP_BASE_URL`变量的值为后端接口的地址，此处改为`http://localhost:8080`即可,如下

   ```ini
   VITE_APP_BASE_URL='http://localhost:8080'
   ```

   **注意**：

   上述主机名和端口号需要根据实际情况进行修改。

3. **启动前端项目**

   上述配置完成之后，便可执行以下命令启动前端项目了

   ```bash
   npm run dev
   ```

4. **访问前端项目**

   在浏览器中访问前端项目，并逐个测试每个页面的相关功能。
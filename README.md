# spring-boot-annotation
> 演示spring boot的使用，结合supervisor运行
> 该项目使用Gradle进行构建项目，并且简单使用了testNG做单元测试


## 项目说明
在配置freemarker作为模版时，使用xml作为mvc配置文件，目前用testng进行集成测试无法通过

下载项目之后，运行`gradle idea`生成idea项目

###### 目录说明

`src/main/java/` - 类路径，程序的主要代码，将会编译成项目的class

`src/main/resources/` - 类路径，程序中不需要编译成class的资源文件

`src/test/java/` - 测试类，gradle test默认运行单元测试的类路径

`src/test/resources/` - 测试资源，单元测试特有的类路径

`resources/` - 一些不需要运行到类路径中的额外资源

`build.gradle` - Gradle构建的配置文件，指定如何进行项目构建

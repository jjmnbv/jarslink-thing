# 阿里Jarslink的一个小demo

## link-master 主要的
端口：9001

## link-module 一个小module
- 打jar包： gradle clean jar
- version 使用的事时间格式：yyyyMMddHHmmss

## 执行顺序
1. 先打包link-module
2. 在启动link-master
3. 访问： http://localhost:9001/api/link-module/hello


<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>freemarker</title>
    <link th:href="@{/css/index.css}" rel="stylesheet" />
</head>
<body>
<h1>Hello SpringBoot!</h1>
<h2>${msg}</h2>
<center>
    <img th:src="@{/images/jjava.jpg}" alt="加载图片失败" />
</center>
</body>
</html>
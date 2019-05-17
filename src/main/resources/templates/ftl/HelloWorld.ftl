<!DOCTYPE>
<#--<html lang="en">-->
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>freemarker 测试</title>
    <#--<link rel="stylesheet" href="css/index.css" />-->
    <link th:href="@{/css/index.css}" rel="stylesheet" />
</head>
<body>
show: ${message}
</body>
</html>
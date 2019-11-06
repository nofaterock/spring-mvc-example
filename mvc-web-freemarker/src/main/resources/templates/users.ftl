<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
	<h1>Users</h1>
	<hr/>
	<#list users as item>
	<h4>${item.userId}</h4>
	<h5>${item.name}</h5>
	</#list>
</body>
</html>

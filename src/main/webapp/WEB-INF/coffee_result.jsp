<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
			.container {
				max-width: 400px;
				margin: 50px auto;
				padding: 20px;	
				}
			h1 {
				text-align: center;
			   }
			p{
				font-size: 16px;
			}

		</style>
	</head>
	<body>
		<div class="container">
			<h1>咖啡比例結果</h1>
			<legend>您的參數</legend>
			
			<p>牛奶: ${ coffeeMilk.milk}<br/></p>
			<p>咖啡: ${ coffeeMilk.coffee}<br/></p>
			<p>種類: ${ coffeeMilk.coffeeType }<br/></p>

			
			<a href="/JavaWeb/coffee" class="pure-button pure-button-primary">返回</a>
		</div>
	</body>
</html>
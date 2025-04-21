<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
			.form_container {
				max-width: 500px;
				margin: 50px auto;
				padding: 20px;
				}
			h2 {
				text-align: center;
			   }
		</style>
	</head>
	<body>
		<div class="form_container">
			<h2>咖啡比例</h2>
			<form class="pure-form pure-form-stacked" method ="POST" action="/JavaWeb/coffee">
				<legend>您的參數</legend>

				<label>牛奶:</label>
				<input name="milk" type="number" min="10" max="400"  required />	
				<label>咖啡:</label>
				<input name="coffee" type="number" min="10" max="400"  required />
				<p />
				<button type="submit" class="pure-button pure-button-primary">送出</button>
				
			</form>
		</div>
	</body>
</html>
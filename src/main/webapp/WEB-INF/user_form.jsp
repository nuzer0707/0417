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
			<h2>使用者資料表單</h2>
			<form class="pure-form pure-form-stacked" method ="POST" action="/JavaWeb/user">
				<legend>User Form</legend>
				<label>姓名:</label>
				<input id="userName" name="userName" type="text" required />
				<p />
				<label>姓別:</label>				
				<input name="gender" type="radio" value="male" checked>&nbsp;男
				<input name="gender" type="radio" value="female">&nbsp;女
				<p />	
				<label>年齡:</label>
				<input name="age" type="number" min="1" max="150"  required />	
				<p />
				<label>身高:</label>
				<input name="height" type="number" min=".1" max="200" step="0.1" required />	
				<label>體重:</label>
				<input name="weight" type="number" min=".1" max="200" step="0.1" required />
				<p />
				<button type="submit" class="pure-button pure-button-primary">送出</button>
				
			</form>
		</div>
	</body>
</html>
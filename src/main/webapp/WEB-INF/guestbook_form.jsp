<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guestbook</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">	
		<style>
		 body
		 	{
			 padding:20px;
			 }
		.warp_flex
			{
			display: flex;
			flex-direction: column;
			align-content: center;
			align-items: center;
			margin: auto;
			padding: 10px;
			}
		label{
			margin: 10px;
			}
			
		button 
			{
			margin: 10px;
			}	 
		</style>
	</head>
	<body>
		<div class="warp_flex">
			<h2>訪客留言版</h2>
			<form class="prue-form"  method="POST" action="/JavaWeb/guestbook">
				<fieldset class="warp_flex">
					<label>留言:</label>
					<textarea rows="4" cols="40" name="message" required></textarea>
					<button type="submit" class="pure-button pure-button-primary">送出</button>
				</fieldset>
			</form>
		</div>
	</body>
</html>
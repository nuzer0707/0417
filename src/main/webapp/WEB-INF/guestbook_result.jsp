<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guestbook資料結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
		 body{
			 padding:20px;
			 }
		.warp_flex
			{
			display: flex;
			max-width:700px;
			flex-direction: column;
			align-content: center;
			align-items: center;
			margin: auto;
			padding: 20px;
			}
			 
		</style>
	</head>
	<body>
		<div class="warp_flex">
			<h2>訪客留言資料結果</h2>
			<form class="prue-form"  method="POST" action="/JavaWeb/guestbook">
				<fieldset class="warp_flex">
					<legend>Guestbook Result</legend>
					本次留言: ${ message }<br/>
					歷史留言: <br/>${ guestbooks }<br/>
					<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
				</fieldset>
			</form>
		</div>
	</body>
</html>
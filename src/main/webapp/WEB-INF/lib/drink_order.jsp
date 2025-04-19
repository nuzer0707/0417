<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<fieldset>
			<legend>Drink Order</legend>
			飲料: ${ drinkOrder.type}<br/> 
			容量: ${ drinkOrder.size}<br/> 		
			加冰: ${ drinkOrder.ice}<br/> 
			${ drinkOrder.info}<br/> 
		</fieldset>
	</div>
</body>
</html>
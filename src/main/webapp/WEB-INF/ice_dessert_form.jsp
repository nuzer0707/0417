<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>🍧冰果店的點餐系統</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">	
		<style>
		body { padding: 20px; font-family: sans-serif;font-size: 24px; }
        fieldset { margin-bottom: 15px; border: 1px solid #ccc; padding: 15px; }
        legend { font-weight: bold; padding: 0 5px; }
        label { margin-left: 5px;vertical-align: middle;  }
        input[type="radio"], input[type="checkbox"] { margin-bottom: 8px; vertical-align: middle;}
        br { display: block; margin-bottom: 5px; } 
		</style>
	</head>
	<body>
		<div>
			<h2>冰果店的點餐系統</h2>
			<form class="prue-form"  method="POST" action="/JavaWeb/ice">
				<fieldset>
					<label>選擇主餐</label><p />
					<!-- 單選 servlet 後台使用 req.getParamter"mainDish" 會得到String -->
					<input type="radio" name="mainDish" value="剉冰" checked="checked">剉冰 🍧(50元) <p />
					<input type="radio" name="mainDish" value="豆花" checked="checked">豆花 🍮(40元) <p />			
				</fieldset>
				<fieldset>
					<label>選擇加料(每項10元)</label><p />
					<!-- 多選 servlet 後台使用 req.getParamter"toppings" 會得到String[] -->
					<input type="checkbox" name="toppings" value="花生"> 花生 🥜<p />
					<input type="checkbox" name="toppings" value="綠豆"> 綠豆 🌱<p />
					<input type="checkbox" name="toppings" value="紅豆"> 紅豆 🍒<p />
					<input type="checkbox" name="toppings" value="芋圓"> 芋圓 🥔<p />
					<input type="checkbox" name="toppings" value="粉圓"> 粉圓 ⚪<p />
					<input type="checkbox" name="toppings" value="煉乳"> 煉乳 🍼<p />
					
				</fieldset>
				<button type="submit" class="pure-button pure-button-primary">結帳</button>
			</form>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>🍧冰果店的點餐系統-訂單結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
		body { padding: 20px; font-family: sans-serif; font-size: 24px ;}
        fieldset { margin-bottom: 15px; border: 1px solid #ccc; padding: 15px; }
        legend { font-weight: bold; padding: 0 5px; }
        label { margin-left: 5px;vertical-align: middle;  }
        input[type="radio"], input[type="checkbox"] { margin-bottom: 8px; vertical-align: middle;}
        br { display: block; margin-bottom: 5px; }
		</style>
	</head>
	<body>
		<div class="pure-form">
			<h2>🍧冰果店的點餐系統-訂單結果</h2>
			<fieldset>
				<legend>訂單列表</legend>
				<c:set var="totalPriceSum" value="0" />
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>No</th>
							<th>主餐</th>
							<th>配料</th>
							<th>價格</th>
							<th>刪除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="i" var="iceOrder" items="${ iceOrders }">
							<tr>
								<td>${ i.index + 1 }</td>
								<td>${ iceOrder.mainDish.name }</td>
								<td>
								    <c:choose>
								        <c:when test="${not empty iceOrder.topping.toppings}">
								            <%-- **** 修改開始 **** --%>
								            <%-- 使用 c:forEach 迭代 List --%>
								            <c:forEach var="toppingItem" items="${iceOrder.topping.toppings}" varStatus="loop">
								                ${toppingItem}${!loop.last ? ', ' : ''} 
								                <%-- 顯示元素，如果不是最後一個就加上逗號和空格 --%>
								            </c:forEach>
								            <%-- **** 修改結束 **** --%>
								        </c:when>
								        <c:otherwise>
								            無配料
								        </c:otherwise>
								    </c:choose>
								</td>
								<td>
									<%-- 建議加上 currencySymbol 讓顯示更清晰 --%>
									<fmt:formatNumber value="${ iceOrder.totalPrice }" type="currency" currencySymbol="NT$" maxFractionDigits="0" />
								</td>
								<td>
								 	<form action="<c:url value='/ice/orders'/>" method="post" style="display: inline;">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="index" value="${i.index}">
                                        <button type="submit" style="background: none;border: none;cursor: pointer;font-size: 20px;" title="按我一下刪除" onclick="return confirm('確定要刪除「${iceOrder.mainDish.name}」這筆訂單嗎？');">
                                         ❌
                                        </button>
                                    </form>
                                  </td>
							</tr>
							<c:set var="totalPriceSum" value="${ totalPriceSum + iceOrder.totalPrice }" />
						</c:forEach>
					</tbody>
					<tfoot>
						<tr style="background-color: #DDDDDD">
							<td colspan="3" style="text-align: right;">總金額</td>
							<td>
								<fmt:formatNumber value="${ totalPriceSum }" type="currency" currencySymbol="NT$" maxFractionDigits="0" />
							</td>
							<td></td>
						</tr>
					</tfoot>
				</table>

				<a href="<c:url value='/ice/new'/>" class="pure-button pure-button-primary">新增訂單</a>
			</fieldset>
		</div>
	</body>
</html>


<!--	

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>🍧冰果店的點餐系統-訂單結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
		body { padding: 20px; font-family: sans-serif; font-size: 24px ;}
        fieldset { margin-bottom: 15px; border: 1px solid #ccc; padding: 15px; }
        legend { font-weight: bold; padding: 0 5px; }
        label { margin-left: 5px;vertical-align: middle;  }
        input[type="radio"], input[type="checkbox"] { margin-bottom: 8px; vertical-align: middle;}
        br { display: block; margin-bottom: 5px; } 
		</style>
	</head>
	<body>
		<div class="pure-form">
			<h2>🍧冰果店的點餐系統-訂單結果</h2>
			<fieldset>
				<legend>訂單列表</legend>
				<c:set var="totalPriceSum" value="0" />
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>No</th>
							<th>主餐</th>
							<th>配料</th>
							<th>價格</th>
							<th>刪除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="i" var="iceOrder" items="${ iceOrders }">
							<tr>
								<td>${ i.index + 1 }</td>
								<td>${ iceOrder.mainDish.name }</td>
								<td>${ iceOrder.topping.toppings }</td>
								<td>
									<fmt:formatNumber value="${ iceOrder.totalPrice }" type="currency" maxFractionDigits="0" />
								</td>
								<td>                                   
								 	<form action="<c:url value='/ice'/>" method="post" style="display: inline;">
                                        <%-- 隱藏欄位：告訴 Servlet 這是刪除動作 --%>
                                        <input type="hidden" name="action" value="delete">
                                        <%-- 隱藏欄位：傳遞要刪除項目的索引 (從 0 開始) --%>
                                        <input type="hidden" name="index" value="${i.index}">
                                        <%-- 提交按鈕，顯示為叉叉圖示 --%>
                                        <button type="submit" style="background: none;border: none;cursor: pointer; " title="按我一下刪除" onclick="return confirm('確定要刪除「${iceOrder.mainDish.name}」這筆訂單嗎？');">
                                         ❌
                                        </button>
                                    </form>
                                  </td>
							</tr>
							
							<c:set var="totalPriceSum" value="${ totalPriceSum + iceOrder.totalPrice }" />
						</c:forEach>
					</tbody>
					<tfoot>
						<tr style="background-color: #DDDDDD">
							<td colspan="3" style="text-align: right;">總金額</td>
							
							<td>
								<fmt:formatNumber value="${ totalPriceSum }" type="currency" maxFractionDigits="0" />
							</td>
							<td></td>
						</tr>
					</tfoot>
				</table>
				
				<a href="/JavaWeb/ice" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>
-->
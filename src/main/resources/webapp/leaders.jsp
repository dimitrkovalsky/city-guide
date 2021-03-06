<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">
<title>Таблиця лідерів</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
 .selectText {
	 font-size: 16px;
 }
.logoWord {
	font-size: 30px; 
	font-weight: bold; 
	font-family: inherit;
}
.lederTabel thead tr {
	background-color: #aa99FF; 
	color: white; 
	text-shadow: 1px 1px 1px black;
}

.footer {
	background-color: #EEEEEE;
	height: 20px;
}
</style>
</head>
<body>
	<script type="text/javascript">
	
	 <!-- Place this asynchronous JavaScript just before your </body> tag -->
     (function() {
       var po = document.createElement('script'); 
       po.type = 'text/javascript'; 
       po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
	
	function selectTown(){
		var country = $("select#select_country").val();
		var region = $("select#select_region").val();
		var town = $("select#select_town").val()
		alert("country" + country + "region" + region + "town" + town);
	}
	
	function signinCallback(authResult) {
		  if (authResult['access_token']) {
		    $("#acc").val(authResult['access_token']);		    
		    sendAjax(authResult['access_token']);
		    
		    var url = 'https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=' + authResult['access_token']; 
		    getUserInfo(url);
		    
		    alert(json);
		    
		    document.getElementById('signinButton').setAttribute('style', 'display: none');
		  } else if (authResult['error']) {
		    // Update the app to reflect a signed out user
		    // Possible error values:
		    //   "user_signed_out" - User is signed-out
		    //   "access_denied" - User denied access to your app
		    //   "immediate_failed" - Could not automatically log in the user
		    console.log('Sign-in state: ' + authResult['error']);
		  }
		}
	
	function getUserInfo(url){
		  $.ajax({
		        type: 'POST',
		        url: url
		    }).done(function (response) {
		   		alert(response);
		    });
	}
	
	
	function sendAjax(token){
		  $.ajax({
		        type: 'POST',
		        url: '/google-auth',
		        data: { 
		         'token': token
		        }
		    }).done(function (response) {
		      if(response.status == '200')
		      { 
		       //window.location.hash = response.message;
		       //location.reload();
		      }
		    
		      if(response.status == '400')
		      {
		       //$('#error_id').show("slow");
		       //$('#error').text("Error : " + response.message);
		      }
		    });
	}
	
	</script>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar" style="background-color: #363B3F;">
			<div class="container">
				<a class="brand" href="#">
					<span class="logoWord">
						<span style="color: #ffffff">CITY</span><span style="color: #95C11F">GUIDE</span></span></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Таблиця лідерів</a></li>
						<li><a href="#about">Активність гравців</a></li>
						<li><a href="#contact">Рейтинг видатних місць</a></li>
						<li><a href="#contact">Мої налаштування</a></li>
						<li><a href="#contact">Правила гри</a></li>
					</ul>
					
					<div class="pull-right">
						<span id="signinButton">
					  		<span
							    class="g-signin"
							    data-callback="signinCallback"
							    data-clientid="977494659512.apps.googleusercontent.com"
							    data-cookiepolicy="single_host_origin"
							    data-requestvisibleactions="http://schemas.google.com/AddActivity"
							    data-scope="https://www.googleapis.com/auth/userinfo.profile">
					  		</span>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 100px;">
		
		<input type="text" id="acc" />
		<a style="cursor: pointer;" class="btn" onclick="tt();"></a>
		<h1>Таблиця лідерів</h1>
		
		<span class="selectText">Країна:</span>
		<select id="select_country">
			<option value="0" disabled="disabled" selected="selected">Не обрано</option>
			<option value="1">Україна</option>
		</select>
		<span class="selectText">Область:</span>
		<select id="select_region">
			<option value="0" disabled="disabled" selected="selected">Не обрано</option>
			<option value="1">Вінницька обл.</option>
		</select>
		<span class="selectText">Місто:</span>
		<select id="select_town" onchange="selectTown();">
			<option value="0" disabled="disabled" selected="selected">Не обрано</option>
			<option value="1">Вінниця</option>
		</select>
		
		
		<table class="table table-bordered lederTabel">
			<thead>
				<tr >
					<th>Місце</th>
					<th>ФІО</th>
					<th>Кількість Балів</th>
					<th>Час</th>
					<th style="text-align: center;">Профіль</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Вася</td>
					<td>2600</td>
					<td>18 год 15 хв</td>
					<td style="text-align: center;"><a href="#profil" class="btn btn-success">Переглянути</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Вася2</td>
					<td>2600</td>
					<td>18 год 152 хв</td>
					<td style="text-align: center;"><a href="#profil" class="btn btn-success">Переглянути</a></td>
				</tr>
				<tr>
					<td>3</td>
					<td>Вася2</td>
					<td>2600</td>
					<td>18 год 152 хв</td>
					<td style="text-align: center;"><a href="#profil" class="btn btn-success">Переглянути</a></td>
				</tr>
			</tbody>
		</table>

	</div>
	<!-- /container -->
	
	<div class="navbar-fixed-bottom row-fluid footer">
      <div class="navbar">
          <div class="container">
          Какойто текст
          </div>
      </div>
    </div>

</body>
</html>
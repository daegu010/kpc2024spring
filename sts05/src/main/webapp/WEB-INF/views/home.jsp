<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
</head>
<body>
<div id="menu">
	<a href="#p1">home</a>
	<a href="#p2">dept</a>
	<a href="#p3"></a>
	<a href="#p4"></a>
</div>
<div id="p1">
	<h2>index page</h2>
</div>
<div id="p2">
	<h2>list page</h2>
	<button>입력</button>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>지역</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
<div id="p3"></div>
<div id="p4">
	<h2>입력 페이지</h2>
	<div>dname<input/></div>
	<div>loc<input/></div>
	<button>입력</button>
</div>
<script type="text/javascript">
$('#p2,#p3,#p4').hide();

$('#p2>button').click(e=>{
	$('#p4').find('input').eq(0).val("");
	$('#p4').find('input').eq(1).val("");
	$('#p4').show();
});
$('#p4>button').click(e=>{
	var dname=$(e.target).parent().find('input').eq(0).val();
	var loc=$(e.target).parent().find('input').eq(1).val();
	$.post('dept/',{dname,loc},e=>$('#menu>a').eq(1).click());
});

$('#menu>a').eq(0).click(e=>{
	$('#p2,#p3,#p4').hide();
	$('#p1').show();
});
$('#menu>a').eq(1).click(e=>{
	$('#p1,#p3,#p4').hide();
	$('#p2').show();
	$.get('dept/',data=>{
		$('table>tbody').empty();
		$(data).each((idx,ele)=>{
			var tr=$('<tr/>');
			$("<td>"+ele.deptno+"</td>").appendTo(tr);
			$("<td>"+ele.dname+"</td>").appendTo(tr);
			$("<td>"+ele.loc+"</td>").appendTo(tr);
			$('table>tbody').append(tr);
		});
		
	});
});
</script>
</body>
</html>















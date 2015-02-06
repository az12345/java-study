<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<head>
	<meta charset="utf8" />
	<meta name="description" content="My first demo jee application" />
	<meta name="keywords" content="jee, java, web, demo, webtasks" />
	<meta name="author" content="nedis" />
	<meta name="copyright" content="Copyright 2013, Webtasks demo application" />
	<title>Demo web application</title>
	
	<link rel="stylesheet" type="text/css" media="all" href="${CONTEXT }/resources/css/webtasks.css" />
	<script type="text/javascript" src="${CONTEXT }/resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${CONTEXT }/resources/js/webtasks.js"></script>
</head>
<body class="default-style">
	<header>
	<br/>My demo application
	</header>
	<section class="main">
		<jsp:include page="${currentPage }" flush="true" />
	</section>
	<footer>
		<br/>Copyright 2015, Webtasks demo application
	</footer>
</body>
</html>
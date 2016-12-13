<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
	    <meta http-equiv="content-type" content="text/html;" charset="UTF-8"/>
	    <title><tiles:insertAttribute name="title"/></title>
	    <meta name="description" content="Way2learn is a  training provider for  technologies such as Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE" />
	    <meta name="keywords" content="Hadoop,Spring, Hibernate, Soap Webservices,Restful Webservices,Mule,Apache Spark,Core Java, JEE, Training in Bangalore" />
	    <meta name="robots" CONTENT="index, follow"/>
		<meta name="revisit-after" CONTENT="1 days"/>
		<meta name="Distribution" content="Global"/>
		<link rel="shortcut icon" type="image/x-icon" href="${initParam.resourcePath}/images/favicon.ico" />
	    <link rel="stylesheet" type="text/css" href="${initParam.resourcePath}/css/common.css">
	    <link rel="stylesheet" type="text/css" href="${initParam.resourcePath}/css/layout.css">
	    <link rel="stylesheet" href="${initParam.resourcePath}/css/fancybox.css" />


	    <link rel="stylesheet" type="text/css" href="${initParam.resourcePath}/css/login.css"/>
	    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	    <!--[if lt IE 9]>
	      <script src="js/html5shiv.js"></script>
	    <![endif]-->

	</head>

		<script type="text/javascript" src="${initParam.resourcePath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${initParam.resourcePath}/js/jquery.sticky.js"></script>
		<script type="text/javascript" src="${initParam.resourcePath}/js/jquery.fancybox.js"></script>
		<script type="text/javascript" src="${initParam.resourcePath}/js/jquery.slider.js"></script>
		<script type="text/javascript" src="${initParam.resourcePath}/js/jquery-dropdown.js"></script>

<div id="main-content">
	<!-- #featured -->
	<article>
		<tiles:insertAttribute name="bannerBox" />
		<div class="app-center">
			<tiles:insertAttribute name="homePageMainBody" />
			<div class="clearfix"></div>
			<%-- <tiles:insertAttribute name="clients" /> --%>
			<tiles:insertAttribute name="aboveFooter" />
		</div>
	</article>
	<!-- #mid-content -->
</div>
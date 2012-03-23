<!DOCTYPE html>
<html>
<head>
  <style>img{ height: 100px; float: left; }</style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
  <div id="images">

</div>
<script>
$.getJSON("https://graph.facebook.com/me?",
  {
	access_token: "2227470867|2.AQBgrLp2GVRq5-yS.3600.1309708800.0-524829377|JkFAbg5fGZk4AuUyOE9OGHR0w6U",
	fields: "relationship_status"
  },
  function(data) {
    $.each(json.data, function(i,fb){
     alert(fb.id);
    });
  });</script>

</body>
</html>
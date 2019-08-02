
//var serverContext = [[@{/}]];
$(document).on('ready',function(){
	 var subId= $("#subId").text();
	const Url= "/submission/" + subId;
	
	
		
		/*$('.orderStatus').click(function(){
			window.location.href=Url2;
		
});*/
	
		
	$('.submitBtn').click(function(){
					window.location.href=Url;
				
	});
			
	

	$('tr[id=statusTable] td:contains("NONE,")').addClass("statusNone");
	$('tr[id=statusTable] td:contains("registered")').addClass("statusRegistered");
	$('tr[id=statusTable] td:contains("completed")').addClass("statusCompleted");
	
	
	$('[class=statusNone]').append($('<span class="spanClass"> &nbsp; Registration NOT Complete</span>'));
	$('[class=statusCompleted]').append($('<span> &nbsp; <a class="orderStatus" href="#"><img src="../images/download.jpeg" alt="Download"></a></span>'));
	
	  $('.next').click(function () {
		  $('tr[id=statusTable] td:contains("NONE,")').addClass("statusNone");
			$('tr[id=statusTable] td:contains("registered")').addClass("statusRegistered");
			$('tr[id=statusTable] td:contains("completed")').addClass("statusCompleted");
			
			
			$('[class=statusNone]').append($('<span class="spanClass"> &nbsp; Registration NOT Complete</span>'));
		   });
	  
	  var orderId= $(".statusCompleted").parent().find('td:eq(2)').text();
	  const Url2= "/getData/" + orderId;
	  
	  $('.orderStatus').click(function(){
			window.location.href=Url2;
		
});
	
})
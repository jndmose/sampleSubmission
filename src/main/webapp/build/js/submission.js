
//var serverContext = [[@{/}]];
$(document).ready(function(){
	//$(".statusDisplay").hide();
	 var subId= $("#subId").text();
	const Url= "/submission/" + subId;
	
		
	$('.submitBtn').click(function(){
		
		$.ajax({
		
			url: Url,
			type: "GET",
			success: function(data){
				console.log( data.result.submissionId);
				document.getElementById("demo").innerHTML = data.result.submissionId;
			},
			error: function(error){
				
				console.log(`Error ${error}`)
			}
		})	
		
	})

	$('tr[id=statusTable] td:contains("NONE,")').addClass("statusNone");
	$('tr[id=statusTable] td:contains("registered")').addClass("statusRegistered");
	
	
	$('[class=statusNone]').append($('<span class="spanClass"> &nbsp; Registration NOT Complete</span>'));
	
})
window.onload = function(){
	getSessionErsUsers();
	//getSEssionErsReimb();
	
}
 
 function getSessionErsUsers(){
	
	console.log("here before XMLHttpRequest");
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			let user = JSON.parse(xhttp.responseText);
			console.log(user);
			document.getElementById("WelcomeMessage").innerText=`Welcome ${user.user_first_name}, you are logged in`;
			
		};
	}
	
	xhttp.open("GET", "http://localhost:8080/Project1FrontEnd/getsessionusers.json");
	
	xhttp.send();
	
}



$(document).ready(function(){
 

	$(document).on('click','.approveOrDenyBtnClass',function(){

  		//var dataToSend = this.id+" "+ this.name;

 		$.ajax({
			  type: "POST",
			  url: 'http://localhost:8080/Project1FrontEnd/approveErsReimb.json',
			  data: {
      				'id' : this.id,
					'name' : this.name
              },
			  dataType: "json",
			  success : function(data2) {
				console.log(data2)
				
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				}
 		 });
				

	});
	
	
	//http://localhost:8080/Project1FrontEnd/approve.change
		
		
		
	$('#load_data').click(function() {
		    $.ajax({
		        type: 'GET',
		        url: 'http://localhost:8080/Project1FrontEnd/getSessionErsReimb.json',
		        data: $('#details').serialize(),
		        dataType:"json", //to parse string into JSON object,
		        success: function(data){ 
		            if(data){
						console.log(data)
		                var len = data.length;
		                var txt = "";
		                if(len > 0){
		                    for(var i=0;i<len;i++){
		             
		                            txt += "<tr><td>"+data[i].reimb_id+"</td><td>"+data[i].reimb_amount+"</td><td>"+data[i].reimb_submitted
	+"</td><td>"+data[i].reimb_resolved+"</td><td>"+data[i].reimb_description+
	"</td><td><input  id='approve' class='approveOrDenyBtnClass' type='button' value='Approve' name='"+data[i].reimb_id+"' /></td><td><input id='deny' class='approveOrDenyBtnClass' type='button' value='Deny' name='"
	+data[i].reimb_id+"' /></td></tr>";
		                        
		                    }
		                    if(txt != ""){
		                        $("#table").append(txt).removeClass("hidden");
		                    }
		                }
		            }
		        },
		        error: function(jqXHR, textStatus, errorThrown){
		            alert('error: ' + textStatus + ': ' + errorThrown);
		        }
		    });
	
		    return false;//suppress natural form submission
		});
		
		
		

	

});
	








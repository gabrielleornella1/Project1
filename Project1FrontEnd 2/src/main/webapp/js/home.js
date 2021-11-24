/**
 * 
 */
 
 window.onload = function(){
	getSessionErsUsers();
	getSEssionErsReimb();
	
}
 
 function getSessionErsUsers(){
	console.log("here before XMLHttpRequest");
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			let user = JSON.parse(xhttp.responseText);
			console.log(user);
			document.getElementById("welcomeHeading").innerText=`Welcome ${user.user_first_name}, you are logged in`;
			
		};
	}
	
	xhttp.open("GET", "http://localhost:8080/Project1FrontEnd/getsessionusers.json");
	
	xhttp.send();
	
}

function getSEssionErsReimb(){
	
	console.log("here before XMLHttpRequest");
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			let reimb = JSON.parse(xhttp.responseText);
			console.log(reimb);
			
			for (data of reimb){
				//console.log(data.data.reimb_amount)
				//console.log(data.data.data.reimb_author)
				//Console.log(data.data.reimb_amount)
				//Console.log(data.data.reimb_amount)
				//Console.log(data.data.reimb_amount)
				//Console.log(data.data.reimb_amount)
				//Console.log(data.data.reimb_amount)
				document.getElementById("remblist").innerHTML = data.reimb_amount
				document.getElementById("remblist1").innerHTML = data.reimb_author
				document.getElementById("remblist2").innerHTML = data.reimb_description
				document.getElementById("remblist3").innerHTML = data.reimb_id
				document.getElementById("remblist4").innerHTML = new Date (data.reimb_resolved)
				document.getElementById("remblist5").innerHTML = data.reimb_resolver
				document.getElementById("remblist6").innerHTML = new Date (data.reimb_submitted)
				document.getElementById("remblist7").innerHTML = data.reimb_type_id
				let form = document.createElement("form")
				form.setAttribute("method", "POST")
				form.setAttribute("action", "/Project1FrontEnd/approve.change")
				let approveButton = document.createElement("button")
				
				approveButton.setAttribute("value", data.reimb_id)
				form.appendChild(approveButton)
				document.getElementById("rembblock").appendChild(form)
			}
			
		};
	}
	
	xhttp.open("GET", "http://localhost:8080/Project1FrontEnd/getSessionErsReimb.json");
	
	xhttp.send();
	
}




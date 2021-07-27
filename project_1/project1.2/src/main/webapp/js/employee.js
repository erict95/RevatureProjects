console.log("In employee site");

window.onload = function(){
	ajaxGetAllQueries();
}

function ajaxGetAllQueries(){
	console.log("Getting all reimbursements");
	
	fetch('http://localhost:8762/project_1/json/userQueries')
		.then(function(Response){
		console.log("Im here");
				const convertedResponse=Response.json();
				return convertedResponse;
				})
		.then(function(dataResponse){
				console.log("heloo");
				console.log(dataResponse);
				letsDOMmanimpulate(dataResponse);
			})
}

function letsDOMmanimpulate(ourJSON){
	for(let x = 0; x < ourJSON.length; x++){
		let newTR = document.createElement("tr");
		let newTH = document.createElement("th");
		
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		let newTD6 = document.createElement("td");
		
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[x].type);
		let myTextD1 = document.createTextNode(ourJSON[x].description);
		let myTextD2 = document.createTextNode(ourJSON[x].amount);
		let myTextD3 = document.createTextNode(ourJSON[x].status);
		let myTextD4 = document.createTextNode(ourJSON[x].submit);
		let myTextD5 = document.createTextNode(ourJSON[x].resolve);
		
		
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextD1);
		newTD2.appendChild(myTextD2);
		newTD3.appendChild(myTextD3);
		newTD4.appendChild(myTextD4);
		newTD5.appendChild(myTextD5);
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		
		let newSelection = document.querySelector("#user_table");
		newSelection.appendChild(newTR);
	}
}
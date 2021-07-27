console.log("in js file");

window.onload = function(){
	ajaxGetAllQueries();
}

function ajaxGetAllQueries(){
	console.log("Getting all reimbursements");
	
	fetch('http://localhost:8762/project_1/json/allQueries')
		.then(function(Response){
				const convertedResponse=Response.json();
				return convertedResponse;
				})
		.then(function(dataResponse){
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
		let newTD7 = document.createElement("td");
		let newTD8 = document.createElement("td");
		
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[x].id);
		let myTextD1 = document.createTextNode(ourJSON[x].first);
		let myTextD2 = document.createTextNode(ourJSON[x].last);
		let myTextD3 = document.createTextNode(ourJSON[x].email);
		let myTextD4 = document.createTextNode(ourJSON[x].type);
		let myTextD5 = document.createTextNode(ourJSON[x].description);
		let myTextD6 = document.createTextNode(ourJSON[x].amount);
		let myTextD7 = document.createTextNode(ourJSON[x].status);
		let myTextD8 = document.createTextNode(ourJSON[x].submit);
		
		
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextD1);
		newTD2.appendChild(myTextD2);
		newTD3.appendChild(myTextD3);
		newTD4.appendChild(myTextD4);
		newTD5.appendChild(myTextD5);
		newTD6.appendChild(myTextD6);
		newTD7.appendChild(myTextD7);
		newTD8.appendChild(myTextD8);
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(newTD6);
		newTR.appendChild(newTD7);
		newTR.appendChild(newTD8);
		
		let newSelection = document.querySelector("#reimbursement_table");
		console.log(newSelection);
		newSelection.appendChild(newTR);
	}
}







$(document).ready(function() {
	
	$('#state-select').change(function() {
		var state = $(this).val();
		console.log(state);
		ajaxDropdown(state);
	})
	
	$('#modal-update').dialog({
		autoOpen: false,
		show: {
			effect: "fade",
			duration: 200
		},
		hide: {
			effect: "fade",
			duration:200
		}
	})

});

function deletePerson(personId) {
	console.log(personId);
	$.post('/WebProject/HomeServlet',{
		btn : 'delete',
		id : personId
	}, function(response){
		location.reload();
	});
}

function updatePerson(personId){
	console.log("update Person clicked");
	console.log(personId);
	$('#id-input').val(personId);
	$.get('/WebProject/HomeServlet', {
		personId : personId,
		btn : 'btn'
	}, function(response) {
		console.log(response)
		$('#name').val(response.name);
		$('#lastname').val(response.lastName);
		$('#email').val(response.email);
		$('#age').val(response.age);
		$('#address').val(response.address)
	});
	$('#modal-update').dialog("open");
}

function update(){
	var personID = $('#id-input').val();
	var name = $('#name').val();
	var lastName = $('#lastName').val();
	var email = $('#email').val();
	var age = $('#age').val();
	var state = $('#state').val();
	var city = $('#city').val();
	var password = $('#password').val();
	$.post('/WebProject/HomeServlet',{
		btn : 'update',
		id : personId,
		name : name,
		lastname : lastname,
		email : email,
		age : age,
		state : state,
		city : city,
		password : password
	}, function(response){
		location.reload();
	})
	
}

function ajaxDropdown(stateId) {
	$.get('/WebProject/GetCitiesServlet', {
		stateId : stateId
	}, function(response) {
		document.getElementById("city-select").options.length = 0;
		$.each(response, function(key, value) {
			$('#city-select').append($("<option />", {
				value : value.name,
				text : value.name
			}));
		});
	});
}
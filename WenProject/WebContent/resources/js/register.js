$(document).ready(function() {

	$('#state-select').change(function() {
		var state = $(this).val();
		console.log(state);
		ajaxDropdown(state);
	})

});

function ajaxDropdown(stateId) {
	$.get('/WebProject/GetCitiesServlet', {
		stateId : stateId
	}, function(response) {
		document.getElementById("city-select").options.length = 0;
		$.each(response, function(key, value) {
			$('#city-select').append($("<option />", {
				value : key,
				text : value.name
			}));
		});
	});
}
//On Page load-registerlistenersandloadexistingvideosin datatable
$(document).ready(function() {
    var userId; 
	loadDataTable();
	//processtheform newAthlete
	$("#newAthlete").submit(function(event) {
		postAthlete(event);
	});
	//Load Datatable
	$('#loadtable').click(function() {
		loadDataTable();
	}); 
	
	$('#editAthlete').click(function() {
		editData(event);
	});
	
	$('#removeAthlete').click(function() {
		removeData(event);
	});
	
});

function postAthlete(event) {
	// gettheform 
	var formData= {
		'name'	: $('input[name=name]').val(),
		'height': $('input[name=height]').val(),
		'gender': $('input[name=gender]').val()
		};
		// process the form
		$.ajax({
			type			: 'POST',
			contentType		: 'application/json',
			url				: '/athlete', //urlwherewewanttoPOST
			data			: JSON.stringify(formData), // datawewanttoPOST
			success: function( data, textStatus, jQxhr){
				location.reload();
				loadDataTable();
				
			},
			error: function( jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
	
			}
		});
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
}

function loadDataTable() {
var table= $('#athletetable').DataTable({
destroy: true,
"ajax": {
	"url": "/athlete", //URL
	"dataSrc": ""// Cause of flat JsonObjects
	},
	"columns": [
			{ "data": "id"},
			{ "data": "name"},
			{ "data": "height"},
			{ "data": "gender"}
		]
	});
	 $('#athletetable tbody').on('click', 'tr', function () {
		console.log(table.row(this).data())
			var data = table.row( this ).data();
        	dataToInput(data);
        	userId = data.id;
    } );
}

function dataToInput(data){
	$('input[name=name]').val(data.name);
	$('input[name=height]').val(data.height);
	$('input[name=gender]').val(data.gender);
}

function clearInput(){
	$('input[name=name]').val('');
	$('input[name=height]').val('');
	$('input[name=gender]').val('');
}

function editData(event){

	var formData= {
		'id': userId,
		'name'	: $('input[name=name]').val(),
		'height': $('input[name=height]').val(),
		'gender': $('input[name=gender]').val()
		};
		// process the form
		console.log(userId);
		$.ajax({
			type			: 'PUT',
			contentType		: 'application/json',
			url				: '/athlete/'+ userId, //urlwherewewanttoPOST
			data			: JSON.stringify(formData), // datawewanttoPOST
			success: function( data, textStatus, jQxhr){
			loadDataTable();
			},
			error: function( jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
			}
		});
		// stop the form from submitting the normal way and refreshing the page
		clearInput();
		event.preventDefault();
}

function removeData(event){
	var formData= {
		'id': userId,
		'name'	: $('input[name=name]').val(),
		'height': $('input[name=height]').val(),
		'gender': $('input[name=gender]').val()
		};
	$.ajax({
			type			: 'DELETE',
			contentType		: 'application/json',
			url				: '/athlete/'+ userId, //urlwherewewanttoPOST
			data			: JSON.stringify(formData), // datawewanttoPOST
			success: function( data, textStatus, jQxhr){
			loadDataTable();
			},
			error: function( jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
			}
		});
		// stop the form from submitting the normal way and refreshing the page
		clearInput();
		event.preventDefault();
}
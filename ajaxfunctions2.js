//On Page load-registerlistenersandloadexistingvideosin datatable
$(document).ready(function() {
    var userId; 
	loadDataTable();
	//processtheform newTraining
	$("#newTraining").submit(function(event) {
		postTraining(event);
	});
	//Load Datatable
	$('#loadtable').click(function() {
		loadDataTable();
	}); 
	
	$('#editTraining').click(function() {
		editData(event);
	});
	
	$('#removeTraining').click(function() {
		removeData(event);
	});
	
});

function postTraining(event) {
	// gettheform 
	var formData= {
		'description'	: $('input[name=description]').val(),
		};
		// process the form
		$.ajax({
			type			: 'POST',
			contentType		: 'application/json',
			url				: '/training', //urlwherewewanttoPOST
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
var table= $('#trainingtable').DataTable({
destroy: true,
"ajax": {
	"url": "/training", //URL
	"dataSrc": ""// Cause of flat JsonObjects
	},
	"columns": [
			{ "data": "tnr"},
			{ "data": "description"},
		]
	});
	 $('#trainingtable tbody').on('click', 'tr', function () {
		console.log(table.row(this).data())
			var data = table.row( this ).data();
        	dataToInput(data);
        	userId = data.tnr;
    } );
}

function dataToInput(data){
	$('input[name=description]').val(data.description);
}

function clearInput(){
	$('input[name=description]').val('');
}

function editData(event){

	var formData= {
		'tnr': userId,
		'description'	: $('input[name=description]').val(),
		};
		// process the form
		console.log(userId);
		$.ajax({
			type			: 'PUT',
			contentType		: 'application/json',
			url				: '/training/'+ userId, //urlwherewewanttoPOST
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
		'tnr': userId,
		'description'	: $('input[name=description]').val(),
		};
	$.ajax({
			type			: 'DELETE',
			contentType		: 'application/json',
			url				: '/training/'+ userId, //urlwherewewanttoPOST
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
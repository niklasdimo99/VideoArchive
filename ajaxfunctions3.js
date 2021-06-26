//On Page load-registerlistenersandloadexistingvideosin datatable
$(document).ready(function() {
	var userId;
	var selectedUser;
	var trainingId;
	var selectedTraining;
	loadSportDataTable();
	loadTrainingDataTable();
	
});



function zuweisen() {
	// gettheform 
	var formData= {
		//input von allen Tabelleninhalten vlt machen
		'date': $('input[name=date]').val(),
		'startTime': $('input[name=startTime]').val(),
		'endTime': $('input[name=endTime]').val(),
		'weight': $('input[name=weight]').val(),
		'athlete': userId,
		'training': trainingId
		};
		
		
		// processtheform
		//console.log(formData);
		
		$.ajax({
			type: 'POST', // definethetype ofHTTP verbwewantto use(POST forourform)
			contentType: 'application/json;charset=UTF-8',
			url: '/zuweisung', //urlwherewewanttoPOST
			data: JSON.stringify(formData), // datawewanttoPOST
			success: function( data, textStatus, jQxhr){
			console.log(data);
			location.reload();

			//loadDataTable();
			},
			error: function( jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
			}
		});
		// stoptheform fromsubmittingthenormal wayandrefreshingthepage
		//event.preventDefault();
}

function loadZuweisungDataTable() {
var table= $('#zuweisungtable').DataTable({
destroy: true,
"ajax": {
	"url": "/zuweisung",//URL"
	"dataSrc": ""// Causeofflat JsonObjects
	},
	"columns": [
			{ "data": "znr"},
			{ "data": "date"},
			{ "data": "startTime"},
			{ "data": "endTime"},
			{ "data": "weight"}
			
		]
	});
	$('#zuweisungtable tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        selectedId=data.id;
        getZuweisungFromTable(data);//function aufrufen
        System.out.Println()
    } );
}

function getZuweisungFromTable(data){
	$('input[name=datum]').val(data.datum)
	$('input[name=startzeit]').val(data.startzeit)
	$('input[name=endzeit]').val(data.endzeit)
	$('input[name=gewicht]').val(data.gewicht)
}

function clearTable(){
	$('input[name=datum]').val('')
	$('input[name=startzeit]').val('')
	$('input[name=endzeit]').val('')
	$('input[name=gewicht]').val('')
}

function loadSportDataTable() {
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
        	//dataToInput(data);
        	userId = data.id;
        	selectedUser = data;
    } );
}

function loadTrainingDataTable() {
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
        	//dataToInput(data);
        	trainingId = data.tnr;
        	selectedTraining = data;
    } );
}

	
/*
function ZuweisungAufheben(event) {
	
	$.ajax({
			type: 'DELETE', // definethetype ofHTTP verbwewantto use(DELETE forourform)
			contentType: 'application/json;charset=UTF-8',
			url: '/zuweisung/'+selectedId, //urlwherewewanttoDELETE
			success: function( data, textStatus, jQxhr){
			console.log(data);
			loadDataTable();
			},
			error: function( jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
			}
		});
		// stoptheform fromsubmittingthenormal wayandrefreshingthepage
		clearTable();
		event.preventDefault(); 
		
}

*/
$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
			"sAjaxSource": "/showReport",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "workedHours" },
				  { "mData": "workedHours" }
			]
	 })
});
/**
 * 
 */
$(document).ready(function() {
	$('#loginform').validate({ // initialize the plugin
		rules : {
			username : {
				required : true
			}
		},
		messages : {
			username : {
				required : "Please Enter Your Username"
			}
		}
	});
});
$(document).ready(function() {
	$('#commentsForm').validate({ // initialize the plugin
		rules : {
			Comments : {
				required : true
			}
		},
		messages : {
			Comments : {
				required : "Please leave your comments"
			}
		}
	});
});
$(document).ready(function() {
	$('#createUserform').validate({ // initialize the plugin
		rules : {
			username : {
				required : true,
				minlength : 4,
				maxlength : 16
			},
			password : {
				required : true,
				minlength : 6,
				maxlength : 20
			},
			passwordConfirm : {
				required:true,
				equalTo : "#password"
			},
			"privilege.privilegeId":{
				valueNotEquals: "0"

			}
		},
		messages : {
			username : {
				required : "Please Enter Username",
				minlength : "Required 4 characters minimum",
				maxlength : "Maximum characters length is 16"

			},
			password : {
				required : "Password should not be empty",
				minlength : "Required 6 characters minimum",
				maxlength : "Maximum characters length is 20"

			},
			passwordConfirm : {
				required: "Please confirm your password",
				equalTo : "Password and confirm password don't match"
			},
			"privilege.privilegeId":{
				valueNotEquals:"Please choose user privilege"
			}
		}
	});
	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg !== value;
		 }, "Value must not equal arg.");

	
});
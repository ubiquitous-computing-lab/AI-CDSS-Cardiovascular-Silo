app.service('patientService', function($http, $q, APP_CONFIG) {
	
	var apiBaseURL = APP_CONFIG.apiBaseURL;
	var reasonerBaseURL = APP_CONFIG.reasonerBaseURL;

	this.getPatients = function(MRN){

		var deferred = $q.defer();
		if(MRN != undefined){
			var url    = apiBaseURL + "/getPatientList/"+MRN+"/";
		} else {
			var url    = apiBaseURL + "/getPatientList";
		}

		$http({
			url     : url,
			headers : { "Content-Type" : "application/json"},
			method  : "GET"
		})
		.then(function(res){
			deferred.resolve(res.data);
			return deferred.promise;	
		}, function(err){
			deferred.reject(err);
		});
		return deferred.promise;
	};

	this.getPatientDetail = function(patientId){

		var deferred = $q.defer();
		var url    = apiBaseURL + "/getPatient/"+patientId;
		console.log('URL: '+url);
		$http({
			url : url,
			method : "GET"
		})
		.then(function(res){
			deferred.resolve(res.data);
			return deferred.promise;	
		}, function(err){
			deferred.reject(err);
		});
		return deferred.promise;
	};

	this.deletePatient = function(patientId){
		var deferred = $q.defer();
		var url      = apiBaseURL + "/deletePatient/"+patientId;
		$http({
			url : url,
			headers : { "Content-Type" : "application/json"},
			method : "GET"
		})
		.then(function(res){
			console.log('res');
			console.log(res);
			deferred.resolve(res.data);
			return deferred.promise;	
		}, function(err){
			deferred.reject(err);
		});
		return deferred.promise;				
	};

	this.getRecommendation = function(patient){
		var deferred = $q.defer();
		//var url      =  reasonerBaseURL + "/smartcdss/reasoner/cardiovascular/getrecom";
		var url      =  reasonerBaseURL + "/smartcdss/cardio/jreasoner/rules/fetch";
		$http({
			url : url,
			headers : { "Content-Type" : "application/json"},
			data    : patient,
			method  : "POST"
		})
		.then(function(res){
			deferred.resolve(res.data);
			return deferred.promise;	
		}, function(err){
			deferred.reject(err);
		});
		return deferred.promise;
	};

	this.savePatientRecord = function(patientId, patient){
		var deferred = $q.defer();
		if(patientId == undefined){
			var url = apiBaseURL + "/AddPatient";
		} else {
			patient.patientID = patientId;
			var url = apiBaseURL + "/UpdatePatient";
		}
		console.log('patient');
		console.log(patient);
		$http({
			url : url,
			headers : { "Content-Type" : "application/json"},
			data    : patient,
			method  : "POST"
		})
		.then(function(res){
			deferred.resolve(res.data);
			return deferred.promise;	
		}, function(err){
			deferred.reject(err);
		});
		return deferred.promise;
	}

	this.login = function(user){
		var deferred = $q.defer();
		if(btoa(user.name) == 'YWRtaW4=' && btoa(user.password) == 'YWRtaW5AMTIz'){
			deferred.resolve({'code' : 200, 'message' : 'logedin successfully'});
		} else {
			deferred.resolve({'code' : 300, 'message' : 'User name or password are incorrect'});
		}
		return deferred.promise;


		/*$http({
			url : url,
			headers : { "Content-Type" : "application/json"},
			data    : patient,
			method  : "POST"
		})
		.then(function(res){
			deferred.resolve(res.data);
			return deferred.promise;	
		}, function(err){
			deferred.reject(err);
		});
		return deferred.promise;*/
	}

});

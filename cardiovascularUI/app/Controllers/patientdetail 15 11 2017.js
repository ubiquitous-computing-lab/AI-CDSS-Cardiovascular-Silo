app.controller("patientDetailCtrl", function ($scope, $timeout, $mdSidenav, $log, $mdDialog, $routeParams, $rootScope, $location, patientService) {

  $rootScope.fuTreeName = 'FU_DT_1';
  $scope.switchDefaultValue = 0;
  $scope.patientCondition = [];

  $scope.patient = {'age' : '', 'bng': '', 'clinicalHistory' : 0, 'dateOfBirth' : '', 'eSeptal' : '', 'ecg' : '0', 'ee' : '',
    'encounterDate' : '', 'gender' : '', 'lavi' : '', 'longitudinalStrain' : '', 'lvef' : '', 'lvmi' : '', 'ntproBNP' : '',
    'patientClinicalHistoryList' : [ {'cad': $scope.switchDefaultValue, 'arterialHypertension': $scope.switchDefaultValue, 'expositionToCardiotoxic': $scope.switchDefaultValue, 'useOfDiuretics': $scope.switchDefaultValue, 'orthopnoeaParoxysmal': $scope.switchDefaultValue}],
    'patientMRNNo' : '', 'patientName' : '', 
    'patientPhysicalExamList' : [ {'rales': $scope.switchDefaultValue, 'laterallyDisplacedApical': $scope.switchDefaultValue, 'jugularVenousDilatation': $scope.switchDefaultValue, 'heartMurmur': $scope.switchDefaultValue, 'bilateralAnkleEdema': $scope.switchDefaultValue, 'elevatedJVP': $scope.switchDefaultValue, 's3' : $scope.switchDefaultValue, 'nocternalCough' : $scope.switchDefaultValue, 'impulse': $scope.switchDefaultValue}],
    'patientSymptomsList' : [ {'ankleSwelling': $scope.switchDefaultValue, 'breathlessness': $scope.switchDefaultValue, 'fatigue': $scope.switchDefaultValue, 'orthopnoea' : $scope.switchDefaultValue, 'pnd' : $scope.switchDefaultValue, 'reducedExerciseTolerance' : $scope.switchDefaultValue, 'tiredness': $scope.switchDefaultValue}],
    'physicalExam' : 0, 'symptomsAndSigns' : 0, 'trv' : '' 

  };
  


  $scope.getPatientDetail = function(patientId){
    
    $rootScope.isPageLoading = true;
    patientService.getPatientDetail(patientId).then(function(res){
      $scope.patient = res;
      console.log(' in response of getPatientDetail');
      console.log(res)

      $scope.alignCalculatedValues();
      
      $rootScope.hideLoader();
    },function(err){
      $rootScope.isPageLoading = false;
      console.log(JSON.stringify(err));
    });  
  };

  $scope.alignCalculatedValues = function(){

    if($scope.patient.symptomsAndSigns == 1){
      $scope.setInnerValue('patientSymptomsList', 'breathlessness', ['encounterDate', 'patientSymptomID']);
    }
    if($scope.patient.physicalExam == 1){
      $scope.setInnerValue('patientPhysicalExamList', 'rales', ['encounterDate', 'patientPhysicalExamID']);
    }
    if($scope.patient.clinicalHistory == 1){
      $scope.setInnerValue('patientClinicalHistoryList', 'cad', ['encounterDate', 'patientClinicalHistoryID']);
    }
  }

  $scope.setInnerValue = function(arrayName, labelToSet, excludeLabel){
    $scope.bitOn = false;
    if($scope.patient[arrayName][0] != undefined){
      angular.forEach($scope.patient[arrayName][0], function(value, label) {
        if(excludeLabel.indexOf(label) === -1 && value == 1){
          $scope.bitOn = true;
        }
      });
    }

    if($scope.bitOn == false){
      var jsonVariable = {}
      jsonVariable[labelToSet] = 1;
      
      if($scope.patient[arrayName][0] != undefined){
        $scope.patient[arrayName][0][labelToSet] = 1;
      } else {
        $scope.patient[arrayName].push(jsonVariable);
      }
    }
  }

  $scope.savePatientRecord = function(){

    
  $scope.getCalculatedValue('clinicalHistory', $scope.patient.patientClinicalHistoryList[0]);
  $scope.getCalculatedValue('symptomsAndSigns', $scope.patient.patientSymptomsList[0]);
  $scope.getCalculatedValue('physicalExam', $scope.patient.patientPhysicalExamList[0]);

  //$rootScope.isPageLoading = true;

  console.log('inside savePatientRecord');
  console.log($scope.patient);

  patientService.savePatientRecord($scope.patientId, $scope.patient).then(function(res){
    //$rootScope.hideLoader();
    if($scope.patientId == undefined){
      $location.url('/patientdetail/'+res.patientID);
    }
    alert('Patient information saved successfully');
  },function(err){
    $rootScope.isPageLoading = false;
    console.log(JSON.stringify(err));
  });

}

$scope.getCalculatedValue = function(key, data){
  $scope.patient[key] = 0;
  angular.forEach(data, function(value, label) {
    if(label != 'encounterDate' && label != 'patientClinicalHistoryID' && label != 'patientSymptomID' && label != 'patientPhysicalExamID' && value == 1){
        $scope.patient[key] = 1;
    } 
  });
}

$scope.showRecommendation = function(event){

  $scope.getCalculatedValue('clinicalHistory', $scope.patient.patientClinicalHistoryList[0]);
  $scope.getCalculatedValue('symptomsAndSigns', $scope.patient.patientSymptomsList[0]);
  $scope.getCalculatedValue('physicalExam', $scope.patient.patientPhysicalExamList[0]);

  $scope.patientCondition = angular.copy($scope.patient);

  $scope.labels = ['encounterDate', 'dateOfBirth', 'patientClinicalHistoryList', 'patientID', 'patientMRNNo', 'patientName', 'patientPhysicalExamList', 'patientSymptomsList', 'age'];
  $scope.removeElementFromPatientArray($scope.labels);

  $scope.replaceEmptyWithNull();  


  //$scope.patientCondition = {'symptomsAndSigns' : 'No'};

  $rootScope.isPageLoading = true;
  console.log('patientCondition in getTreatmentRecommendation');
  console.log($scope.patientCondition);
  patientService.getRecommendation($scope.patientCondition).then(function(res){
    console.log('after geting recomendation from reasoner')
    console.log(res);
    if(res.count != 0) {
      $rootScope.treeRefrence = res.response.treeReferencePath;
      $scope.recommendation = res.response.conclusionList[0].conclusionValue;
    } else {
      $rootScope.treeRefrence = '';
      $scope.recommendation = 'No Recmmendation Found';
    }

    $rootScope.hideLoader();
    $scope.showDialog(event, $scope.treeRefrence, $scope.recommendation);
  },function(err){
    $rootScope.isPageLoading = false;
    console.log(JSON.stringify(err));
  });

}

$scope.replaceEmptyWithNull = function(){
  angular.forEach($scope.patientCondition, function(value, label) {
    if(value == ''){
      //$scope.patientCondition[label] = null;
    }

  });
}

$scope.removeElementFromPatientArray = function(labels){
  angular.forEach(labels, function(label) {
    delete $scope.patientCondition[label];
  });
}



/**
 * Supplies a function that will continue to operate until the
 * time is up.
 */
 function debounce(func, wait, context) {
  var timer;

  return function debounced() {
    var context = $scope,
    args = Array.prototype.slice.call(arguments);
    $timeout.cancel(timer);
    timer = $timeout(function() {
      timer = undefined;
      func.apply(context, args);
    }, wait || 10);
  };
}


// Dialog code start here
$scope.showDialog = function(event, treeRefrence, recommendation) {
    $mdDialog.show({

      locals:{data : {treeRefrence, recommendation}},
      templateUrl : 'app/Views/dialog.html',
      parent : angular.element(document.body),
      targetEvent : event,
      clickOutsideToClose : true,
      controller : 'DialogController',
      fullscreen : $scope.customFullscreen
    })
    .then(function(answer) {
      $scope.status = 'You said the information was "' + answer + '".';
    }, function() {
      $scope.status = 'You cancelled the dialog.';
    });
  };

// Dialog code end here

    $scope.patientId = $routeParams.id;
    $scope.patientDetail = [];
    if($scope.patientId != undefined) {
      $scope.getPatientDetail($scope.patientId)
    }


});

app.controller("DialogController", function($scope, $timeout, $mdSidenav, $log, $mdDialog, $routeParams, $rootScope, $location, patientService, data){
  console.log(' in DialogController data');
  $scope.treeRefrence = data.treeRefrence;
  $scope.recommendation = data.recommendation;

  $scope.hide = function() {
    $mdDialog.hide();
  };

  $scope.cancel = function() {
    console.log('in dailog cancel');
    $mdDialog.cancel();
  };

  $scope.answer = function(answer) {
    $mdDialog.hide(answer);
  };
})

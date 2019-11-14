app.controller('loginCtrl', function ($scope, $routeParams, $rootScope, $location, $cookieStore, patientService) {

  $scope.error = '';
  $scope.login = function(){
    $scope.error = '';
    $rootScope.isPageLoading = true;
    patientService.login($scope.user).then(function(res){
      console.log(res);
      $rootScope.hideLoader();
      if(res.code == 200){
        $cookieStore.put('login', {'userName' : $scope.user.name});
        $rootScope.loginPage = false;
        $scope.redirectToURL('/');
      }  else if (res.code == 300){
        $rootScope.loginPage = true;
        $scope.error = res.message;
      }     
    },function(err){
      $rootScope.hideLoader();
      console.log(JSON.stringify(err));
    });
  }
});





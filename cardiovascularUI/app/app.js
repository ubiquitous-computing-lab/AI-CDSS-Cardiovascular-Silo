
//var app = angular.module('CardiovascularWebApp', ['ngRoute','ngMaterial', 'ngMessages', 'ngCookies', 'material.svgAssetsCache','angularUtils.directives.dirPagination','ui.bootstrap']);
var app = angular.module('CardiovascularWebApp', ['ngRoute','ngMaterial', 'ngMessages', 'ngCookies', 'material.svgAssetsCache','angularUtils.directives.dirPagination','ui.bootstrap']);

  app.config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {

    $routeProvider
    .when("/", {templateUrl: "app/Views/patientlisting.html", controller: "patientListingCtrl"})
    .when("/home/:MRN?", {templateUrl: "app/Views/patientlisting.html", controller: "patientListingCtrl"})
    .when("/patientdetail/:id?", {templateUrl: "app/Views/patientdetail.html", controller: "patientDetailCtrl"})
    .when("/login", {templateUrl: "app/Views/login.html", controller : "loginCtrl"})
    .otherwise("/404", {templateUrl: "app/Views/404.html", controller: "homeCtrl"});

  }]);

app.controller('AppCtrl', function ($scope, $timeout, $mdSidenav, $log, $location, $rootScope, $cookieStore) {

  $rootScope.isPageLoading = false;
  $rootScope.change        = false;
  $rootScope.loginPage     = false;

  //console.log(' parse int: '+btoa(''));
  //console.log('decode: '+ atob(''));


  if($location.path() == '/login' || $cookieStore.get('login') == undefined || $cookieStore.get('login').userName == undefined){
    $rootScope.loginPage = true;
  }

  $rootScope.isUserLogin = function(){

    if($cookieStore.get('login') != undefined && $cookieStore.get('login').userName != undefined) {
      return true
    } else {
      return false;
    }
  }

  $rootScope.logout = function(){
    $cookieStore.remove('login');
    $rootScope.loginPage = true;
    $scope.redirectToURL('/login');
  }

  $rootScope.$on("$routeChangeStart", function(event, nextLoc, currentLoc) {

    if(nextLoc.$$route.originalPath != '/login' && ! $rootScope.isUserLogin()){
      $location.path( '/login' );
    } else if (nextLoc.$$route.originalPath == '/login'  &&  $rootScope.isUserLogin()){
      $location.path('/')
    } 
  });

  $scope.searchPatient = function(keyEvent){
    if(keyEvent.which === 13){
      console.log('patientMRN: '+$scope.patientMRN);
      $scope.redirectToURL('/home/'+$scope.patientMRN);
    }
  }

  $scope.redirectToURL = function(URL){

    console.log('url: '+URL)
    $location.url(URL);
  }

  $rootScope.hideLoader = function(){
    console.log(' in rootScope hideLoader function');
    $timeout(function() {
      $rootScope.isPageLoading = false;
    }, 1000);
  }

  $scope.$on('$locationChangeStart', function( event ) {
    if($rootScope.change) {
     if(!confirm('Are you sure you want to leave this page? Your changes will be lost')){
        event.preventDefault();
      } 
    }
  });


});

    


app.controller('LeftCtrl', function ($scope, $timeout, $mdSidenav, $log) {
  $scope.close = function () {
      // Component lookup should always be available since we are not using `ng-if`
      $mdSidenav('left').close()
      .then(function () {
        $log.debug("close LEFT is done");
      });

    };
  });

var header = document.querySelector(".header");
var input = document.querySelector(".search-box-input");
var close = document.querySelector(".delete");

function hideHeader() {
  header.classList.remove('show');
  header.classList.add('hide');
};

function showHeader() {
  if (input.value === '') {
    header.classList.remove('hide');
    header.classList.add('show');
  }
};

function showHeaderOnClose() {
  header.classList.remove('hide');
  header.classList.add('show');
};

input.addEventListener("focus", hideHeader);
input.addEventListener("blur", showHeader);
close.addEventListener("click", showHeaderOnClose);

/*    *** configuration settings *** */

var appConfig = window.appConfig || {};
appConfig.apiRootUrl = 'api';
appConfig.apiBaseURL = "http://163.180.116.194:8091"; // Taqdir's system API
appConfig.reasonerBaseURL = "http://163.180.116.137:8666"; // Sadiq's system API
// appConfig.reasonerBaseURL = "http://163.180.116.151:8666"; // Sadiq's system API
window.appConfig = appConfig;

app.constant('APP_CONFIG', window.appConfig);

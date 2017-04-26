/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('FooterController', ['$scope', 'APP_CONSTANTS', function ($scope, APP_CONSTANTS) {
            
    $scope.appDetails = APP_CONSTANTS.appDetails;
    $scope.appName = $scope.appDetails.appName + " " + $scope.appDetails.version + " " + $scope.appDetails.versionType;
    $scope.user = { userName: "admin@gmail.com", password: "admin" };


}]);
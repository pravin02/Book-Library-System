/// <reference path="../../../Scripts/angular.js" />


mainApp.controller('HeaderController', ['$scope', 'APP_CONSTANTS', '$localStorage', function ($scope, APP_CONSTANTS, $localStorage) {
    $scope.appDetails = APP_CONSTANTS.appDetails;
    $scope.appName = $scope.appDetails.appName + " " + $scope.appDetails.version + " " + $scope.appDetails.versionType;
    $scope.fullName = $localStorage.user.fullName;
}]);
/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('DashboardController', ['$scope', 'APP_CONSTANTS',
    'commonService', '$log',
    function ($scope, APP_CONSTANTS, commonService, $log) {
        $scope.appDetails = APP_CONSTANTS.appDetails;
        $scope.appName = $scope.appDetails.appName + " " + $scope.appDetails.version + " " + $scope.appDetails.versionType;

        $scope.dashboard = {
            totalStudents: 0,
            totalStaffs: 0,
            totalBookCategories: 0,
            totalBooks: 0,
        };



        //getDashboardData start
        $scope.getDashboardData = function () {
            commonService.AjaxGet("dashboard", getDashboardDataSuccess, getDashboardDataFailed);
        }
        function getDashboardDataSuccess(response, status) {
            if (response.status) {
                $scope.dashboard = response.data;
            }
            else {
                alert("Error in getting Dashboard");
            }
        }
        function getDashboardDataFailed(response) {
            alert("Error in getting Dashboard");
        }
        //getDashboardData end

    }]);
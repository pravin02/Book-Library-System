/// <reference path="../Scripts/angular.js" />
mainApp.controller('LoginController', ['$rootScope', '$scope', '$log', 'commonService', 'APP_CONSTANTS','$state','$localStorage',
    function ($rootScope, $scope, $log, commonService, APP_CONSTANTS, $state, $localStorage) {
        $scope.status = true;
        $scope.message = "";
        $scope.appDetails = APP_CONSTANTS.appDetails;
        $scope.appName = $scope.appDetails.appName + " " + $scope.appDetails.version + " " + $scope.appDetails.versionType;
        $scope.user = { emailId: "admin@gmail.com", password: "admin" };


        // login start
        $scope.login = function (user) {
            $log.log(user);
            commonService.login(user, "authentication/admin", loginSuccess, loginError);
        }

        function loginSuccess(response, status) {
            $log.log(response);
            if (response.status) {
                $localStorage.user = response.data;
                $log.log($localStorage.user);
                $state.transitionTo('base.dashboard');

            } else {
                alert("Invalid username or password.");
                //toastr.error("Invalid UserName or Password.", "Error");
            }
        }
        function loginError(response) {
            $log.log(response);
            alert("error in login.");
            //toastr.error("Error in login.", "Error");
        }
        // login end
    }]);
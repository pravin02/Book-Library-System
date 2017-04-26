/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('IssuedBooksController', ['$scope', 'APP_CONSTANTS', 'commonService', '$log', '$localStorage',
function ($scope, APP_CONSTANTS, commonService, $log, $localStorage) {

    $scope.moduleName = "Issued Books";
    $scope.users = [];
    $scope.books = [];
    $scope.book = {};
    $scope.userType = "STAFF";

    //getAllStudents start
    $scope.getAllStudents = function () {
        commonService.AjaxGet("users?userType=".concat($scope.userType), getAllStudentsSuccess, getAllStudentsFailed);
    }
    function getAllStudentsSuccess(response, status) {
        if (response.status) {
            $scope.users = response.data;
        }
        else {
            alert("Error in getting staff");
        }
    }
    function getAllStudentsFailed(response) {
        alert("Error in getting staff");
    }
    $scope.getAllStudents();
    //getAllStudents end


    //selectedBook start
    $scope.getIssuedBooks = function (userId) {
        var url = "issue/".concat(userId);
        commonService.AjaxGet(url, getIssuedBooksSuccess, getIssuedBooksFailed);
    }
    function getIssuedBooksSuccess(response, status) {
        if (response.status) {
            $scope.books = response.data;
        }
        else {
            alert(response.message);
        }
    }
    function getIssuedBooksFailed(response) {
        alert("Error in getting books");
    }
    //selectedBook end



    $scope.user = {};
    $scope.setUser = function (user) {
        $scope.user = {};
        $scope.user = user;
        $scope.books = [];
        $scope.getIssuedBooks(user.userId);
    }
}]);
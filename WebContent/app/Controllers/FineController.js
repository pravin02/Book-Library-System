/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('FineController',
['$scope', 'APP_CONSTANTS', 'commonService', '$log',
function ($scope, APP_CONSTANTS, commonService, $log) {
    $scope.moduleName = "Fine";
    $scope.issuedBooks = [];
    $scope.books = [];
    $scope.book = {};

    //getIssuedBooks start
    $scope.getIssuedBooks = function () {
        commonService.AjaxGet("issue", getIssuedBooksSuccess, getIssuedBooksFailed);
    }
    function getIssuedBooksSuccess(response, status) {
        if (response.status) {
            $scope.issuedBooks = response.data;
        }
        else {
            alert(response.message);
        }
    }
    function getIssuedBooksFailed(response) {
        alert("Error in getting Dashboard");
    }
    $scope.getIssuedBooks();
    //getIssuedBooks end

    //getIssuedBooks start
    $scope.getIssuedBooksByUserId = function (userId) {
        commonService.AjaxGet("issue/".concat(userId), getIssuedBooksByUserIdSuccess, getIssuedBooksByUserIdFailed);
    }
    function getIssuedBooksByUserIdSuccess(response, status) {
        if (response.status) {
            $scope.books = response.data;
        }
        else {
            alert(response.message);
        }
    }
    function getIssuedBooksByUserIdFailed(response) {
        alert("Error in getting Dashboard");
    }
    //getIssuedBooks end


    // setBook start
    $scope.setBook = function (book) {
        $scope.books = [];
        $scope.book = {};
        $scope.book = book;
        //$scope.getIssuedBooksByUserId(book.user.userId);
    }
    // setBook end

    //registerFine start
    $scope.registerFine = function (fine) {
        commonService.AjaxPost(fine, "fine", registerFineSuccess, registerFineFailed);
    }
    function registerFineSuccess(response, status) {
        if (response.status) {
            alert(response.message);
        }
        else {
            alert(response.message);
        }
    }
    function registerFineFailed(response) {
        alert("Error in registering fine");
    }
    //registerFine end
}]);
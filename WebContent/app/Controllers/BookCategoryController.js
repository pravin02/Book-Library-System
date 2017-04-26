/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('BookCategoryController', ['$scope', 'APP_CONSTANTS', 'commonService', '$log',
function ($scope, APP_CONSTANTS, commonService, $log) {

    $scope.moduleName = "Book Category";
    $scope.btnAddNew = "New";

    $scope.categories = [];

    $scope.initToDefault = function () {
        $scope.bookCategory = { category: '' };
    }

    //getAllBookCategories start
    $scope.getAllBookCategories = function () {
        commonService.AjaxGet("categories", getAllCategoriesSuccess, getAllCategoriesFailed);
    }
    function getAllCategoriesSuccess(response, status) {
        if (response.status) {
            $scope.categories = response.data;
        }
        else {
            alert("Error in getting categories");
        }
    }
    function getAllCategoriesFailed(response) {
        alert("Error in getting categories");
    }
    //getAllBookCategories end


    //addBookCategory start
    $scope.addBookCategory = function (bookCategory) {
        commonService.AjaxPost(bookCategory, "categories", addSuccess, addFailure);
    }
    function addSuccess(response, status) {
        if (response.status) {
            alert("Book category added successfully.");
            $scope.getAllBookCategories();
        }
        else {
            alert("Error while adding book category");
        }
    }
    function addFailure(data) {
        alert("Error while adding book category");
    }
    //addBookCategory end
}]);
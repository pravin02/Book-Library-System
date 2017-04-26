/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('StudentController', ['$scope', 'APP_CONSTANTS', 'commonService', '$log', '$localStorage',
function ($scope, APP_CONSTANTS, commonService, $log, $localStorage) {

    $scope.moduleName = "Student";
    $scope.btnAddNew = "New";
    $scope.users = [];
    $scope.categories = [];
    $scope.books = [];
    $scope.book = {};

    $scope.states = APP_CONSTANTS.getAllStates();

    $scope.initToDefault = function () {
        $scope.user = { userType: 'STUDENT', country: APP_CONSTANTS.defaultCountry, gender: 'MALE', designation:'Student'};
    }
    $scope.initToDefault();



    //getAllStudents start
    $scope.getAllStudents = function () {
        commonService.AjaxGet("users?userType=STUDENT", getAllStudentsSuccess, getAllStudentsFailed);
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
    //getAllStudents end




    //updateUserStatus start
    $scope.updateUserStatus = function (user) {
        commonService.AjaxPut(user, "users/status/".concat(user.userId), updateUserStatusSuccess, updateUserStatusFailure);
    }
    function updateUserStatusSuccess(response, status) {
        if (response.status) {
            alert("status updated successfully.");
            $scope.users = [];
            $scope.getAllStudents();
        }
        else {
            alert("Error while updating Staff");
        }
    }
    function updateUserStatusFailure(data) {
        alert("Error while updating status");
    }
    //updateUserStatus end


    //getAllBookCategories start
    $scope.getAllBookCategories = function () {
        $scope.books = [];
        $scope.book = {};
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
    
    //getBooksByCategoryId start
    $scope.getBooksByCategoryId = function (categoryId) {
        $scope.books = [];
        $scope.book = {};
        commonService.AjaxGet("books/categories?categoryId=".concat(categoryId), getBooksByCategoryIdSuccess, getBooksByCategoryIdFailed);
    }
    function getBooksByCategoryIdSuccess(response, status) {
        if (response.status) {
            $scope.books = response.data;
        }
        else {
            alert("Error in getting books");
        }
    }
    function getBooksByCategoryIdFailed(response) {
        alert("Error in getting books");
    }
    //getBooksByCategoryId end


    //selectedBook start
    $scope.selectedBook = function (bookId) {
        var url = "books/".concat($scope.bookCategory).concat("/").concat(bookId);
        commonService.AjaxGet(url, getSelectedBookSuccess, getSelectedBookFailed);
    }
    function getSelectedBookSuccess(response, status) {
        if (response.status) {
            $scope.book = response.data;
        }
        else {
            alert("Error in getting books");
        }
    }
    function getSelectedBookFailed(response) {
        alert("Error in getting books");
    }
    //selectedBook end



    $scope.user = {};
    $scope.setUser = function (user) {
        $scope.user = {};
        $scope.user = user;
    }
    //issuBook start
    $scope.issuBook = function (categoryId, bookId) {
        commonService.AjaxPost({
            bookCategory: { categoryId }, bookId: bookId,
            userId: $scope.user.userId
        }, "issue", issuBookSuccess, issuBookFailed);
    }
    function issuBookSuccess(response, status) {
        if (response.status) {
            alert(response.message);
        }
        else {
            alert(response.message);
        }
    }
    function issuBookFailed(response) {
        alert("Error in getting books");
    }
    //issuBook end

    //Delete Book start
    $scope.deleteUser = function (userId) {
        commonService.AjaxDelete("users/".concat(userId), deleteUserSuccess, deleteUserFailure);
    }

    function deleteUserSuccess(response, status) {
        if (response.status) {
            $scope.getAllStudents();
            alert(response.message);
        }
        else {
            alert(response.message);
        }
    }
    function deleteUserFailure(data) {
        alert("Error while deleting Staff");
    }
    //Delete Book end



    //addStudent start
    $scope.addStudent = function (student) {
        commonService.AjaxPost(student, "users", addSuccess, addFailure);
    }
    function addSuccess(response, status) {        
            alert(response.message);        
    }
    function addFailure(data) {
        alert("Error while adding Student");
    }
    //addStudent end
}]);
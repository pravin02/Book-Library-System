/// <reference path="../../../Scripts/angular.js" />

mainApp.controller('BookController', ['$scope', 'APP_CONSTANTS', 'commonService', '$log', 'FileUploadService',
function ($scope, APP_CONSTANTS, commonService, $log, FileUploadService) {

    $scope.moduleName = "Books";
    $scope.btnAddNew = "New";
    $scope.categories = [];
    $scope.books = [];

    $scope.initToDefault = function () {
        $scope.book = { category: '' };
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



    //getBooksByCategoryId start
    $scope.getBooksByCategoryId = function (categoryId) {
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




    //addBook start
    $scope.addBook = function (book) {
        commonService.AjaxPost(book, "books", addSuccess, addFailure);
    }
    function addSuccess(response, status) {
        if (response.status) {
            alert("Book added successfully.");
        }
        else {
            alert("Error while adding book");
        }
    }
    function addFailure(data) {
        alert("Error while adding book");
    }
    //addBook end


    //editBook start
    $scope.book = {};
    $scope.editBook = function (book) {
        $scope.book = book;
    }
    //editBook end 


    $scope.getImage = function (index) {
        return IMAGEURL.concat($scope.books[index].image);
    }
    $scope.getBookImage = function (image, newImage) {
        //$log.log(newImage);
        return IMAGEURL.concat(image);
    }

    // File upload code start
    $scope.updateBookImage = function (book, bookImage) {
        console.log("BookController: bookImage: file is ");
        console.dir(bookImage);
        var fileName = bookImage.name;
        console.log("File Name " + fileName);
        var fileExt = fileName.substring(fileName.indexOf('.'), fileName.length);
        console.log("File Ext " + fileExt);

        if (!isValidFileExtension(fileExt)) {
            alert("Invalid file extension " + fileExt);
            return;
        }
        else {
            FileUploadService.uploadFileToUrl(bookImage, "books/update/".concat(book.bookId), bookImageUpdateSuccess, bookImageUpdateFailure);
        }
    };


    function bookImageUpdateSuccess(response, status) {
        if (response.status) {
            alert("Book Updated successfully.");
        }
        else {
            alert("Error while updating book");
        }
    }
    function bookImageUpdateFailure(data) {
        alert("Error while Updated book");
    }
    // File upload code end


    //Delete Book start
    $scope.deleteBook = function (bookId) {        
        commonService.AjaxDelete("books/".concat(bookId), deleteBookSuccess, deleteBookFailure);
    }

    function deleteBookSuccess(response, status) {
        if (response.status) {
            $scope.getBooksByCategoryId($scope.bookCategory);
            alert(response.message);
        }
        else {
            alert(response.message);
        }
    }
    function deleteBookFailure(data) {
        alert("Error while deleting book");
    }
    //Delete Book end
}]);
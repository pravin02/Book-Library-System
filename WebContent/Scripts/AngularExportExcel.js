/// <reference path="angular.min.js" />

var module = angular.module("module", []);

var myCtrl = function ($scope) {
    $scope.exportData = function () {
        alasql('SELECT * INTO XLSX("john.xlsx",{headers:true}) FROM ?', [$scope.items]);
    };
    $scope.school = "Iqra";

    $scope.items = [{
        name: "John Smith",
        email: "j.smith@example.com",
        dob: "1985-10-10",
        aa: "1985-10-10"
    }, {
        name: "Jane Smith",
        email: "jane.smith@example.com",
        dob: "1988-12-22"
    }, {
        name: "Jan Smith",
        email: "jan.smith@example.com",
        dob: "2010-01-02"
    }, {
        name: "Jake Smith",
        email: "jake.smith@exmaple.com",
        dob: "2009-03-21"
    }, {
        name: "Josh Smith",
        email: "josh@example.com",
        dob: "2011-12-12"
    }, {
        name: "Jessie Smith",
        email: "jess@example.com",
        dob: "2004-10-12"
    }];
};

module.controller("myCtrl", myCtrl);
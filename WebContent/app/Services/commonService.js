mainApp.factory('commonService',
    ['$rootScope', '$http',
    function ($rootScope, $http) {

        var ajaxServiceFunctions = {};
        // setting timeout of 1 second to simulate a busy server.
        var AjaxPost = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http.post(BASEURL + route, data).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);
        }

        var AjaxPostEncoded = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http.post(BASEURL + route, data, {
                    transformRequest: angular.identity,
                    headers: { 'Content-Type': "application/x-www-form-urlencoded" }
                })
             .success(function (response) {
                 $rootScope.loading = false;
                 successFunction(response);
             })
             .error(function (response) {
                 $rootScope.loading = false;
                 errorFunction(response);

             });

            }, 1000);
        }

        var login = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http.post(BASEURL + route, data).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);

        }

        var AjaxPostWithNoAuthenication = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http.post(route, data).success(function (response, status, headers, config) {
                    $scope.loading = false;
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);
        }

        var AjaxGet = function (route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http({ method: 'GET', url: BASEURL + route }).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);

        }

        var AjaxDelete = function (route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http({ method: 'DELETE', url: BASEURL + route }).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);

        }

        var AjaxGetWithData = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http({ method: 'GET', url: BASEURL + route, params: data }).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);

        }

        AjaxGetWithNoBlock = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http({ method: 'GET', url: route, params: data }).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 0);

        }


        var AjaxPut = function (data, route, successFunction, errorFunction) {
            $rootScope.loading = true;
            setTimeout(function () {
                $http({ method: 'PUT', url: BASEURL + route, data: data }).success(function (response, status, headers, config) {
                    $rootScope.loading = false;
                    successFunction(response, status);
                }).error(function (response) {
                    $rootScope.loading = false;
                    errorFunction(response);
                });
            }, 1000);

        }

        ajaxServiceFunctions.AjaxPost = AjaxPost;
        ajaxServiceFunctions.AjaxPostEncoded = AjaxPostEncoded;
        ajaxServiceFunctions.AjaxPostWithNoAuthenication = AjaxPostWithNoAuthenication;
        ajaxServiceFunctions.AjaxGet = AjaxGet;
        ajaxServiceFunctions.AjaxGetWithData = AjaxGetWithData;
        ajaxServiceFunctions.AjaxGetWithNoBlock = AjaxGetWithNoBlock;
        ajaxServiceFunctions.AjaxPut = AjaxPut;
        ajaxServiceFunctions.login = login;
        ajaxServiceFunctions.AjaxDelete = AjaxDelete;

        return ajaxServiceFunctions;
    }]);
mainApp.controller('BodyController', ['$scope', '$location', '$state', function ($scope, $location, $state) {
    $scope.body = {};
    $scope.body.dirty = false;
    //Dirty warning when redirecting to any external site either by clicking button or entering site URL.
    window.onbeforeunload = function (event) {
        if ($scope.body.dirty) {
            return "The page will be redirected to another site but there is unsaved data on this page.";
        }
    };
}])
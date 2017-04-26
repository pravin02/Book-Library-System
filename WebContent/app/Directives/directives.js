//Upercase
mainApp.directive('uppercased', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, modelCtrl) {
            modelCtrl.$parsers.push(function (input) {
                return input ? input.toUpperCase() : "";
            });
            element.css("text-transform", "uppercase");
        }
    };
});

//Disable cut, copy and past
mainApp.directive('stopccp', function () {
    return {
        scope: {},
        link: function (scope, element) {
            //element.on('cut copy paste', function (event) {
            element.on('paste', function (event) {
                event.preventDefault();
            });
        }
    };
});

var compareTo = function () {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function (scope, element, attributes, ngModel) {

            ngModel.$validators.compareTo = function (modelValue) {
                return modelValue == scope.otherModelValue;
            };

            scope.$watch("otherModelValue", function () {
                ngModel.$validate();
            });
        }
    };
};

mainApp.directive("compareTo", compareTo);

//mainApp.directive('ngSpinnerBar', ['$rootScope',
//    function ($rootScope) {
//        return {
//            link: function (scope, element, attrs) {
//                // by defult hide the spinner bar
//                element.addClass('hide'); // hide spinner bar by default

//                // display the spinner bar whenever the route changes(the content part started loading)
//                $rootScope.$on('$stateChangeStart', function () {
//                    element.removeClass('hide'); // show spinner bar
//                });

//                // hide the spinner bar on rounte change success(after the content loaded)
//                $rootScope.$on('$stateChangeSuccess', function () {
//                    element.addClass('hide'); // hide spinner bar
//                    $('body').removeClass('page-on-load'); // remove page loading indicator
//                    Layout.setSidebarMenuActiveLink('match'); // activate selected link in the sidebar menu

//                    // auto scorll to page top
//                    setTimeout(function () {
//                        App.scrollTop(); // scroll to the top on content load
//                    }, $rootScope.settings.layout.pageAutoScrollOnLoad);
//                });

//                // handle errors
//                $rootScope.$on('$stateNotFound', function () {
//                    element.addClass('hide'); // hide spinner bar
//                });

//                // handle errors
//                $rootScope.$on('$stateChangeError', function () {
//                    element.addClass('hide'); // hide spinner bar
//                });
//            }
//        };
//    }
//])
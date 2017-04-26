/// <reference path="angular.js" />
var mainApp = angular.module("mainApp",
    [
       "ngRoute",
       "ui.router",
       "angular-ladda",
       "ngStorage",
       "ui.bootstrap",
       "ngResource",
       "ui.bootstrap.modal",
       "ngExDialog",
       "ngAnimate",
       "chieffancypants.loadingBar",
       "ngFileUpload"
    ]);
//"angularUtils.directives.dirPagination"

//var BASEURL = "http://localhost:8080/BookLibraryAPI/api/";
//var IMAGEURL = "http://localhost:8080/BookLibraryAPI/";
var BASEURL = "api/";
var IMAGEURL = "books/";
mainApp.constant('APP_CONSTANTS', {
    appDetails: { 'appName': 'BookLibrary', 'version': 'v1.0', 'versionType': 'Beta' },
    getAllCountries: function () {
        countries = [];
        countries.push({ country: 'India' });
    },
    getAllStates: function () {
        states = [];
        states.push({ state: 'Andaman and Nicobar' });
        states.push({ state: 'Andhra Pradesh' });
        states.push({ state: 'Arunachal Pradesh' });
        states.push({ state: 'Assam' });
        states.push({ state: 'Bihar' });
        states.push({ state: 'Chandigarh' });
        states.push({ state: 'Chhattisgarh' });
        states.push({ state: 'Dadra and Nagar Haveli' });
        states.push({ state: 'Daman and Diu' });
        states.push({ state: 'Delhi' });
        states.push({ state: 'Goa' });
        states.push({ state: 'Gujrat' });
        states.push({ state: 'Haryana' });
        states.push({ state: 'Himachal Pradesh' });
        states.push({ state: 'Jammu and Kashmir' });
        states.push({ state: 'Jharkhand' });
        states.push({ state: 'Karnataka' });
        states.push({ state: 'Kerala' });
        states.push({ state: 'Lakshadweep' });
        states.push({ state: 'Madhya Pradesh' });
        states.push({ state: 'Maharashtra' });
        states.push({ state: 'Manipur' });
        states.push({ state: 'Meghalaya' });
        states.push({ state: 'Mizoram' });
        states.push({ state: 'Nagaland' });
        states.push({ state: 'Orissa' });
        states.push({ state: 'Pondicherry' });
        states.push({ state: 'Punjab' });
        states.push({ state: 'Rajasthan' });
        states.push({ state: 'Sikkim' });
        states.push({ state: 'Tamil Nadu' });
        states.push({ state: 'Tripura' });
        states.push({ state: 'Uttar Pradesh' });
        states.push({ state: 'Uttaranchal' });
        states.push({ state: 'West Bengal' });
        return states;
    },
    defaultCountry: 'India',
    defaultState: 'Maharashtra'

});

mainApp.config([
    '$stateProvider', '$urlRouterProvider', 'exDialogProvider', '$locationProvider', 'cfpLoadingBarProvider',
	function ($stateProvider, $urlRouterProvider, exDialogProvider, $locationProvider, cfpLoadingBarProvider) {
	    cfpLoadingBarProvider.includeSpinner = true;
	    exDialogProvider.setDefaults({
	        template: './app/vendor/ngExDialog/commonDialog.html', //from cache
	        width: '330px',
	    });

	    $stateProvider
            .state('base', {
                abstract: true,
                url: '/',
                views: {
                    "": {
                        templateUrl: './app/Templates/_tpl.base.html',
                    },
                    "header@base": {
                        templateUrl: './app/Views/Common/_header.html',
                        controller: 'HeaderController'
                    },
                    "sidebar@base": {
                        templateUrl: './app/Views/Common/_sidebar.left.html',
                        controller: 'SideMenuBarController'
                    },
                    "footer@base": {
                        templateUrl: './app/Views/Common/_footer.html',
                        controller: 'FooterController'
                    }
                }
            })
            /*Here we are defining state for authentication. */
            .state('auth', {
                abstract: true,
                url: '/',
                templateUrl: './app/Templates/_tpl.auth.html',
            })
            .state('auth.login', {
                url: 'login',
                views: {
                    'body@auth': {
                        templateUrl: './app/Views/_login.html',
                        controller: 'LoginController'
                    }
                }
            })
            .state('base.profile', {
                url: 'profile',
                views: {
                    'body@base': {
                        templateUrl: './app/Views/_tpl.profile.html',
                        controller: 'ProfileController'
                    }
                }
            })
            .state('base.dashboard', {
                url: 'dashboard',
                views: {
                    'body@base': {
                        templateUrl: './app/Views/Dashboard/_dashboard.html',
                        controller: 'DashboardController'
                    }
                }
            })
            .state('base.bookCategory', {
                url: 'book/categories',
                views: {
                    'body@base': {
                        templateUrl: './app/Views/Books/_tpl.book.category.html',
                        controller: 'BookCategoryController'
                    }
                }
            })
             .state('base.books', {
                 url: 'books',
                 views: {
                     'body@base': {
                         templateUrl: './app/Views/Books/_tpl.books.html',
                         controller: 'BookController'
                     }
                 }
             })

            .state('base.staff', {
                url: 'staff',
                views: {
                    'body@base': {
                        templateUrl: './app/Views/_tpl.staff.html',
                        controller: 'StaffController'
                    }
                }
            })
             .state('base.student', {
                 url: 'student',
                 views: {
                     'body@base': {
                         templateUrl: './app/Views/_tpl.student.html',
                         controller: 'StudentController'
                     }
                 }
             })
            .state('base.issuedBooks', {
                url: 'issuedBooks',
                views: {
                    'body@base': {
                        templateUrl: './app/Views/_tpl.issued.books.html',
                        controller: 'IssuedBooksController'
                    }
                }
            })

             .state('base.fine', {
                 url: 'fine',
                 views: {
                     'body@base': {
                         templateUrl: './app/Views/_tpl.fine.html',
                         controller: 'FineController'
                     }
                 }
             })

            .state('base.updatePassword', {
                url: 'updatePassword',
                views: {
                    'body@base': {
                        templateUrl: './app/Views/_update.password.html',
                        controller: 'UpdatePasswordController'
                    }
                }
            })

	}
]);


mainApp.run(
	['$rootScope', '$location', '$http', '$q', '$state', '$stateParams',
    function ($rootScope, $location, $http, $q, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
        $state.transitionTo('auth.login');//base.dashboard

        //Register listener to watch route changes
        //Here we check if user is not login and try to enter in system then must be redirected to login
        /*$rootScope.$on("$stateChangeStart", function (event, toState, toParams, fromState, fromParams) {
            if (toState.name != 'auth.login') {
                
                    $state.go('auth.login');
             
            }
        });*/
    }]);
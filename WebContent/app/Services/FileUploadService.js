mainApp.service('FileUploadService', ['$http', function ($http) {
    this.uploadFileToUrl = function (file, uploadUrl, successFunction, errorFunction) {
        var fd = new FormData();
        fd.append('file', file);

        $http.post(BASEURL+uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        })
        .success(function (response, status) {
            successFunction(response, status);            
        })
        .error(function (response) {
            errorFunction(response, status);
        });
    }
}]);


var fileExtFilter = [".png", ".jpeg", ".ico", ".jpg"];

function isValidFileExtension(fileExt) {
    var index = fileExtFilter.indexOf(fileExt);
    if (index == -1)
        return false;
    return true;
}
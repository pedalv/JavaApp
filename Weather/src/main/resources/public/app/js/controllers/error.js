angular.module('weather.controllers')
    .controller('ErrorCtrl', function ($scope) {
        $scope.textWrong = "Something went wrong";
        $scope.textCause = "Could not find the requested page.";
        $scope.textSorry = "Sorry for inconvenience caused!";
        $scope.textBack = 'Back to Home Page';
        $scope.linkBack = '/';
    });
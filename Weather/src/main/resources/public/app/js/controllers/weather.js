angular.module('weather.controllers')
    .controller('WeatherCtrl', [
            '$scope',
            'forecastService',
            function ($scope, forecastService) {
                $scope.title = "Vær for Svalbalen";

                forecastService.getWeather(function(forecast){
                    console.log("HERE")
                    //$scope.forecast = JSON.stringify(forecast);
                    $scope.forecast = forecast;
                    $scope.precipitationValue = forecast.precipitationValue;
                    $scope.pressureUnit = forecast.pressureUnit;
                    $scope.pressureValue = forecast.pressureValue;
                    $scope.symbolName = forecast.symbolName;
                    $scope.symbolNumber = forecast.symbolNumber;
                    $scope.temperatureUnit = forecast.temperatureUnit;
                    $scope.temperatureValue = forecast.temperatureValue;
                    $scope.timeFrom = forecast.timeFrom;
                    $scope.timeTo = forecast.timeTo;
                    $scope.windDirectionName = forecast.windDirectionName;
                    $scope.windSpeedMps = forecast.windSpeedMps;
                    $scope.windSpeedName = forecast.windSpeedName;
                });
            }
    ]);
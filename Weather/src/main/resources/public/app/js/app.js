angular.module('WeatherApp', [
    'ngMaterial',
    'weather.controllers',
    'weather.services'])
    .run(function(){
        console.log('WeatherApp is ready');
    });

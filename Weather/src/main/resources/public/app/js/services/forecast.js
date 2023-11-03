angular.module('weather.services')
	.factory('forecastService', [
		'$http',
        '$log',
		function($http, $log) {

			var url = 'http://localhost:8080/api/weather';

		    var getWeather = function(onSucess){
				return $http.get(url)
						.then(function(response) {
						    //var data = JSON.stringify(response.data);
						    var data = response.data;
							//console.log(data);
							onSucess(data);
				}, onError);
			};

			var onError = function () {
		        $log.error("** FEIL IN URL: "+ url +" **");
		    };

			return {
				getWeather: getWeather
			}
	}]);
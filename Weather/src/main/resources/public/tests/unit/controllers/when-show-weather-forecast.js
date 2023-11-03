'use strict';

describe('WeatherCtrl', function() {

    var httpBackend;
    var createController ;
    var weatherCtrl;
    var scope;
    var title = "Vær for Svalbalen";
    var forecast = [
        {
            "timeTo":"2017-02-02 15:00:00",
            "windSpeedMps":"2.4",
            "timeFrom":"2017-02-02 14:00:00",
            "symbolNumber":"4",
            "symbolName":"Skyet",
            "windSpeedName":"Svak vind",
            "pressureValue":"1003.7",
            "pressureUnit":"hPa","temperatureValue":"4",
            "temperatureUnit":"celsius",
            "precipitationValue":"0",
            "windDirectionName":"Øst-sørøst"
        }
    ];

    beforeEach(module(
        'ngMaterial',
        'weather.controllers',
        'weather.services'
     ));

    beforeEach(inject(function($rootScope, $httpBackend, $controller, forecastService){
        httpBackend = $httpBackend;
        scope = $rootScope.$new();
        createController  = function() {
            return $controller('WeatherCtrl', {
                '$scope': scope
            });
        };
    }));

    afterEach(function() {
        httpBackend.verifyNoOutstandingExpectation();
        httpBackend.verifyNoOutstandingRequest();
    });

    it('should has a title', function(){
        weatherCtrl = createController();
        expect(weatherCtrl).toBeDefined();
        expect(scope.title).toBe(title);
    });

    it('should has some forecast information', function(){
        weatherCtrl = createController();
        httpBackend.expect('GET','http://localhost:8080/api/weather')
                                    .respond(forecast);
        httpBackend.flush();
        httpBackend.verifyNoOutstandingExpectation();
        expect(scope.forecast[0]['timeTo']).toBe("2017-02-02 15:00:00");
        expect(scope.forecast[0]['windSpeedMps']).toBe("2.4");
        expect(scope.forecast[0]['timeFrom']).toBe("2017-02-02 14:00:00");
        expect(scope.forecast[0]['symbolNumber']).toBe("4");
        expect(scope.forecast[0]['symbolName']).toBe("Skyet");
        expect(scope.forecast[0]['windSpeedName']).toBe("Svak vind");
        expect(scope.forecast[0]['pressureValue']).toBe("1003.7");
        expect(scope.forecast[0]['pressureUnit']).toBe("hPa");
        expect(scope.forecast[0]['temperatureValue']).toBe("4");
        expect(scope.forecast[0]['temperatureUnit']).toBe("celsius");
        expect(scope.forecast[0]['precipitationValue']).toBe("0");
        expect(scope.forecast[0]['windDirectionName']).toBe("Øst-sørøst");

    });

});
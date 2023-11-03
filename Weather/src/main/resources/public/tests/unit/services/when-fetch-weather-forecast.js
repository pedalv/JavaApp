'use strict';

describe('forecastService', function () {

    var httpBackend;
    var forecastService;
    var createService ;
    var forecastService;
    var userList = {};
    var result = {};
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

    beforeEach(module('weather.services'));

    beforeEach(inject(function(_forecastService_, $httpBackend){
        httpBackend = $httpBackend;
        forecastService = _forecastService_;
    }));

    afterEach(function() {
        httpBackend.verifyNoOutstandingExpectation();
        httpBackend.verifyNoOutstandingRequest();
    });

    it('http is called', function(){
        httpBackend.expect('GET','http://localhost:8080/api/weather')
                        .respond(forecast);
        forecastService.getWeather(function(forecast){
            expect(forecast).toBeDefined();
            console.log(forecast);
            expect(forecast[0]['timeTo']).toBe("2017-02-02 15:00:00");
            expect(forecast[0]['windSpeedMps']).toBe("2.4");
            expect(forecast[0]['timeFrom']).toBe("2017-02-02 14:00:00");
            expect(forecast[0]['symbolNumber']).toBe("4");
            expect(forecast[0]['symbolName']).toBe("Skyet");
            expect(forecast[0]['windSpeedName']).toBe("Svak vind");
            expect(forecast[0]['pressureValue']).toBe("1003.7");
            expect(forecast[0]['pressureUnit']).toBe("hPa");
            expect(forecast[0]['temperatureValue']).toBe("4");
            expect(forecast[0]['temperatureUnit']).toBe("celsius");
            expect(forecast[0]['precipitationValue']).toBe("0");
            expect(forecast[0]['windDirectionName']).toBe("Øst-sørøst");
        });

        httpBackend.flush();
        httpBackend.verifyNoOutstandingExpectation();
    });

});
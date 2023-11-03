'use strict';

describe('ErrorCtrl', function() {

    var createController ;
    var errorCtrl;
    var scope;
    var textWrong = "Something went wrong";
    var textCause = "Could not find the requested page.";
    var textSorry = "Sorry for inconvenience caused!";
    var textBack = 'Back to Home Page';
    var linkBack = '/';

    beforeEach(module(
        'ngMaterial',
        'weather.controllers',
        'weather.services'
     ));

    beforeEach(inject(function($rootScope, $controller, $httpBackend, forecastService){
        scope = $rootScope.$new();
        createController  = function() {
            return $controller('ErrorCtrl', {
                '$scope': scope
            });
        };
        errorCtrl = createController();
    }));

    it('should has a title', function(){
        expect(errorCtrl).toBeDefined();
        expect(scope.textWrong).toBe(textWrong);
        expect(scope.textCause).toBe(textCause);
        expect(scope.textSorry).toBe(textSorry);
        expect(scope.textBack).toBe(textBack);
        expect(scope.linkBack).toBe(linkBack);
    });

});



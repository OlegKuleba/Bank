var app = angular.module('reportsPage', []);

app.controller('reportsController', function ($scope, $http) {

    $scope.showCitiesClientsReport = function () {
        $http.get('/getCitiesClientsReport').then(function (response) {
            var size = 0;
            //Check if response.data has any data
            for (var key in response.data) {
                if (response.data.hasOwnProperty(key)) {
                    size++;
                    break;
                }
            }
            if (size > 0) {
                $scope.citiesClientsReport = response.data;
            } else {
                alert("There aren't any addresses in DB");
            }
        });
    };

    $scope.showClientsWithSeveralCards = function () {
        $http.get('/getClientsWithSeveralCards').then(function (response) {
            if (response.data.length > 0) {
                $scope.clientsWithSeveralCardsReport = response.data;
            } else {
                alert("None of customers has several cards");
            }
        });
    };

    $scope.showLastOperationsOfCards = function () {
        $http.get('/getLastOperationsOfCards').then(function (response) {
            var generalArray = [];
            //Create array from map<long, object> -> map<card_id, cardHistory>
            for (var key in response.data) {
                var cardHistory = {card_id: key};
                //alert("Ключ: " + key + " значение: " + response.data[key]);
                for (var key1 in response.data[key]) {
                    //alert("Ключ: " + key1 + " значение: " + response.data[key][key1]);
                    cardHistory[key1] = response.data[key][key1];
                }
                generalArray.push(cardHistory);
            }

            generalArray.forEach(function (t, z) {
                for (var i in t) {
                    //alert("generalArray[" + z + "] -> Ключ: " + i + " значение: " + t[i]);
                    if (i == 'date') {
                        alert("{{ t[i] | date :'medium'}}");
                    }
                }
            });

            if (generalArray.length > 0) {
                $scope.lastOperationsOfCards = generalArray;
            } else {
                alert("There aren't any cards' operations in DB");
            }
        });
    };

});
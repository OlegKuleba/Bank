var app = angular.module('clientsPage', []);

app.controller('clientsController', function ($scope, $http) {

    var cardForm;
    var addressForm;
    var cardHistoryForm;
    var cardDetailsTable;

    $http.get('/getPersons').then(function (response) {
        $scope.persons = response.data;
        var elem = document.getElementById('cardForm');
        cardForm = angular.element(elem);
        elem = document.getElementById('addressForm');
        addressForm = angular.element(elem);
        elem = document.getElementById('cardHistoryForm');
        cardHistoryForm = angular.element(elem);
        elem = document.getElementById('cardDetailsTable');
        cardDetailsTable = angular.element(elem);
    });

    $scope.name = null;
    $scope.lastName = null;
    $scope.fatherName = null;

    $scope.addPerson = function (name, lastName, fatherName) {
        var myData = {
            name: name, lastName: lastName, fatherName: fatherName
        };

        $http({
            method: 'POST',
            url: '/addPerson',
            data: myData
        }).then(function successCallback(response) {
            $scope.persons = response.data;
            clearPersonForm();
            hideForms();
            hideCardDetailsTable();
        }, function errorCallback(response) {

        });
    };

    function clearPersonForm() {
        $scope.name = null;
        $scope.lastName = null;
        $scope.fatherName = null;
    }

    function clearAddressForm() {
        $scope.city = null;
        $scope.street = null;
        $scope.building = null;
        $scope.apartment = null;
    }

    function clearCardForm() {
        $scope.number = null;
        $scope.expDate = null;
        $scope.balance = null;
    }

    function clearCardHistoryForm() {
        $scope.operationTypes = null;
        $scope.amount = null;
    }

    function hideForms() {
        addressForm.css('display', 'none');
        cardForm.css('display', 'none');
        cardHistoryForm.css('display', 'none');
    }

    function hideCardDetailsTable() {
        cardDetailsTable.css('display', 'none');
    }

    $scope.addAddressForm = function (person) {
        $scope.person = person;
        hideForms();
        hideCardDetailsTable();
        addressForm.css('display', 'block');
    };

    $scope.address = null;

    $scope.addAddress = function (city, street, building, apartment) {
        var address = {city: city, street: street, building: building, apartment: apartment};
        $scope.person.address = address;
        var myData = {
            id: $scope.person.id,
            name: $scope.person.name,
            lastName: $scope.person.lastName,
            fatherName: $scope.person.fatherName,
            address: address
        };
        $http({
            method: 'POST',
            url: '/addAddress',
            data: myData
        }).then(function successCallback(response) {
            $scope.persons = response.data;
            /*$scope.persons.cardList = response.data;*/
            clearAddressForm();
            hideForms();
        }, function errorCallback(response) {

        });
    };

    $scope.addCardForm = function (person) {
        $scope.person = person;
        hideForms();
        hideCardDetailsTable();
        cardForm.css('display', 'block');
    };

    $scope.card = null;

    $scope.addCard = function (number, expDate, balance) {
        var card = {number: number, expDate: expDate, balance: balance, owner: $scope.person};
        /*$scope.person.card = card;*/
        $http({
            method: 'POST',
            url: '/addCard',
            data: card
        }).then(function successCallback(response) {
            $scope.person.cards = response.data;
            clearCardForm();
            hideForms();
        }, function errorCallback(response) {

        });
    };

    $scope.cards = null;

    $scope.showCards = function (person) {
        $scope.person = person;
        $http({
            method: 'POST',
            url: '/showCards',
            data: person
        }).then(function successCallback(response) {
            hideForms();
            hideCardDetailsTable();
            if (response.data.length != 0) {
                $scope.person.cards = response.data;
            } else {
                alert("The customer has no cards.");
            }
        }, function errorCallback(response) {

        });
    };

    $scope.addCardHistoryForm = function (card) {
        $scope.card = card;
        $scope.operationTypes = ["get money", "give away money"];
        hideForms();
        cardHistoryForm.css('display', 'block');
    };

    $scope.addCardHistory = function (operationType, amount) {
        var cardHistory = {operationType: operationType, amount: amount, card: $scope.card};
        $http({
            method: 'POST',
            url: '/addCardHistory',
            data: cardHistory
        }).then(function successCallback(response) {
            $scope.card.history = response.data;
            /*alert(JSON.stringify(response.data));*/
            clearCardHistoryForm();
            hideForms();
        }, function errorCallback(response) {

        });
    };


    $scope.showCardDetails = function (card) {
        $scope.card = card;
        hideForms();
        cardDetailsTable.css('display', 'table');
    };

    $scope.showCardHistory = function (card) {
        $scope.card = card;
        $http({
            method: 'POST',
            url: '/showCardHistory',
            data: card
        }).then(function successCallback(response) {
            $scope.card.history = response.data;
            /*alert(JSON.stringify(response.data));*/
            hideForms();
        }, function errorCallback(response) {

        });
    };

});

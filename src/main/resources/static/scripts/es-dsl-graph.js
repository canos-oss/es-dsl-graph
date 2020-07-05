function VisualQueryDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualQueryDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
function VisualRangeDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualRangeDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualRequestDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualRequestDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
function VisualScriptDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualScriptDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualTermDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualTermDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualTermsDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualTermsDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualBoolQueryDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualBoolQueryDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
function VisualConditionDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualConditionDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
function VisualConstantScoreDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualConstantScoreDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
function VisualExistsDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualExistsDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualFilterDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualFilterDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
function VisualIdsDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualIdsDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualMatchDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualMatchDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualMatchPhraseDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualMatchPhraseDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
function VisualMultiMatchDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualMultiMatchDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
var app = angular.module('app', []);

app.directive('visualMultiMatch', VisualMultiMatchDirective);
app.directive('visualQuery', VisualQueryDirective);
app.directive('visualRequest', VisualRequestDirective);
app.directive('visualTerm', VisualTermDirective);
app.directive('visualTerms', VisualTermsDirective);
app.directive('visualIds', VisualIdsDirective);
app.directive('visualBoolQuery', VisualBoolQueryDirective);
app.directive('visualCondition', VisualConditionDirective);
app.directive('visualConstantScore', VisualConstantScoreDirective);
app.directive('visualExists', VisualExistsDirective);
app.directive('visualFilter', VisualFilterDirective);
app.directive('visualMatch', VisualMatchDirective);
app.directive('visualMatchPhrase', VisualMatchPhraseDirective);
app.directive('visualScript', VisualScriptDirective);
app.directive('visualRange', VisualRangeDirective);

app.controller('controller', function ($scope, $http) {

    $scope.layoutLeftWidth_4_8 = "col-4";
    $scope.layoutLeftWidth_8_4 = "col-8";

    $scope.layoutLeftWidth = "col-4";

    $('#aceditor').css("height", "800px");

    //setup ace
    $scope.thisEditor = ace.edit("aceditor");
    $scope.thisEditor.setFontSize(16);
    $scope.thisEditor.session.setMode("ace/mode/json");

    //sample DSL
    var request = {};
    request.query = {};
    request.query.bool = {};
    request.query.bool.must = [];
    request.query.bool.must.push({ ids: { values: [1, 2, 3] } });
    var sampleDSL = JSON.stringify(request, null, 2);
    $scope.thisEditor.setValue(sampleDSL);
    $scope.thisEditor.clearSelection();
    $scope.thisEditor.gotoLine(1);

    $scope.formatNow = function () {
        $scope.request = null;
        var content = $scope.thisEditor.getValue();

        if (content == null || content.length == 0) {
            swal("content is null or invalid es DSL");
            return;
        }

        content = content.replace(/\\"/g, '"').replace(/\\n/g, '');
        var json = JSON.parse(content);
        var pretty = JSON.stringify(json, null, 2);
        $scope.thisEditor.setValue(pretty);

        $scope.thisEditor.clearSelection();
        $scope.thisEditor.setOption("wrap", "free");
        $scope.thisEditor.gotoLine(1);

        var rpcRequest = JSON.stringify(json);
        $http.post('format', { content: rpcRequest }).then(function (response) {
            if (response.data.statusCode != 1) {
                swal("Error, maybe DSL is null or invalid");
                return;
            }
            $scope.request = response.data.content;
        })
    };

    $scope.move = function () {

        var current = null;
        if (event.target.classList.contains('visual-panel')) {
            current = event.target;
        } else if (event.target.parentElement.classList.contains('visual-panel')) {
            current = event.target.parentElement;
        }

        if (current == null) {
            if (event.target.classList.contains('visual_must') || event.target.classList.contains('visual_should') || event.target.classList.contains('visual_filter')) {
                current = event.target.parentElement.parentElement;
            } else if (event.target.parentElement.classList.contains('visual_must') || event.target.parentElement.classList.contains('visual_should') || event.target.parentElement.classList.contains('visual_filter')) {
                current = event.target.parentElement.parentElement.parentElement;
            }
        }

        var items = document.getElementsByClassName('visual-panel');
        for (var i = 0; i < items.length; i++) {
            items[i].classList.remove('active');
        }

        if (current != null) {
            current.classList.add('active');
        }
    }
});
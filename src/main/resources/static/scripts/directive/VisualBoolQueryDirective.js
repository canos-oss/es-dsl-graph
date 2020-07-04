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
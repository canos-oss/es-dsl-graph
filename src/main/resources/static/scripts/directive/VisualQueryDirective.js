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
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
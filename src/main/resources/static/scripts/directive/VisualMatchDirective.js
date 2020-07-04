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
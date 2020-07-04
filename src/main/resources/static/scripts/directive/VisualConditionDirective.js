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
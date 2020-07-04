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
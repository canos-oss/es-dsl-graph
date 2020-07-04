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
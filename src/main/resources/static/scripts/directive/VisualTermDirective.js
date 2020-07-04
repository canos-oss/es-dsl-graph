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
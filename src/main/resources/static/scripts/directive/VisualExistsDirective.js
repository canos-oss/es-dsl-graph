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
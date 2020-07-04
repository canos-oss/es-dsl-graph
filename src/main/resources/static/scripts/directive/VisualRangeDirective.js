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
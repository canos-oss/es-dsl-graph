function VisualConstantScoreDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualConstantScoreDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
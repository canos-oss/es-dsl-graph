function VisualScriptDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualScriptDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
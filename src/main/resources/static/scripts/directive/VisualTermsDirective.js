function VisualTermsDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualTermsDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
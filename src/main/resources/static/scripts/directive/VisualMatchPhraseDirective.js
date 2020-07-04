function VisualMatchPhraseDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualMatchPhraseDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {


        }
    }
}
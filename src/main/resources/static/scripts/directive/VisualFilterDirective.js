﻿function VisualFilterDirective() {

    return {
        restrict: 'E',
        templateUrl: './scripts/directive/VisualFilterDirective.html?v=' + window.releaseNo,
        replace: true,
        scope: {
            item: '='
        },
        link: function (scope, element, attrs) {

        }
    }
}
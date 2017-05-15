(function() {
    'use strict';
    angular
        .module('adsApp')
        .factory('Post', Post);

    Post.$inject = ['$resource', 'DateUtils'];

    function Post ($resource, DateUtils) {
        var resourceUrl =  'api/posts/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.createdTime = DateUtils.convertDateTimeFromServer(data.createdTime);
                        data.createdDateRecord = DateUtils.convertDateTimeFromServer(data.createdDateRecord);
                        data.modifiedDateRecord = DateUtils.convertDateTimeFromServer(data.modifiedDateRecord);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();

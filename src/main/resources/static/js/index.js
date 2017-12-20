
//建立angular js终极版
var indexHtml = angular.module('ngRouteExample', ['ui.router','ngAnimate','bookstoreContrls']);

// indexHtml.config(function($stateProvider, $urlRouterProvider){
//     $urlRouterProvider.otherwise('/home');
//     $stateProvider
//         .state('home',{
//             url: '/home',
//             templateUrl: 'partials/home.html'
//         })
//         .state('photos',{
//             url: '/photos',
//             templateUrl: 'partials/photos.html'
//         })
//         .state('about',{
//             url: '/about',
//             templateUrl: 'partials/about.html'
//         })
// });

indexHtml.config(function ($stateProvider,$urlRouterProvider) {
    // FastClick.attach(document.body);
    //initialize get if not there
//      if (!$httpProvider.defaults.headers.get) {
//        $httpProvider.defaults.headers.get = {};
//      }
//      $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
//      $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
//      $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
    $urlRouterProvider.otherwise('/main');
    $stateProvider
        .state('main', {
            url:'/main',
            templateUrl: 'html/main.html',
            params:{'datas':null},
            controller:"mainCtrl"

        })
        .state('order', {
            url:'/order',
            templateUrl: 'html/order.html',
            params:{'carDo':null},
            controller:"orderCtrl"
        })
        .state('pay', {
            url:'/pay',
            templateUrl: 'html/pay.html',
            controller:"payCtrl"

        })

});

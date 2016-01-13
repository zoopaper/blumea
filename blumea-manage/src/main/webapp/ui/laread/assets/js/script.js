(function ($) {
    "use strict";
    if (top != self) {
        window.open(self.location.href, '_top');
    }
    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        //js.src = "https://connect.facebook.net/tr_TR/sdk.js#xfbml=1&appId=571763212946322&version=v2.0";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


    document.addEventListener('DOMContentLoaded', function () {
        var i = prettyPrint();
    });

    if (navigator.userAgent.match(/Trident.*rv:11\./)) {
        $('body').addClass('ie11');
    }


    function mediumResize() {
        if (window.innerWidth > 768) {
            $(".post-medium .col-md-7").each(function () {

                var heightMost;
                //var heightCurrent	= $(this).outerHeight();
                var heightPrev = $(this).prev('.col-md-5').outerHeight();

                //if(heightCurrent > heightPrev){
                //	heightMost = heightCurrent;
                //} else {
                heightMost = heightPrev;
                //}

                $(this).prev('.col-md-5').children('.row').css('height', heightMost);
                $(this).children('.post-item').css('height', heightMost);
            });
        }
    }

    $(window).load(function () {
        $(".page-loader div").delay(0).fadeOut("fast");
        $(".page-loader").delay(250).fadeOut("fast");

        mediumResize();
    });
    $(window).on('resize', function () {
        mediumResize();
    });
    $(document).ready(function () {

        $('a[data-fluidbox]').colorbox({
            width: '86%',
            height: '86%',
            close: '',
        });

        var $container = $('.masonry');
        $container.imagesLoaded(function () {
            $container.masonry({
                itemSelector: '.masonry-row'
            });
        });
        var i = prettyPrint();
        $('iframe').ready(function () {
            $container.masonry();
        });

        $('.fb-post').each(function (index) {
            $(this).attr("data-width", $(this).parent().width());
        });

        window.fbAsyncInit = function () {
            FB.XFBML.parse(null, function () {
                $container.masonry();
                mediumResize();
            });
        };


        $container.on('click', '.open-comments', function (e) {
            var commentid = $(this).data('comments-id');
            $('#comments-' + commentid).toggleClass('is-expand');
            $container.masonry();
            e.preventDefault();
        });
        $("#calendar-widget").zabuto_calendar({
            today: true,
        });


        $('#month-year-tab').on('click', function (e) {
            $('.tab-sub-content.in').collapse('hide');
            $('.article-type li').removeClass('active');
            $(this).parent('li').addClass('active');
        });

        $('#category-tab').on('click', function (e) {
            $('.tab-sub-content.in').collapse('hide');
            $('.article-type li').removeClass('active');
            $(this).parent('li').addClass('active');
        });

        $('#author-tab').on('click', function (e) {
            $('.tab-sub-content.in').collapse('hide');
            $('.article-type li').removeClass('active');
            $(this).parent('li').addClass('active');
        });

        $('#lastest-tab').on('click', function (e) {
            $('.tab-sub-content.in').collapse('hide');
        });


        $('a[data-gallery-item]').on('click', function (e) {
            var gitem = $(this).data('gallery-item');
            var gid = '#' + gitem + ' a';
            var gcontainer = '#blueimp-' + gitem;
            blueimp.Gallery($(gid), {
                container: gcontainer,
                startSlideshow: true,
                onclose: function () {
                    if (screenfull.isFullscreen) {
                        screenfull.exit();
                    }
                },
            });
            e.preventDefault();
        });

        $('.quick-read').on('click', function (e) {

            $(".page-loader div").fadeIn("fast");
            $(".page-loader").fadeIn("fast");
            $('#quick-read').scrollTop(0);
            if (window.innerWidth > 1024) {
                //$('#quick-read').css({'top': $(window).scrollTop()});
            }

            setTimeout(function () {
                $('#quick-read').show();
                //$('.qr-content').html(qrContent);
                $('body').addClass('no-scroll');

                $(".page-loader div").delay(250).fadeOut("slow");
                $(".page-loader").delay(250).fadeOut("slow");

                //$('#quick-read').find('a.fluidbox-qr').fluidbox(); //data-fluidbox-qr
                $('a[data-fluidbox-qr]').colorbox({
                    height: '86%',
                    width: '86%',
                    close: '',
                });


            }, 500);

            e.preventDefault();
        });

        $('.qr-close').on('click', function (e) {
            $('#quick-read').fadeOut('slow');
            $('body').removeClass('no-scroll');
            e.preventDefault();
        });

        $('.qr-search').on('click', function (e) {
            $('.qr-search-form').fadeIn('fast');
            $(this).fadeOut('fast', function () {
                $('.qr-search-close').fadeIn('slow');
                $('.qr-search-form input').focus();

            });
            e.preventDefault();
        });

        $('body.no-scroll').bind("touchmove", {}, function (event) {
            event.preventDefault();
        });

        $('.qr-search-close').on('click', function (e) {
            $('.qr-search-form').fadeOut('fast');
            $(this).fadeOut('fast', function () {
                $('.qr-search').fadeIn('slow');
            });
            e.preventDefault();
        });

        $('.qr-change').on('click', function (e) {
            var qrClass = $('#quick-read').attr('class');
            var qrSwitch;
            if (qrClass === 'qr-white-theme') {
                qrSwitch = 'qr-black-theme';
            } else {
                qrSwitch = 'qr-white-theme';
            }

            $('#quick-read').removeClass(qrClass).addClass(qrSwitch);
            e.preventDefault();
        });


        $(document).on('click touchstart', '.canvas-overlay', function () {
            $('.remove-navbar').trigger('click');
        });

        $('.push-navbar').on('click', function (e) {
            var navmenuType = $('.push-navbar').data('navbar-type');
            var canvasHeight = $('.canvas').outerHeight();

            $('.navmenu').height(canvasHeight);
            if (navmenuType == 'default') {
                $('body').toggleClass('is-push-bar');
            } else if (navmenuType == 'full') {
                $('body').toggleClass('is-push-bar-full');
                $('.post-title-list > li > div').toggleClass('container');
                $('.push-navbar i').toggleClass('fa-bars');
                $('.push-navbar i').toggleClass('fa-times');
            }
            $('.navmenu').addClass('navmenu-' + navmenuType);
            $postTitleIsotoper.isotope();
            e.stopPropagation();
        });

        $('.remove-navbar').on('click', function () {
            $('body').removeClass('is-push-bar');
            $('body').removeClass('is-push-bar-full');
            $('.navmenu').removeClass('navmenu-default');
            $('.navmenu').removeClass('navmenu-full');
            $('.navmenu').height(0);
        });

        if (window.innerWidth > 1024) {
            $('.post-medium-vertical .container-fluid, .large-image-v1:not(.article-intro) .container-fluid, .post-striped .post-fluid .container-fluid, .post-mediums > .post-medium').addClass("nopacity").viewportChecker({
                classToAdd: 'visible animated fadeInUp',
                offset: 50
            });
        }
        $('.qr-share, .banner-share, .pis-share, .quotes-share').popover({
            html: true,
        });

        $('.qr-share, .banner-share, .pis-share, .quotes-share').on('click', function (e) {
            e.preventDefault();
        });

        $(document).on('click', '.popover-content a', function (e) {
            $('[data-toggle="popover"]').popover('hide');
            e.preventDefault();
        });

        $('.banner-search').on('click', function (e) {
            console.log(screen.width);
            if (screen.width > 767) {
                $('.navbar-collapse').fadeOut('fast');
            }
            $('.banner-search').fadeOut('fast', function () {
                $('.banner-search-form').fadeIn('fast');
                $('.banner-search-close').fadeIn('slow');
                $('.banner-search-form input').focus();
            });
            e.preventDefault();
        });

        $('.banner-search-close').on('click', function (e) {
            $('.banner-search-form').fadeOut('fast');
            $(this).fadeOut('fast', function () {
                $('.banner-search').fadeIn('slow');
                if (screen.width > 767) {
                    $('.navbar-collapse').fadeIn('slow');
                }
            });
            e.preventDefault();
        });

        window.scrollTo(window.pageXOffset, window.pageYOffset - 1);

        $('.menu-collapse').on('click', function () {
            $('.navbar').toggleClass('navbar-open');
        });


        /*
         var scrollTop = 0;
         var $navi = $(":not(.is-push-bar) .navbar:not(.navbar-open)");
         $(window).on( 'scroll', function() {

         var y = $(this).scrollTop(),
         speed = 0.05,
         pos = y * speed,
         maxPos = 100;
         if (y > scrollTop) {
         pos = maxPos;
         } else {
         pos = 0;
         }
         scrollTop = y;
         $navi.css({
         "-webkit-transform": "translateY(-" + pos + "%)",
         "-moz-transform": "translateY(-" + pos + "%)",
         "-ms-transform": "translateY(-" + pos + "%)",
         "-o-transform": "translateY(-" + pos + "%)",
         "transform": "translateY(-" + pos + "%)"
         });
         });
         */
// Hide Header on on scroll down
        var didScroll;


        $(window).scroll(function (event) {
            didScroll = true;
        });

        setInterval(function () {
            if (didScroll) {
                hasScrolled();
                didScroll = false;
            }
        }, 250);


        /*
         if ($(document).scrollTop() < 70) {
         $("nav").removeAttr("style");
         }
         */
        $(".item img").on('click', function () {
            if ($('.right.carousel-control').length > 0) {
                $('.right.carousel-control').trigger('click');
            } else if ($('.masonry-right').length > 0) {
                $('.masonry-right').trigger('click');
            }
        });

        /*masonry isotope*/
        var $isotoper = $('.isotopeContainer').isotope({
            itemSelector: '.masonry-row'
        });
        var filterFns = {};

        $('#filters .unfilter').on('click', function (e) {
            e.preventDefault();
            $(this).addClass('hide');
            $('#filters a').removeClass('selected');

            var filterValue = '*';
            filterValue = filterFns[filterValue] || filterValue;
            $isotoper.isotope({
                filter: filterValue
            });
            e.stopPropagation();
        });

        $('#filters').on('click', 'a', function (e) {
            var filterValue = $(this).attr('data-filter');
            $('#filters a').removeClass('selected');
            $(this).addClass('selected');
            $('#filters.unfilter').removeClass('hide');

            filterValue = filterFns[filterValue] || filterValue;
            $isotoper.isotope({
                filter: filterValue
            });
            e.preventDefault();
        });
        /*!masonry isotope*/

        /*big gallery isotope*/
        var $bigGalleryIsotoper = $('.isotopeGallery').isotope({
            itemSelector: '.gallery-item'
        });
        var filterFns = {};

        $('#filters .unfilter').on('click', function (e) {
            e.preventDefault();
            $(this).addClass('hide');
            $('#filters a').removeClass('selected');

            var filterValue = '*';
            filterValue = filterFns[filterValue] || filterValue;
            $bigGalleryIsotoper.isotope({
                filter: filterValue
            });


            e.stopPropagation();
        });

        $('#filters').on('click', 'a', function (e) {
            var filterValue = $(this).attr('data-filter');
            $('#filters a').removeClass('selected');
            $(this).addClass('selected');
            $('#filters .unfilter').removeClass('hide');

            filterValue = filterFns[filterValue] || filterValue;
            $bigGalleryIsotoper.isotope({
                filter: filterValue
            });
            e.preventDefault();
        });
        /*!big gallery isotope*/

        var $galleryIsotoper = $('.gallery-twice').isotope({
            itemSelector: '.gallery-twice > div'
        });
        $galleryIsotoper.masonry();
        var filterFns = {};

        $('#filters .unfilter').on('click', function (e) {
            e.preventDefault();
            $(this).addClass('hide');
            $('#filters a').removeClass('selected');

            var filterValue = '*';
            filterValue = filterFns[filterValue] || filterValue;
            $galleryIsotoper.isotope({
                filter: filterValue
            });

            e.stopPropagation();
        });


        $('#filters').on('click', 'a', function (e) {
            var filterValue = $(this).attr('data-filter');
            filterValue = filterFns[filterValue] || filterValue;
            $galleryIsotoper.isotope({
                filter: filterValue
            });
            e.preventDefault();
        });

        var $postTitleIsotoper = $('.post-title-list').isotope({
            itemSelector: '.post-title-list li',
            position: 'relative',
            hiddenStyle: {
                opacity: 0
            },
            visibleStyle: {
                opacity: 1
            }
        });
        var filterFns = {};


        $('#post-titles .unfilter').on('click', function (e) {
            e.preventDefault();
            $(this).addClass('hide');

            $('#post-titles a').removeClass('selected');
            $(this).addClass('selected');


            var filterValue = '*';
            filterValue = filterFns[filterValue] || filterValue;
            $postTitleIsotoper.isotope({
                filter: filterValue
            });


            e.stopPropagation();
        });

        $('#post-titles').on('click', 'a', function (e) {
            var filterValue = $(this).attr('data-filter');

            $('#post-titles a').removeClass('selected');
            $(this).addClass('selected');
            $('#post-titles .unfilter').removeClass('hide');

            filterValue = filterFns[filterValue] || filterValue;
            $postTitleIsotoper.isotope({
                filter: filterValue
            });
            e.preventDefault();
        });

        $('.main-comment-form .comment-textarea').bind('focus', function () {
            $(this).addClass('on-focus');
            setTimeout(function () {
                $('.at-focus').slideDown('fast');
            }, 150);
        });

        // login and singup modal
        $("#register-btn").on('click', function () {
            $('#register-content').fadeIn('fast');
            $('#login-content').fadeOut('fast');
            var email = $('#login-content #email').val();
            $('#register-content #email').val(email);
        });

        $("#login-btn").on('click', function () {
            $('#login-content').fadeIn('fast');
            $('#register-content').fadeOut('fast');
            var email = $('#register-content #email').val();
            $('#login-content #email').val(email);
        });

        $('.newsletter-bar .form-control').on('focusin', function () {
            $(this).parent().addClass('focusin');
        });
        $('.newsletter-bar .form-control').on('focusout', function () {
            $(this).parent().removeClass('focusin');
        });

        $('.newsletter-bar .form-control').on('keyup', function () {
            var email = $(this).val();

            if (IsEmail(email)) {
                $(this).parent().addClass('valid-text');
            } else {
                $(this).parent().removeClass('valid-text');
            }

            return false;
        });

        // for fullscreen
        $('.set-fullscreen').on('click', function (e) {
            //var target = $(this).closest('.blueimp-gallery')[0];
            var target = $('html')[0];
            screenfull.toggle(target);
            $(this + ' i').toggleClass('fa-compress', 'fa-expand');
            e.preventDefault();
        });

        // ellipsis
        $('.six-lines').ellipsis({lines: 6});
        $('.five-lines').ellipsis({lines: 5});
        $('.four-lines').ellipsis({lines: 4});
        $('.three-lines').ellipsis({lines: 3});
        $('.two-lines').ellipsis({lines: 2});


        $(".ellipsis-readmore").dotdotdot({
            after: "a.more"
        });


        $('.search-form .form-control').on('focusin', function () {
            $(this).parent().addClass('focusin');
        });
        $('.search-form .form-control').on('focusout', function () {
            $(this).parent().removeClass('focusin');
        });

        $('.newsletter-box').on('mouseover', function () {
            $(this).addClass('on-focus');
            $(this).children('input').attr('placeholder', 'Enter your email address');
        });

        $('.contact-form-vertical button').on('click', function (e) {
            e.preventDefault();
            var $current = $(this).children('span');
            var value = $current.text();
            $current.fadeOut('slow', function () {
                $current.fadeIn('fast');
                $current.html('<i class="fa fa-check"></i> Message successfully sent');
            });
        });

        $('.article-list .media-heading').on('hover',
            function () {
                $(this).parent().prev().addClass('hover');
            },

            function () {
                $(this).parent().prev().removeClass('hover');
            }
        );

        $('.play-icon').on('click', function (e) {
            e.preventDefault();
            $(this).fadeOut('slow');
            $(this).closest('.gallery-large-item').children('.gallery-info').fadeOut('slow');
            $(this).prev().attr('src', $(this).prev().attr('src') + '&autoplay=1');
        });

        $('.post-like').on('click', function (e) {
            e.preventDefault();
            $(this).addClass('active at-focus').delay(2118).queue(function () {
                $(this).removeClass('active').dequeue();
            });
        });

        $(".carousel").swipe({
            swipeLeft: function (event, direction, distance, duration, fingerCount) {
                $('.right').trigger('click');
            },
            swipeRight: function (event, direction, distance, duration, fingerCount) {
                $('.left').trigger('click');
            }
        });

        $('.banner-icon.with-background').on('click', function (e) {
            $(this).addClass('is-active');
            e.preventDefault();
        });

        // for demo
        var width = screen.width;
        var height = screen.height;
        // console.log(width +' x ' + height);

        $('.masonry-embed').parent().css('z-index', 2)
    });
})(jQuery);

function IsEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $(":not(.is-push-bar) .navbar:not(.navbar-open)").outerHeight();
var navi = $(":not(.is-push-bar) .navbar:not(.navbar-open)");


function hasScrolled() {
    var st = $(this).scrollTop();

    // Make sure they scroll more than delta
    if (Math.abs(lastScrollTop - st) <= delta)
        return;

    // If they scrolled down and are past the navbar, add class .nav-up.
    // This is necessary so you never see what is "behind" the navbar.
    if (st > lastScrollTop && st > navbarHeight) {
        // Scroll Down
        navi.removeClass('nav-down').addClass('nav-up');
    } else {
        // Scroll Up
        if (st + $(window).height() < $(document).height()) {
            navi.removeClass('nav-up').addClass('nav-down');
        }
    }

    lastScrollTop = st;
}
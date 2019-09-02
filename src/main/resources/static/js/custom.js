"use strict";

//General function for all pages

//Modernizr touch detect
Modernizr.load({
    test: Modernizr.touch,
    yep: ['css/touch.css?v=1'],
    nope: []
});

//1. Scroll to top arrow
// Scroll to top
var $block = $('<div/>', {'class': 'top-scroll'}).append('<a href="#"/>').hide().appendTo('body').click(function () {
    $('body,html').animate({scrollTop: 0}, 800);
    return false;
});

//2. Mobile menu
//Init mobile menu
$('#navigation').mobileMenu({
    triggerMenu: '#navigation-toggle',
    subMenuTrigger: ".sub-nav-toggle",
    animationSpeed: 500
});

//3. Search bar dropdown
//search bar
$("#search-sort").selectbox({
    onChange: function (val, inst) {

        $(inst.input[0]).children().each(function (item) {
            $(this).removeAttr('selected');
        });
        $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
    }
});

//4. Login window pop up
//Login pop up
$('.login-window').click(function (e) {
    e.preventDefault();
    $('.overlay').removeClass('close').addClass('open');
});

$('.overlay-close').click(function (e) {
    e.preventDefault;
    $('.overlay').removeClass('open').addClass('close');

    setTimeout(function () {
        $('.overlay').removeClass('close');
    }, 500);
});


function user_list() {
    //user list option
    $('.auth__show').click(function (e) {
        e.preventDefault();
        $('.auth__function').toggleClass('open-function')
    });

    $('.btn--singin').click(function (e) {
        e.preventDefault();
        $('.auth__function').toggleClass('open-function')
    });
}

//2. Dropdown for authorize button
//user list option
user_list();

function init_Home() {
    "use strict";

    //3. Mega select with filters (and markers)
    //Mega select interaction
    $('.mega-select__filter').click(function (e) {
        //prevent the default behaviour of the link
        e.preventDefault();
        $('.select__field').val('');

        $('.mega-select__filter').removeClass('filter--active');
        $(this).addClass('filter--active');

        //get the data attribute of the clicked link(which is equal to value filter of our content)
        var filter = $(this).attr('data-filter');

        //Filter buttons
        //show all the list items(this is needed to get the hidden ones shown)
        $(".select__btn a").show();
        $(".select__btn a").css('display', 'inline-block');

        /*using the :not attribute and the filter class in it we are selecting
        only the list items that don't have that class and hide them '*/
        $('.select__btn a:not(.' + filter + ')').hide();

        //Filter dropdown
        //show all the list items(this is needed to get the hidden ones shown)
        $(".select__group").removeClass("active-dropdown");
        $(".select__group").show();

        /*using the :not attribute and the filter class in it we are selecting
        only the list items that don't have that class and hide them '*/
        $('.select__group.' + filter).addClass("active-dropdown");
        $('.select__group:not(.' + filter + ')').hide();

        //Filter marker
        //show all the list items(this is needed to get the hidden ones shown)
        $(".marker-indecator").show();

        /*using the :not attribute and the filter class in it we are selecting
        only the list items that don't have that class and hide them '*/
        $('.marker-indecator:not(.' + filter + ')').hide();
    });

    $('.filter--active').trigger('click');
    $('.active-dropdown').css("z-index", '-1');

    $('.select__field').focus(function () {
        $(this).parent().find('.active-dropdown').css("opacity", 1);
        $(this).parent().find('.active-dropdown').css("z-index", '50');
    });

    $('.select__field').blur(function () {
        $(this).parent().find('.active-dropdown').css("opacity", 0);
        $(this).parent().find('.active-dropdown').css("z-index", '-1');
    });

    $('.select__variant').click(function (e) {
        e.preventDefault();
        $(this).parent().find('.active-dropdown').css("z-index", '50');
        var value = $(this).attr('data-value');
        $('.select__field').val(value);
        $(this).parent().find('.active-dropdown').css("z-index", '-1');
    });

    //4. Rating scrore init
    //Rating star
    $('.score').raty({
        width: 130,
        score: 0,
        path: '/images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

    //5. Scroll down navigation function
    //scroll down
    $('.movie-best__check').click(function (ev) {
        ev.preventDefault();
        $('html, body').stop().animate({'scrollTop': $('#target').offset().top - 30}, 900, 'swing');
    });
}

//订票1
function choose(sceneId) {
    // var scenesId = sceneId;
    var chooseMovieId = $('#book-movieId').val();
    var moviePrice = $('#book-moviePrice').val();
    var showTime = $('#book-movieShowTime').val();

    var movieId = $('.choosen-movieId'),
        price = $('.choosen-moviePrice'),
        formSceneId = $('.choosen-sceneId'),
        time = $('.choosen-time');

    price.val(moviePrice);
    movieId.val(chooseMovieId);
    time.val(showTime);
    formSceneId.val(sceneId);

    $('.booking-pagination__next').click(function () {
        $('.booking-form').submit();
    });
}

function init_BookingOne() {
    "use strict";

    //1. Buttons for choose order method
    //order factor
    $('.order__control-btn').click(function (e) {
        e.preventDefault();

        $('.order__control-btn').removeClass('active');
        $(this).addClass('active');
    });

    //2. Init vars for order data
    // var for booking;
    var movie = $('.choosen-movie'),
        city = $('.choosen-city'),
        date = $('.choosen-date'),
        cinema = $('.choosen-cinema'),
        time = $('.choosen-time');

    //6. Choose variant proccess
    //choose film
    $('.film-images').click(function (e) {
        //visual iteractive for choose
        $('.film-images').removeClass('film--choosed');
        $(this).addClass('film--choosed');

        //data element init
        var chooseFilm = $(this).parent().attr('data-film');
        $('.choose-indector--film').find('.choosen-area').text(chooseFilm);

        //data element set
        movie.val(chooseFilm);

    });

    //choose time
    $('.time-select__item').click(function () {
        //visual iteractive for choose
        $('.time-select__item').removeClass('active');
        $(this).addClass('active');

        //data element init
        var chooseTime = $(this).attr('data-time');
        $('.choose-indector--time').find('.choosen-area').text(chooseTime);

        //data element init
        var chooseCinema = $(this).parent().parent().find('.time-select__place').text();

        //data element set
        time.val(chooseTime);
        cinema.val(chooseCinema);
    });

    // choose (change) city and date for film

    //data element init (default)
    var chooseCity = $('.select .sbSelector').text();
    var chooseDate = $('.datepicker__input').val();

    //data element set (default)
    city.val(chooseCity);
    date.val(chooseDate);


    $('.select .sbOptions').click(function () {
        //data element change
        var chooseCity = $('.select .sbSelector').text();
        //data element set change
        city.val(chooseCity);
    });

    $('.datepicker__input').change(function () {
        //data element change
        var chooseDate = $('.datepicker__input').val();
        //data element set change
        date.val(chooseDate);
    });

    // --- Step for data - serialize and send to next page---//
    $('.booking-form').submit(function () {
        var bookData = $(this).serialize();
        $.get($(this).attr('action'), bookData);
    });

    //7. Visibility block on page control
    //control block display on page
    $('.choose-indector--film').click(function (e) {
        e.preventDefault();
        $(this).toggleClass('hide-content');
        $('.choose-film').slideToggle(400);
    });

    $('.choose-indector--time').click(function (e) {
        e.preventDefault();
        $(this).toggleClass('hide-content');
        $('.time-select').slideToggle(400);
    })
}

//选座位2
function init_BookingTwo() {
    "use strict";
    var price = $('#moviePrice').val();
    var sceneIdd = $('#sceneId').val();
    //form表单
    var numberTicket = $('.choosen-number'),//总票数
        sumTicket = $('.choosen-cost'),//总票价
        onePrice = $('.choosen-price'),//电影单价
        sceneId = $('.choosen-scene'),
        sits = $('.choosen-sits');//座位

    //1. Buttons for choose order method
    $('.order__control-btn').click(function (e) {
        e.preventDefault();
        $('.order__control-btn').removeClass('active');
        $(this).addClass('active');
    });

    //3. 选择座位
    var sum = 0;
    $('.sits__place').click(function (e) {
        e.preventDefault();
        var place = $(this).attr('data-place');
        var ticketPrice = $(this).attr('data-price');

        if (!$(e.target).hasClass('sits-state--your')) {

            if (!$(this).hasClass('sits-state--not')) {
                $(this).addClass('sits-state--your');
                $('.checked-place').prepend('<span class="choosen-place ' + place + '">' + place + '</span>');
                sum += Number(price);
                $('.checked-result').text('$' + sum);
            }
        } else {
            $(this).removeClass('sits-state--your');
            $('.' + place + '').remove();
            sum -= Number(price);
            $('.checked-result').text('$' + sum)
        }

        //data element init
        var number = $('.checked-place').children().length;

        //给form表单赋值
        numberTicket.val(number);
        sumTicket.val(sum);
        onePrice.val(price);
        sceneId.val(sceneIdd);

        //给座位赋值
        var chooseSits = '';
        $('.choosen-place').each(function () {
            chooseSits += ', ' + $(this).text();
        });
        sits.val(chooseSits.substr(2));

    });

    //4 获取上一页传的数据
    var url = decodeURIComponent(document.URL);
    var prevDate = url.substr(url.indexOf('?') + 1);
    //将form数据和上一页数据提交到下一页
    $('.booking-pagination__next').click(function (e) {
        e.preventDefault();
        if (numberTicket.val() == 0) {
            alert("请选择座位！");
        } else {
            var bookData = $(this).serialize();
            var fullData = prevDate + '&' + bookData;
            var action, control = $('.order__control-btn.active').text();
            $('.booking-form').submit();
        }
        $.get(action, fullData, function (data) {
        });
    });

    $('.top-scroll').parent().find('.top-scroll').remove();

}

//搜索框
function init_MovieList() {
    "use strict";

    $('.search__button').click(function (e) {
        e.preventDefault();
        var searchContent = $('.search__field').val().replace(/\s+/g, "");
        var selected = $('#search-sort').val();
        /*var data = {
            searchContent: searchContent,
        };*/
        window.location.href = '/search/' + selected + '/' + searchContent;

    });


    //1. Dropdown init
    //select
    $(".select__sort").selectbox({
        onChange: function (val, inst) {

            $(inst.input[0]).children().each(function (item) {
                $(this).removeAttr('selected');
            });
            $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
        }

    });


    //3. Rating scrore init
    //Rating star
    $('.score').raty({
        width: 130,
        score: 0,
        number: 5,
        hintList: ['1分', '2分', '3分', '4分', '5分'],
        half: true,
        readOnly: true,
        noRatedMsg: '您还没评分！',
        path: '/images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

    //4. Sorting by category
    // sorting function
    $('.tags__item').click(function (e) {
        //prevent the default behaviour of the link
        e.preventDefault();

        //active sorted item
        $('.tags__item').removeClass('item-active');
        $(this).addClass('item-active');

        var filter = $(this).attr('data-filter');

        //show all the list items(this is needed to get the hidden ones shown)
        $(".movie--preview").show();
        $('.pagination').show();

        /*using the :not attribute and the filter class in it we are selecting
            only the list items that don't have that class and hide them '*/
        if (filter.toLowerCase() !== 'all') {
            $('.movie--preview:not(.' + filter + ')').hide();
            //Show pagination on filter = all;
            $('.pagination').hide();
        }
    });

    //5. Toggle function for additional content
    //toggle timetable show
    $('.movie__show-btn').click(function (ev) {
        ev.preventDefault();

        $(this).parents('.movie--preview').find('.time-select').slideToggle(500);
    });

    $('.time-select__item').click(function () {
        $('.time-select__item').removeClass('active');
        $(this).addClass('active');
    });
}

//添加至观看列表
function add(movieId) {
    var userId = $('#watchlist-userId').val();
    var data = {
        userId: userId,
        movieId: movieId,
    };
    $.ajax({
        url: '/api/watch',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        statusCode: {
            200: function () {
                location.reload();
                alert("添加成功");
            },
            400: function () {
                alert("已在观看列表！");
            }
        }
    });

}

//从观看列表移除
function remove(movieId) {
    alert("是否移除");
    $.ajax({
        url: '/api/watch/' + movieId,
        // type:'post',
        method: 'DELETE',
        dataType: 'json',
        statusCode: {
            200: function () {
                location.reload();
            },
            400: function () {
                alert("失败");
            }
        },
    });

}


function init_MoviePage() {
    "use strict";

    //1. Rating scrore init
    //Rating star
    $('.score').raty({
        width: 130,
        score: 5,
        path: '/images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

    //2. 评分
    $('#scoreMovie').click(function () {
        var movieId = $('#rate-movie-id').val();
        var rate = $('#scoreMovie').raty('score');
        var data = {
            movieId: movieId,
            score: rate,
        }
        $.ajax({
            url: '/api/rate',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            statusCode: {
                200: function () {
                    alert("感谢你的评分");
                    location.reload();
                },
                400: function () {
                    alert("您已评过分");

                },
                404: function () {
                    alert("请先登录");
                }
            },
        });
        //
    });


    //4. Dropdown init 
    //select
    $("#select-sort").selectbox({
        onChange: function (val, inst) {

            $(inst.input[0]).children().each(function (item) {
                $(this).removeAttr('selected');
            });
            $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
        }

    });

    //6. Reply comment form
    //reply comment function
    $('.comment__reply').click(function (e) {
        e.preventDefault();

        $('.comment').find('.comment-form').remove();
        $(this).parent().append("<form id='comment-form' class='comment-form' method='post'>\
                            <textarea class='comment-form__text' placeholder='发表您的评论吧'></textarea>\
                            <button type='submit' class='btn btn-md btn--danger comment-form__btn'>发表评论</button>\
                        </form>");

    });

    $('.comment-form__btn').click(function (e) {
        e.preventDefault();

        var movieId = $('#form-movieId').val();
        var content = $('.comment-form__text').val();
        var userId = $('#form-userId').val();
        var data = {
            movieId: movieId,
            content: content,
            userId: userId,
        };
        $.ajax({
            url: '/api/reviews',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            statusCode: {
                200: function () {
                    alert("成功");
                    location.reload();
                },
                400: function () {
                    alert("失败");
                }
            },
        })
    });


    //7. Timetable active element
    $('.time-select__item').click(function () {
        $('.time-select__item').removeClass('active');
        $(this).addClass('active');
    });

    //10. Scroll down navigation function
    //scroll down
    $('.comment-link').click(function (ev) {
        ev.preventDefault();
        $('html, body').stop().animate({'scrollTop': $('.comment-wrapper').offset().top - 90}, 900, 'swing');
    });
}

//评分
function init_Rates() {
    "use strict";

    //1. Rating fucntion
    //Rating star
    $('.score').raty({
        width: 130,
        score: 0,
        path: '/images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

}

function init_SinglePage() {
    "use strict";

    //2. Comment area control

    //reply comment function
    $('.comment__reply').click(function (e) {
        e.preventDefault();

        $('.comment').find('.comment-form').remove();


        $(this).parent().append("<form id='comment-form' class='comment-form' method='post'>\
                            <textarea class='comment-form__text' placeholder='发表您的评论吧'></textarea>\
                            <button type='submit' class='btn btn-md btn--danger comment-form__btn'>发表评论</button>\
                        </form>");
    });
}
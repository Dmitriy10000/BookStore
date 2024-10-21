$(document).ready(function () {
    // $(".carousel__inner").slick({
    //     speed: 300,
    //     autoplay: true,
    //     autoplayspeed: 2000,
    //     // adaptiveHeight: true,
    //     prevArrow:
    //         '<button type="button" class="slick-prev"><img src="css/icons/chevron-left.svg"></button>',
    //     nextArrow:
    //         '<button type="button" class="slick-next"><img src="css/icons/chevron-right.svg"></button>',
    //     responsive: [
    //         {
    //             breakpoint: 992,
    //             settings: {
    //                 arrows: false,
    //                 dots: true,
    //             },
    //         },
    //     ],
    // });

    $('.carousel__inner').slick({
    infinite: true,
    slidesToShow: 4,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    prevArrow: $('.prev'),
    nextArrow: $('.next'),
    });
});


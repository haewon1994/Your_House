$(document).ready(function () {
    $(".tab_menu li a").click(function () {
        var $this = $(this),
            tabId = $this.data("tab"),
            tabIndex = $this.index();

        $(".tab_menu li a, .tab_content li a").removeClass("on");

        $this.addClass("on");
        $("#"+tabId).addClass("on");

        $(".tab_menu li a").each(function (content) {
            $(this).find("img").attr("src", $(this).find("img").attr("src").replace("_off","_on"));
            
            if (tabIndex != content) {
                $(this).find("img").attr("src", $(this).find("img").attr("src").replace("_on","_off"));
            }
        });
    });
})

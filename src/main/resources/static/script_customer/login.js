function setMinHeightForLeftAndRightComponents() {
    var loginLeftComponent = document.querySelector('.login__left');
    var loginRightComponent = document.querySelector('.login__right');
    var innerWidth = window.innerWidth;
    if (innerWidth >= 768) {
        var avaiHeight = window.outerHeight;
        loginLeftComponent.style.minHeight = avaiHeight + 'px';
        loginRightComponent.style.minHeight = avaiHeight + 'px';
    }
    else {
        loginLeftComponent.style.minHeight = 'auto';
        loginRightComponent.style.minHeight = 'auto';
    }
}
function setAnimationWhenFirstLoadingPage() {
    var loginComponent = document.querySelector('.login');
    this.setTimeout(function () {
        loginComponent.classList.add('active');
    }, 200);
}
;
(function () {
    window.addEventListener('load', function () {
        setMinHeightForLeftAndRightComponents();
        setAnimationWhenFirstLoadingPage();
    });
    window.addEventListener('resize', function () {
        setMinHeightForLeftAndRightComponents();
    });
})();

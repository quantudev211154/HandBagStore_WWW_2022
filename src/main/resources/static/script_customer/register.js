function setMinHeightForLeftAndRightComponents() {
    var registerLeftComponent = document.querySelector('.register__left');
    var registerRightComponent = document.querySelector('.register__right');
    var innerWidth = window.innerWidth;
    if (innerWidth >= 768) {
        var avaiHeight = window.outerHeight;
        registerLeftComponent.style.minHeight = avaiHeight + 'px';
        registerRightComponent.style.minHeight = avaiHeight + 'px';
    }
    else {
        registerLeftComponent.style.minHeight = 'auto';
        registerRightComponent.style.minHeight = 'auto';
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

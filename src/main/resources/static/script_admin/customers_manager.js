function toggleMenuOnVerticall(titleContainer, optionsWrapper, icon) {
    titleContainer.onclick = function () {
        optionsWrapper.classList.toggle('active');
        icon.classList.toggle('active');
    };
    window.addEventListener('click', function (e) {
        var target = e.target;
        if (target != titleContainer && target != optionsWrapper) {
            optionsWrapper.classList.remove('active');
            icon.classList.remove('active');
        }
    });
}
;
(function () {
    toggleMenuOnVerticall(document.querySelector('.admin-customer-viewOptions-title'), document.querySelector('.admin-customer-viewOptions'), document.querySelector('.admin-customer-viewOptions-icon'));
})();
(function () {
    toggleMenuOnVerticall(document.querySelector('.order-staticOptions-title'), document.querySelector('.order-staticOptions'), document.querySelector('.order-static-icon'));
})();

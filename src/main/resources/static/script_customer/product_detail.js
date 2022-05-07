;
(function () {
    function resetStatusOfProductColorBtn(productsColorList) {
        for (var i = 0; i < productsColorList.length; ++i) {
            productsColorList[i].classList.remove('active');
        }
    }
    var productsColorList = document.getElementsByClassName('product-color');
    productsColorList[0].classList.add('active');
    var _loop_1 = function (i) {
        var tmpBtn = productsColorList[i];
        tmpBtn.onclick = function () {
            resetStatusOfProductColorBtn(productsColorList);
            tmpBtn.classList.add('active');
        };
    };
    for (var i = 0; i < productsColorList.length; ++i) {
        _loop_1(i);
    }
})();
function canChangeQuantityWhenClikingQuantityBtn(quantity, isMinusBtn) {
    if (isMinusBtn) {
        return (quantity === 1) ? false : true;
    }
    return (quantity === 5) ? false : true;
}
;
(function () {
    var minusBtn = document.querySelector('.product-quantity-subtract');
    var plusBtn = document.querySelector('.product-quantity-add');
    var quantityElement = document.querySelector('.quantity');
    minusBtn.onclick = function (e) {
        var quantity = parseInt(quantityElement.innerText);
        if (canChangeQuantityWhenClikingQuantityBtn(quantity, true)) {
            quantityElement.innerText = --quantity + '';
        }
        else {
            e.preventDefault();
        }
    };
    plusBtn.onclick = function (e) {
        var quantity = parseInt(quantityElement.innerText);
        if (canChangeQuantityWhenClikingQuantityBtn(quantity, false)) {
            quantityElement.innerText = ++quantity + '';
        }
        else {
            e.preventDefault();
        }
    };
})();

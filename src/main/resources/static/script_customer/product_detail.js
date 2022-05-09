function renderBagColorListToBtn(bag) {
    return "\n                    <button class=\"product-color\" value=\"".concat(bag['bagId'], "\">\n                            <span>\n                                ").concat(bag['color'], "\n                            </span>\n                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\"\n                             class=\"svg-icon icon-checked\">\n                            <path d=\"m10 15.586-3.293-3.293-1.414 1.414L10 18.414l9.707-9.707-1.414-1.414z\"></path>\n                        </svg>\n                    </button>\n    ");
}
;
(function () {
    var productColorsList = document.querySelector('.product-info-colors');
    var currentBagCategoryId = document.getElementById("currentBagCategory");
    fetch("http://localhost:8080/api/bags/bagCategory=" + currentBagCategoryId.value)
        .then(function (response) { return response.json(); })
        .then(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; ++i) {
            productColorsList.innerHTML += renderBagColorListToBtn(data[i]);
        }
        getInfoOfBagByIdAndRenderToHtml(data[0]['bagId']);
        animateForColorButton();
    });
})();
function getImageListOfBagByBagIdAndRenderIntoImageContainer(bagId) {
    var imagesContainer = document.querySelector('.product-images');
    imagesContainer.innerHTML = '';
    fetch("http://localhost:8080/bags/" + bagId + "/listBagImages")
        .then(function (response) { return response.json(); })
        .then(function (data) {
        var tmpData = data['_embedded']['bagImages'];
        for (var i = 0; i < tmpData.length; ++i) {
            var imageBase64 = 'data:image/png;base64,' + tmpData[i]['image'];
            imagesContainer.innerHTML += "\n                <figure class=\"product-image\">\n                    <img src=\"".concat(imageBase64, "\" alt=\"\">\n                </figure>\n            ");
        }
    });
}
function getInfoOfBagByIdAndRenderToHtml(bagId) {
    var priceOfBagWithColor = document.querySelector('.product-price');
    var quantityOfBag = document.querySelector('.bag-quantity');
    fetch("http://localhost:8080/bags/" + bagId)
        .then(function (response) { return response.json(); })
        .then(function (data) {
        priceOfBagWithColor.innerHTML = convertFromIntToString(data['price'] + '') + '<span> &#8363</span>';
        quantityOfBag.innerText = data['quantity'];
        getImageListOfBagByBagIdAndRenderIntoImageContainer(bagId);
    });
}
function animateForColorButton() {
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
            getInfoOfBagByIdAndRenderToHtml(parseInt(tmpBtn.value));
        };
    };
    for (var i = 0; i < productsColorList.length; ++i) {
        _loop_1(i);
    }
}
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
(function () {
    var buyOptionsContainer = document.querySelector('.product-buyOptions-container');
    var addToCartBtn = document.querySelector('.product-addToCart');
    var productAlert = document.querySelector('.product-alert');
    addToCartBtn.onclick = function () {
        if (!productAlert.classList.contains('active')) {
            productAlert.classList.add('active');
            setTimeout(function () {
                productAlert.classList.remove('active');
            }, 2000);
        }
    };
})();
function convertFromIntToString(source) {
    var tmp = '';
    var count = 0;
    var result = '';
    var count2 = 0;
    for (var i = source.length - 1; i >= 0; i--) {
        if (count != 3) {
            tmp += source.charAt(i);
            count++;
            count2++;
        }
        if (count == 3 && count2 < source.length) {
            count = 0;
            tmp += '.';
        }
    }
    for (var i = tmp.length - 1; i >= 0; i--) {
        result += tmp.charAt(i);
    }
    return result;
}
function convertFromStringToInt(source) {
    var result = '';
    for (var i = 0; i < source.length; ++i) {
        if (source.charAt(i) != '.') {
            result += source.charAt(i);
        }
    }
    return parseInt(result);
}

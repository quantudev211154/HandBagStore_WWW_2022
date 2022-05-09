var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
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
        for (var i = 0; i < data.length; ++i) {
            productColorsList.innerHTML += renderBagColorListToBtn(data[i]);
        }
        getInfoOfBagByIdAndRenderToHtml(data[0]['bagId']);
        animateForColorButton();
    });
})();
function getAvatarAndFullNameOfReviewOwner(api) {
    return __awaiter(this, void 0, void 0, function () {
        var response, data;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, fetch(api)];
                case 1:
                    response = _a.sent();
                    return [4 /*yield*/, response.json()];
                case 2:
                    data = _a.sent();
                    data = JSON.stringify(data);
                    data = JSON.parse(data);
                    return [2 /*return*/, data];
            }
        });
    });
}
function getReviewListOfBagByBagIdAndRenderToReviewsContainer(bagId) {
    var reviewContainer = document.querySelector('.product-reviews-wrapper');
    var productNum = document.querySelector('.product-num');
    reviewContainer.innerHTML = '';
    fetch("http://localhost:8080/bags/" + bagId + "/listBagReviews")
        .then(function (response) { return response.json(); })
        .then(function (data) {
        var tmpData = data['_embedded']['bagReviews'];
        var reviewNum = tmpData.length;
        productNum.innerText = reviewNum;
        var _loop_1 = function (i) {
            var tmp = getAvatarAndFullNameOfReviewOwner(tmpData[i]['_links']['customer']['href']);
            tmp.then(function (data) {
                var fullname = data.firstName + ' ' + data.lastName;
                var avatar = 'data:image/png;base64,' + data.avatar;
                reviewContainer.innerHTML += "\n                    <div class=\"product-review\">\n                            <div class=\"review-owner\">\n                                <figure class=\"owner-avatar\">\n                                    <img src=\"".concat(avatar, "\" alt=\"\">\n                                </figure>\n                                <div class=\"product-review-detail\">\n                                        <span class=\"owner-name\">\n                                            ").concat(fullname, "\n                                        </span>\n                                    <p class=\"text-sm\">\n                                        \u0110\u00E3 vi\u1EBFt v\u00E0o:\n                                        <span class=\"review-date\">").concat(tmpData[i]['reviewDate'], "</span>\n                                    </p>\n                                </div>\n                            </div>\n                            <div class=\"review-star\">\n                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" style=\"fill: rgba(0, 0, 0, 1);\"\n                                     class=\"svg-icon star star-1\">\n                                    <path d=\"m6.516 14.323-1.49 6.452a.998.998 0 0 0 1.529 1.057L12 18.202l5.445 3.63a1.001 1.001 0 0 0 1.517-1.106l-1.829-6.4 4.536-4.082a1 1 0 0 0-.59-1.74l-5.701-.454-2.467-5.461a.998.998 0 0 0-1.822 0L8.622 8.05l-5.701.453a1 1 0 0 0-.619 1.713l4.214 4.107zm2.853-4.326a.998.998 0 0 0 .832-.586L12 5.43l1.799 3.981a.998.998 0 0 0 .832.586l3.972.315-3.271 2.944c-.284.256-.397.65-.293 1.018l1.253 4.385-3.736-2.491a.995.995 0 0 0-1.109 0l-3.904 2.603 1.05-4.546a1 1 0 0 0-.276-.94l-3.038-2.962 4.09-.326z\"></path>\n                                </svg>\n                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" style=\"fill: rgba(0, 0, 0, 1);\"\n                                     class=\"svg-icon star star-2\">\n                                    <path d=\"m6.516 14.323-1.49 6.452a.998.998 0 0 0 1.529 1.057L12 18.202l5.445 3.63a1.001 1.001 0 0 0 1.517-1.106l-1.829-6.4 4.536-4.082a1 1 0 0 0-.59-1.74l-5.701-.454-2.467-5.461a.998.998 0 0 0-1.822 0L8.622 8.05l-5.701.453a1 1 0 0 0-.619 1.713l4.214 4.107zm2.853-4.326a.998.998 0 0 0 .832-.586L12 5.43l1.799 3.981a.998.998 0 0 0 .832.586l3.972.315-3.271 2.944c-.284.256-.397.65-.293 1.018l1.253 4.385-3.736-2.491a.995.995 0 0 0-1.109 0l-3.904 2.603 1.05-4.546a1 1 0 0 0-.276-.94l-3.038-2.962 4.09-.326z\"></path>\n                                </svg>\n                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" style=\"fill: rgba(0, 0, 0, 1);\"\n                                     class=\"svg-icon star star-3\">\n                                    <path d=\"m6.516 14.323-1.49 6.452a.998.998 0 0 0 1.529 1.057L12 18.202l5.445 3.63a1.001 1.001 0 0 0 1.517-1.106l-1.829-6.4 4.536-4.082a1 1 0 0 0-.59-1.74l-5.701-.454-2.467-5.461a.998.998 0 0 0-1.822 0L8.622 8.05l-5.701.453a1 1 0 0 0-.619 1.713l4.214 4.107zm2.853-4.326a.998.998 0 0 0 .832-.586L12 5.43l1.799 3.981a.998.998 0 0 0 .832.586l3.972.315-3.271 2.944c-.284.256-.397.65-.293 1.018l1.253 4.385-3.736-2.491a.995.995 0 0 0-1.109 0l-3.904 2.603 1.05-4.546a1 1 0 0 0-.276-.94l-3.038-2.962 4.09-.326z\"></path>\n                                </svg>\n                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" style=\"fill: rgba(0, 0, 0, 1);\"\n                                     class=\"svg-icon star star-4\">\n                                    <path d=\"m6.516 14.323-1.49 6.452a.998.998 0 0 0 1.529 1.057L12 18.202l5.445 3.63a1.001 1.001 0 0 0 1.517-1.106l-1.829-6.4 4.536-4.082a1 1 0 0 0-.59-1.74l-5.701-.454-2.467-5.461a.998.998 0 0 0-1.822 0L8.622 8.05l-5.701.453a1 1 0 0 0-.619 1.713l4.214 4.107zm2.853-4.326a.998.998 0 0 0 .832-.586L12 5.43l1.799 3.981a.998.998 0 0 0 .832.586l3.972.315-3.271 2.944c-.284.256-.397.65-.293 1.018l1.253 4.385-3.736-2.491a.995.995 0 0 0-1.109 0l-3.904 2.603 1.05-4.546a1 1 0 0 0-.276-.94l-3.038-2.962 4.09-.326z\"></path>\n                                </svg>\n                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" style=\"fill: rgba(0, 0, 0, 1);\"\n                                     class=\"svg-icon star-5\">\n                                    <path d=\"m6.516 14.323-1.49 6.452a.998.998 0 0 0 1.529 1.057L12 18.202l5.445 3.63a1.001 1.001 0 0 0 1.517-1.106l-1.829-6.4 4.536-4.082a1 1 0 0 0-.59-1.74l-5.701-.454-2.467-5.461a.998.998 0 0 0-1.822 0L8.622 8.05l-5.701.453a1 1 0 0 0-.619 1.713l4.214 4.107zm2.853-4.326a.998.998 0 0 0 .832-.586L12 5.43l1.799 3.981a.998.998 0 0 0 .832.586l3.972.315-3.271 2.944c-.284.256-.397.65-.293 1.018l1.253 4.385-3.736-2.491a.995.995 0 0 0-1.109 0l-3.904 2.603 1.05-4.546a1 1 0 0 0-.276-.94l-3.038-2.962 4.09-.326z\"></path>\n                                </svg>\n                            </div>\n                            <div class=\"review-comment\">").concat(tmpData[i]['comment'], "</div>\n                    </div>\n                ");
            });
        };
        for (var i = 0; i < tmpData.length; ++i) {
            _loop_1(i);
        }
    });
}
function getImageListOfBagByBagIdAndRenderToImageContainer(bagId) {
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
        getImageListOfBagByBagIdAndRenderToImageContainer(bagId);
        getReviewListOfBagByBagIdAndRenderToReviewsContainer(bagId);
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
    var _loop_2 = function (i) {
        var tmpBtn = productsColorList[i];
        tmpBtn.onclick = function () {
            resetStatusOfProductColorBtn(productsColorList);
            tmpBtn.classList.add('active');
            getInfoOfBagByIdAndRenderToHtml(parseInt(tmpBtn.value));
        };
    };
    for (var i = 0; i < productsColorList.length; ++i) {
        _loop_2(i);
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

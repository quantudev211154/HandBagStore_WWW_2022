// function toggleMenuOnVerticall(
//     titleContainer,
//     optionsWrapper,
//     icon
// ): void{
//     titleContainer.onclick = function(){
//         optionsWrapper.classList.toggle('active')
//         icon.classList.toggle('active')
//     }
//     window.addEventListener('click', function(e: Event){
//         let target: object = e.target
//         if (target != titleContainer && target != optionsWrapper){
//             optionsWrapper.classList.remove('active')
//             icon.classList.remove('active')
//         }
//     })
// }
;
(function () {
    var addCateBtn = document.querySelector('.add-category');
    var overlay = document.querySelector('.overlay');
    var categoryContainer = document.querySelector('.category-container');
    var closeCategoryBtn = document.querySelector('.close-category-container');
    addCateBtn.onclick = function () {
        overlay.classList.add('active');
        categoryContainer.classList.add('active');
    };
    overlay.onclick = function () {
        overlay.classList.remove('active');
        categoryContainer.classList.remove('active');
    };
    closeCategoryBtn.onclick = function () {
        overlay.classList.remove('active');
        categoryContainer.classList.remove('active');
    };
})();
;
(function () {
    var prdCoverPhotoContainer = document.getElementById('prdCoverPhoto');
    var chooseCoverPhotoInp = document.getElementById('choosePrdCoverPhoto');
    chooseCoverPhotoInp.onchange = function () {
        var file = chooseCoverPhotoInp.files[0];
        if (file) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function () {
                prdCoverPhotoContainer.src = this.result + '';
            };
        }
    };
})();
(function () {
    var btnAddNewProduct = document.querySelector('.add-prd-btn');
    var prdContainer = document.querySelector('.prd-container');
    btnAddNewProduct.onclick = function () {
        prdContainer.innerHTML += "\n        <div class=\"prd\">\n                            <div class=\"product-delete-container\">\n                                <button class=\"product-delete-btn\">\n                                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\">\n                                        <path d=\"M5 20a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V8h2V6h-4V4a2 2 0 0 0-2-2H9a2 2 0 0 0-2 2v2H3v2h2zM9 4h6v2H9zM8 8h9v12H7V8z\"></path><path d=\"M9 10h2v8H9zm4 0h2v8h-2z\"></path>\n                                    </svg>\n                                    <span class=\"product-delete-title\">Xo\u00E1 s\u1EA3n ph\u1EA9m n\u00E0y</span>\n                                </button>\n                            </div>\n                            <div class=\"prd-info-wrapper\">\n                                    <div class=\"add-comp add-comp-prd comp-color\">\n                                        <span class=\"add-comp-title add-comp-color-title\">M\u00E0u s\u1EAFc</span>\n                                        <input type=\"text\" placeholder=\"VD: Tr\u1EAFng ng\u1ECDc trai\" class=\"add-comp-input add-comp-color-input\">\n                                        <span class=\"add-comp-notify add-comp-color-notify\"></span>\n                                    </div>\n                                    <div class=\"add-comp add-comp-prd comp-quantity\">\n                                        <span class=\"add-comp-title add-comp-quantity-title\">S\u1ED1 l\u01B0\u1EE3ng</span>\n                                        <input type=\"text\" placeholder=\"VD: 20\" class=\"add-comp-input add-comp-quantity-input\">\n                                        <span class=\"add-comp-notify add-comp-quantity-notify\"></span>\n                                    </div>\n                                    <div class=\"add-comp add-comp-prd comp-price\">\n                                        <span class=\"add-comp-title add-comp-price-title\">Gi\u00E1 ni\u00EAm y\u1EBFt</span>\n                                        <input type=\"text\" placeholder=\"VD: 3000000\" class=\"add-comp-input add-comp-price-input\">\n                                        <span class=\"add-comp-notify add-comp-price-notify\"></span>\n                                    </div>\n                                </div>\n                                <div class=\"prd-images-container\">\n                                    <div class=\"prd-images-header\">\n                                        <span>C\u00E1c \u1EA3nh c\u1EE7a s\u1EA3n ph\u1EA9m</span>\n                                        <input type=\"file\" multiple class=\"prd-image-choose\">\n                                    </div>\n                                    <div class=\"prd-images-wrapper\">\n                                            \n                                    </div>\n                                </div>\n                            </div>\n        ";
        (function () {
            var deletePrdBtnList = document.getElementsByClassName('product-delete-btn');
            var _loop_1 = function (i) {
                var tmpBtn = deletePrdBtnList[i];
                tmpBtn.onclick = function () {
                    var prdList = document.getElementsByClassName('prd');
                    prdList[i].remove();
                };
            };
            for (var i = 0; i < deletePrdBtnList.length; ++i) {
                _loop_1(i);
            }
        })();
        (function () {
            var btnAddImageForPrdInpList = document.getElementsByClassName('prd-image-choose');
            var prdImagesWrapperList = document.getElementsByClassName('prd-images-wrapper');
            var _loop_2 = function (i) {
                var tmpAddImgBtn = btnAddImageForPrdInpList[i];
                tmpAddImgBtn.onchange = function () {
                    var imgFileList = tmpAddImgBtn.files;
                    if (imgFileList.length !== 0) {
                        for (var j = 0; j < imgFileList.length; ++j) {
                            var tmpReader = new FileReader();
                            tmpReader.readAsDataURL(imgFileList[j]);
                            tmpReader.onload = function () {
                                var imgSrc = this.result + '';
                                prdImagesWrapperList[i].innerHTML += "\n                                    <figure class=\"prd-image-frame\">\n                                        <img src=\"".concat(imgSrc, "\" alt=\"\" class=\"prd-image\">\n                                    </figure>\n                                ");
                            };
                        }
                    }
                };
            };
            for (var i = 0; i < btnAddImageForPrdInpList.length; ++i) {
                _loop_2(i);
            }
        })();
    };
})();

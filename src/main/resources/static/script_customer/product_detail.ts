function renderBagColorListToBtn(bag: object): string{
    return `
                    <button class="product-color" value="${bag['bagId']}">
                            <span>
                                ${bag['color']}
                            </span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                             class="svg-icon icon-checked">
                            <path d="m10 15.586-3.293-3.293-1.414 1.414L10 18.414l9.707-9.707-1.414-1.414z"></path>
                        </svg>
                    </button>
    `
}

;(function (){
    const productColorsList = document.querySelector('.product-info-colors') as HTMLDivElement
    let currentBagCategoryId = document.getElementById("currentBagCategory") as HTMLInputElement

    fetch("http://localhost:8080/api/bags/bagCategory=" + currentBagCategoryId.value)
        .then(response => response.json())
        .then(data => {
            console.log(data)

            for (let i = 0; i < data.length; ++i){
                productColorsList.innerHTML += renderBagColorListToBtn(data[i])
            }

            getInfoOfBagByIdAndRenderToHtml(data[0]['bagId'])

            animateForColorButton()
        })


})()

function getImageListOfBagByBagIdAndRenderIntoImageContainer(bagId: number): void{
    const imagesContainer = document.querySelector('.product-images') as HTMLDivElement

    imagesContainer.innerHTML = ''

    fetch("http://localhost:8080/bags/" + bagId + "/listBagImages")
        .then(response => response.json())
        .then(data => {
            let tmpData = data['_embedded']['bagImages']

            for (let i = 0; i < tmpData.length; ++i){
                let imageBase64: string = 'data:image/png;base64,' + tmpData[i]['image']

                imagesContainer.innerHTML += `
                <figure class="product-image">
                    <img src="${imageBase64}" alt="">
                </figure>
            `
            }
        })
}

function getInfoOfBagByIdAndRenderToHtml(bagId: number): void{
    const priceOfBagWithColor = document.querySelector('.product-price') as HTMLHeadingElement
    const quantityOfBag = document.querySelector('.bag-quantity') as HTMLSpanElement

    fetch("http://localhost:8080/bags/" + bagId)
        .then(response => response.json())
        .then(data => {
            priceOfBagWithColor.innerHTML = convertFromIntToString(data['price'] + '') + '<span> &#8363</span>'
            quantityOfBag.innerText = data['quantity']

            getImageListOfBagByBagIdAndRenderIntoImageContainer(bagId)
        })
}

function animateForColorButton(): void{
    function resetStatusOfProductColorBtn(productsColorList: HTMLCollection){
        for (let i = 0; i < productsColorList.length; ++i){
            productsColorList[i].classList.remove('active')
        }
    }

    const productsColorList = document.getElementsByClassName('product-color') as HTMLCollection

    productsColorList[0].classList.add('active')

    for (let i = 0; i < productsColorList.length; ++i){
        let tmpBtn = productsColorList[i] as HTMLButtonElement

        tmpBtn.onclick = function(){
            resetStatusOfProductColorBtn(productsColorList)

            tmpBtn.classList.add('active')

            getInfoOfBagByIdAndRenderToHtml(parseInt(tmpBtn.value))
        }
    }
}

function canChangeQuantityWhenClikingQuantityBtn(quantity: number, isMinusBtn: boolean): boolean{
    if (isMinusBtn){
        return (quantity === 1) ? false : true
    }

    return (quantity === 5) ? false : true;
}

;(function(){
    const minusBtn = document.querySelector('.product-quantity-subtract') as HTMLButtonElement
    const plusBtn = document.querySelector('.product-quantity-add') as HTMLButtonElement
    const quantityElement = document.querySelector('.quantity') as HTMLSpanElement

    minusBtn.onclick = function(e: Event){
        let quantity: number = parseInt(quantityElement.innerText)

        if (canChangeQuantityWhenClikingQuantityBtn(quantity, true)){
            quantityElement.innerText = --quantity + ''
        }
        else{
            e.preventDefault()
        }

    }

    plusBtn.onclick = function(e: Event){
        let quantity: number = parseInt(quantityElement.innerText)

        if (canChangeQuantityWhenClikingQuantityBtn(quantity, false)){
            quantityElement.innerText = ++quantity + ''
        }
        else{
            e.preventDefault()
        }
    }
})()

;(function(){
    const buyOptionsContainer = document.querySelector('.product-buyOptions-container') as HTMLDivElement
    const addToCartBtn = document.querySelector('.product-addToCart') as HTMLButtonElement
    const productAlert = document.querySelector('.product-alert') as HTMLDivElement

    addToCartBtn.onclick = function(){
        if (!productAlert.classList.contains('active')){
            productAlert.classList.add('active')

            setTimeout(function(){
                productAlert.classList.remove('active')
            }, 2000)
        }
    }
})()

function convertFromIntToString(source: string): string{
    var tmp = ''
    var count = 0
    var result = ''
    var count2 = 0
    for (let i = source.length - 1; i >= 0; i--){
        if (count != 3){
            tmp += source.charAt(i)
            count++;
            count2++
        }
        if (count == 3 && count2 < source.length){
            count = 0
            tmp += '.'
        }
    }
    for (let i = tmp.length - 1; i >= 0; i--){
        result += tmp.charAt(i)
    }
    return result
}

function convertFromStringToInt(source){
    var result = ''
    for (let i = 0; i < source.length; ++i){
        if (source.charAt(i) != '.'){
            result += source.charAt(i)
        }
    }
    return parseInt(result)
}
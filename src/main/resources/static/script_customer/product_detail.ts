;(function(){
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
        }
    }
})()

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

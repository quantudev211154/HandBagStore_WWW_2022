function toggleMenuOnVertical(
    titleContainer,
    optionsWrapper,
    icon
): void{
    titleContainer.onclick = function(e: Event){
        optionsWrapper.classList.toggle('active')
        icon.classList.toggle('active')
    }

    window.addEventListener('click', function(e: Event){
        let target: object = e.target

        if (target != titleContainer && target != optionsWrapper){
            optionsWrapper.classList.remove('active')
            icon.classList.remove('active')
        }
    })
}

;(function(){
    const adminOrderViewOptionTitle = document.querySelector('.admin-order-viewOptions-title') as HTMLDivElement
    const adminOrderViewOptions = document.querySelector('.admin-order-viewOptions') as HTMLDivElement
    const adminOrderViewOptionsIcon = document.querySelector('.admin-order-viewOptions-icon') as SVGElement

    toggleMenuOnVertical(adminOrderViewOptionTitle, adminOrderViewOptions, adminOrderViewOptionsIcon)
})()

;(function(){
    const orderSearchInput = document.querySelector('.order-search-input') as HTMLInputElement
    const searchOrderSuggesstionContainer = document.querySelector('.search-order-suggesstion-container') as HTMLDivElement

    orderSearchInput.addEventListener('input', function(){
        searchOrderSuggesstionContainer.classList.toggle('active')
        searchOrderSuggesstionContainer.innerHTML = `
        <a href="" class="order-search-suggesstion">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" style="fill: rgba(0, 0, 0, 1);"
                                class="">
                                    <path d="M10 18a7.952 7.952 0 0 0 4.897-1.688l4.396 4.396 1.414-1.414-4.396-4.396A7.952 7.952 0 0 0 18 10c0-4.411-3.589-8-8-8s-8 3.589-8 8 3.589 8 8 8zm0-14c3.309 0 6 2.691 6 6s-2.691 6-6 6-6-2.691-6-6 2.691-6 6-6z"></path>
                                </svg>
                                <span class="search-order-cusPhone">0368526122</span>
                                <span class="search-order-orderDate">12-5-2020 11:30:23</span>
                                <span class="search-order-status">Đã giao</span>
                            </a>
        `
    })
})()

;(function(){
    const orderStaticOptionsTitle = document.querySelector('.order-staticOptions-title') as HTMLDivElement
    const orderStaticIcon = document.querySelector('.order-static-icon') as SVGElement
    const orderStaticOptions = document.querySelector('.order-staticOptions') as HTMLDivElement

    toggleMenuOnVertical(orderStaticOptionsTitle, orderStaticOptions, orderStaticIcon)

    const orderStaticOptionList = document.getElementsByClassName('order-static-option') as HTMLCollection
    const orderStaticOptionName = document.querySelector('.order-static-option-name') as HTMLSpanElement

    for (let i = 0; i < orderStaticOptionList.length; ++i){
        let tmp = orderStaticOptionList[i] as HTMLButtonElement

        tmp.addEventListener('click', function (){
            let optionText = tmp.innerText

            orderStaticOptionName.innerText = optionText

            orderStaticOptions.classList.remove('active')
        })
    }
})()
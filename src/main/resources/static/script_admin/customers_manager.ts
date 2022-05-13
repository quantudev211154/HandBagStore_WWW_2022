function toggleMenuOnVerticall(
    titleContainer,
    optionsWrapper,
    icon
): void{
    titleContainer.onclick = function(){
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
    toggleMenuOnVerticall(
        document.querySelector('.admin-customer-viewOptions-title') as HTMLDivElement,
        document.querySelector('.admin-customer-viewOptions') as HTMLDivElement,
        document.querySelector('.admin-customer-viewOptions-icon') as SVGElement
    )
})()

;(function(){
    toggleMenuOnVerticall(
        document.querySelector('.order-staticOptions-title') as HTMLDivElement,
        document.querySelector('.order-staticOptions') as HTMLDivElement,
        document.querySelector('.order-static-icon') as SVGElement
    )
})()
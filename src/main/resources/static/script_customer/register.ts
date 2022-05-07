function setMinHeightForLeftAndRightComponents(): void{
    const registerLeftComponent: HTMLElement = document.querySelector('.register__left')
    const registerRightComponent: HTMLElement = document.querySelector('.register__right')

    let innerWidth: number = window.innerWidth

    if (innerWidth >= 768){
        let avaiHeight = window.outerHeight

        registerLeftComponent.style.minHeight = avaiHeight + 'px'
        registerRightComponent.style.minHeight = avaiHeight + 'px'
    }
    else{
        registerLeftComponent.style.minHeight = 'auto'
        registerRightComponent.style.minHeight = 'auto'
    }
}

function setAnimationWhenFirstLoadingPage(): void{
    const loginComponent: HTMLElement = document.querySelector('.login')

    this.setTimeout(function(){
        loginComponent.classList.add('active')
    }, 200)
}

;(function(){
    window.addEventListener('load', function(){
        setMinHeightForLeftAndRightComponents()
        setAnimationWhenFirstLoadingPage()
    })

    window.addEventListener('resize', function(){
        setMinHeightForLeftAndRightComponents()
    })
})();